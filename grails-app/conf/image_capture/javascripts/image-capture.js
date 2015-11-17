var page = require('webpage').create();
var system = require("system");
var args = system.args;
page.viewportSize = { width: 1024, height: 768 };
//page.clipRect = { top: 0, left: 0, width: 102, height: 100 }; //  crop specific part of image
page.open(args[1], function () {
    //page.render('grails-app/conf/image_capture/images/webpage_image.png');
    page.render(args[2]);
    phantom.exit();
});