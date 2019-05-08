var Bitcamp = function(arg1) {
  var arr = [];

  if (arg1 instanceof HTMLElement) {
    arr.push(arg1);

  } else if (arg1.startsWith('<')) {
    var tagName = arg1.substr(1, arg1.length - 2);
    arr.push(document.createElement(tagName));

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
      return this;
    } else {
      return this[0].innerHTML;
    }
  };

  arr.addClass = function(value) {
    for (var e of this) {
      var cn = value;
      var names = e.className.split(' ');
      for (var name of names) {
        cn = cn + ' ' + name;
      }
      e.className = cn;
    }
    return this;
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
    return this;
  };

  arr.click = function(cb) {
    for (var e of this) {
      e.addEventListener('click', cb);
    }
    return this;
  };

  arr.bind = function(eventType, handler) {
    for (var e of this) {
      e.addEventListener(eventType, handler);
    }
    return this;
  };

  arr.attr = function(name, value) {
    if (arguments.length < 2) {
      return this[0].getAttribute(name);
    } else {
      for (var e of this) {
        e.setAttribute(name, value);
      }
      return this;
    }
  };

  arr.trigger = function(eventType) {
    for (var e of this) {
      e.dispatchEvent(new Event(eventType));
    }
    return this;
  };

  arr.append = function(childs) {
    for (var parent of this) {
      for (var child of childs) {
        parent.appendChild(child);
      }
    }
    return this;
  };

  arr.appendTo = function(parents) {
    for (var parent of parents) {
      for (var child of this) {
        parent.appendChild(child);
      }
    }
    return this;
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
