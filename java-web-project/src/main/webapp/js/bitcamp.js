var Bitcamp = function(arg1) {
  var arr = [];

  if (arg1 instanceof HTMLElement) {
    arr.push(arg1);
  } else {
    var el = document.querySelectorAll(arg1);

    for (var e of el) {
      arr.push(e);
    } 
  }

  arr.html = function(value) {
    if (arguments.length > 0) {
      for (var e of this) {
        e.innerHTML = value;
      }
    } else {
      return this[0].innerHTML;
    }
  };

  arr.addClass = function(value) {
    for (var e of this) {
      var cn = '';
      var names = e.className.split(' ');
      for (var name of names) {
        cn = cn + ' ' + name;
      }
      e.className = cn;
    }
  };

  arr.removeClass = function(value) {
    for (var e of this) {
      var cn = '';
      var names = e.className.split(' ');
      for (var name of names) {
        if (name == value)
          continue;
        cn = cn + ' ' + name;
      }
      e.className = cn;
    }
  };

  arr.click = function(cb) {
    for (var e of this) {
      e.addEventListener('click', cb);
    }
  };
  
  arr.bind = function(eventType, handler) {
    for (var e of this) {
      e.addEventListener(eventType, handler);
    }
  };

  return arr;
};

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
