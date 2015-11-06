
class UrlMappings {

	static mappings = {
        "/webpage"(controller: "image",parseRequest: true){
                action = [
                        GET : "getWebPageAsImage"
                ]
        }
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
