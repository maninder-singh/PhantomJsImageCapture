/**
 * Created by maninders on 6/11/15.
 */

function getImage(){
    var baseUrl = "http://localhost:8080/PhantomJsImageCapture/webpage";
    var webPageUrl = $("#webPageUrlId").val();
    var jsonData = {
        webPageUrl : webPageUrl
    };
    $.ajax({
        url : baseUrl,
        type : "POST",
        dataType : "json",
        contentType : "application/json",
        data : JSON.stringify(jsonData),
        success : function (result) {
            $("#imageDivId").attr("src",result.data);
        },
        error : function(error,status){
            console.log("error : " + error);
        }
    });
}