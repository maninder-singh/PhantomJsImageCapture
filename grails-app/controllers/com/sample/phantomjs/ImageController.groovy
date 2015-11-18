package com.sample.phantomjs

import grails.converters.JSON
import org.apache.commons.codec.binary.Base64
import org.apache.commons.codec.binary.StringUtils
class ImageController {

    ImageService imageService

    def index() { }

    def getWebPageAsImage(){

        def data = request.JSON
        def webPageUrl = data["webPageUrl"] as String
        def result = [:]
        def imageData = imageService.getWebPageAsImage(webPageUrl)
//        result.put("data","data:image/png;base64," + new String(Base64.encodeBase64(imageData)))
        StringBuilder sb = new StringBuilder()
        sb.append("data:image/png;base64,")
        sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(imageData,false)))
        result.put("data",sb.toString())
        render result as JSON
    }
}
