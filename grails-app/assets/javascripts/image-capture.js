var page = require('webpage').create();
var system = require("system");
var args = system.args;
page.open("https://www.google.co.in", function () {
    page.render('demo1.png');
    phantom.exit();
});