package com.sample.phantomjs

import grails.converters.JSON
import org.apache.commons.codec.binary.Base64

class ImageController {

    ImageService imageService

    def index() { }

    def getWebPageAsImage(){

        def result = [:]
        def imageData = imageService.getWebPageAsImage()
        result.put("data","data:image/png;base64," + new String(Base64.encodeBase64(imageData)))
        render result as JSON
    }
}
