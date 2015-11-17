package com.sample.phantomjs

import grails.converters.JSON
import org.apache.commons.codec.binary.Base64

class ImageController {

    ImageService imageService

    def index() { }

    def getWebPageAsImage(){

        def data = request.JSON
        def webPageUrl = data["webPageUrl"] as String
        def result = [:]
        def imageData = imageService.getWebPageAsImage(webPageUrl)
        result.put("data","data:image/png;base64," + new String(Base64.encodeBase64(imageData)))
        render result as JSON
    }
}
