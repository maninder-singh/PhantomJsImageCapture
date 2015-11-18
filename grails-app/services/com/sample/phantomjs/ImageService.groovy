package com.sample.phantomjs

import grails.transaction.Transactional

import javax.imageio.ImageIO
import java.awt.image.BufferedImage

@Transactional
class ImageService {

    def getWebPageAsImage(def webPageUrl) {

        def filePath = this.class.classLoader.getResource("image_capture").getPath().toString()
        def jsFilePath = filePath + "/javascripts/image-capture.js"
        def screenshotPath = filePath + "/images/capture_webpage.png"
        def phantomJsShell = "phantomjs ${jsFilePath} ${webPageUrl} ${screenshotPath}"
        def imageWriter = new ByteArrayOutputStream()
        def numberOfAttempt = 10
        def countNumberOfAttempt = 0
        def isFileCreated = false
        BufferedImage image;
        File file
        try {
            phantomJsShell.execute()
//            sleep(4000)

            while (countNumberOfAttempt < numberOfAttempt)
            {
                file = new File(screenshotPath)
                if(file.exists()){
                    isFileCreated = true
                    break
                }else {
                    countNumberOfAttempt++
                    sleep(1000)
                }
            }
            if(isFileCreated){
                image = ImageIO.read(file)
                ImageIO.write(image,"png",imageWriter)
                def imageBytes = imageWriter.toByteArray()
                def isDeleted = file.delete()
                imageBytes
            }
        }
        catch (Exception ex){
        }
        finally {
            if(file.exists()){
                def isDeleted = file.delete()
            }
            if(imageWriter != null){
                imageWriter.flush()
                imageWriter.close()
            }
            if(image != null){
                image.flush()
            }
        }
    }
}