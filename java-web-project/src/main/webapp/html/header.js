//헤더 가져오기
(function() {
  var header = document.querySelector('.bit-main-header');
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (xhr.readyState != 4 || xhr.status != 200) 
      return;
    header.innerHTML = xhr.responseText;
    var e = new Event('loaded.header');
    document.body.dispatchEvent(e);
  };
  xhr.open('GET', '/java-web-project/html/header.html', true);
  xhr.send();
})();

document.body.addEventListener('loaded.header', () => {
  loadLoginUser();
  document.querySelector('#logout-menu').addEventListener('click', (e) => {
    e.preventDefault();
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
      if (xhr.readyState != 4 || xhr.status != 200) 
        return;
      var data = JSON.parse(xhr.responseText);
      location.href = '/java-web-project/html/index.html';
    };
    xhr.open('GET', '/java-web-project/app/json/auth/logout', true);
    xhr.send();
  });
});

function loadLoginUser() {
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (xhr.readyState != 4 || xhr.status != 200) 
      return;
    var data = JSON.parse(xhr.responseText);
    var loginState = document.querySelector('#bit-login-state'),
        notLoginState = document.querySelector('#bit-not-login-state');
    if (data.status == 'success') {
      loginState.className = loginState.className.replace('bit-invisible', '');
      document.querySelector('#login-username').innerHTML = data.user.name;
      document.querySelector('#login-userphoto').src = '/java-web-project/upload/member/' + data.user.photo;
      document.querySelector('#login-userphoto-a').href = '/java-web-project/upload/member/' + data.user.photo;
      document.querySelector('#login-userphoto-b').src = '/java-web-project/upload/member/' + data.user.photo;
    } else {
      notLoginState.className = notLoginState.className.replace('bit-invisible', '');
    }
  };
  xhr.open('GET', '/java-web-project/app/json/auth/user', true);
  xhr.send();
}