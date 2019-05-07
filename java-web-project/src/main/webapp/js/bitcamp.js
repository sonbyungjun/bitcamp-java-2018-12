var Bitcamp = {};

Bitcamp.ajax = function(url, settings) {
  if (settings == undefined || settings == null) {
    settings = {};
  }
  if (!settings.method) {
    settings.method = 'GET';
  }
  if (!settings.dataType) {
    settings.dataType = 'text';
  }
  
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (xhr.readyState != 4)
      return;
    if (xhr.status != 200) {
      if (settings.error){
        settings.error();
      }
      return;
    }
    if (settings.success) {
      if (settings.dataType == 'json') {
        settings.success(JSON.parse(xhr.responseText));
      } else {
        settings.success(xhr.responseText);
      }
    }
  };
  xhr.open(settings.method, url, true);
  xhr.send();
};

Bitcamp.getJSON = function(url, success) {
  Bitcamp.ajax(url, {
    "dataType": 'json',
    "success": success
  });
}

var $ = Bitcamp;
