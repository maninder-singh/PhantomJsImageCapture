package com.sample.phantomjs

import grails.transaction.Transactional

import javax.imageio.ImageIO

@Transactional
class ImageService {

    def getWebPageAsImage(def webPageUrl) {

        def filePath = this.class.classLoader.getResource("image_capture").getPath().toString()
        def jsFilePath = filePath + "/javascripts/image-capture.js"
        def screenshotPath = filePath + "/images/capture_webpage.png"
        def phantomJsShell = "phantomjs ${jsFilePath} ${webPageUrl} ${screenshotPath}"
        phantomJsShell.execute()
        sleep(4000)
        def image = ImageIO.read(new File(screenshotPath))
        def imageWriter = new ByteArrayOutputStream()
        ImageIO.write(image,"png",imageWriter)
        def imageBytes = imageWriter.toByteArray()
        imageBytes
    }
}