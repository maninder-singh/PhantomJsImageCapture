/**
 * Created by maninders on 6/11/15.
 */

function getImage(){
    var imageUrl = "http://localhost:8080/PhantomJsImageCapture/webpage";
    $.ajax({
        url : imageUrl,
        success : function (result) {
            $("#imageDivId").attr("src",result.data);
        },
        error : function(error,status){
            console.log("error : " + error);
        }
    });
}