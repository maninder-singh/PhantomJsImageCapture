
class UrlMappings {

	static mappings = {
        "/webpage"(controller: "image",parseRequest: true){
                action = [
                        POST : "getWebPageAsImage"
                ]
        }
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
