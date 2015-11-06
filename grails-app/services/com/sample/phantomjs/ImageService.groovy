package com.sample.phantomjs

import grails.transaction.Transactional

import javax.imageio.ImageIO

@Transactional
class ImageService {

    def getWebPageAsImage() {

        def phantomJsShell = "phantomjs /home/maninders/source_code/grails/PhantomJsImageCapture/grails-app/assets/javascripts/image-capture.js http://localhost:8080/PhantomJsImageCapture/webpage";
        phantomJsShell.execute()
        def image = ImageIO.read(new File("/home/maninders/source_code/grails/PhantomJsImageCapture/grails-app/assets/javascripts/demo1.png"))
        def imageWriter = new ByteArrayOutputStream()
        ImageIO.write(image,"png",imageWriter)
        def imageBytes = imageWriter.toByteArray()
        imageBytes
    }
}
