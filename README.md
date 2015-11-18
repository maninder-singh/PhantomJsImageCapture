# PhantomJsImageCapture 

Demo application for capture web page as image using [PhantomJs](http://phantomjs.org/)

### Install PhantomJs

```
sudo apt-get install phantomjs
```

### Setup Grails app `PhantomJsImageCapture`

1. `git clone git@git1.affinnova.com:msingh/PhantomJsImageCapture.git`
2. `cd PhantomJsImageCapture`
3. `grails run-app`

### Endpoint's available

Save the webpage on server and send the datauri of webpage
```
curl --header "Content-type: application/json" --request POST --data '{"webPageUrl":"{web-page-url}"}' -v http://localhost:8080/PhantomJsImageCapture/webpage

Note : 
{web-page-url} : url of webpage

image is saved on following location : PhantomJsImageCapture/target/work/resources/image_capture/images/
```

### Play with it

Browse this url `http://localhost:8080/PhantomJsImageCapture/index.html`
