/**
 * Created by maninders on 6/11/15.
 */

function getImage(){
    var baseUrl = "http://localhost:8080/PhantomJsImageCapture/webpage";
    var webPageUrl = $("#webPageUrlId").val();
    var data = {};
    data["webPageUrl"] = webPageUrl;
    $.ajax({
        url : baseUrl,
        type : "POST",
        data : '{"webPageUrl" : "' + webPageUrl + '"}',
        success : function (result) {
            $("#imageDivId").attr("src",result.data);
        },
        error : function(error,status){
            console.log("error : " + error);
        }
    });
}