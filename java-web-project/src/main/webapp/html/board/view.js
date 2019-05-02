var header = header = document.querySelector('body > header');

//헤더 가져오기
(function() {
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (xhr.readyState != 4 || xhr.status != 200) 
      return;
    header.innerHTML = xhr.responseText;
    
  };
  xhr.open('GET', '../header.html', true);
  xhr.send();
})();

var param = location.href.split('?')[1];
if (param) {
  loadData(param.split('=')[1]);
}

function loadData(no) {
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (xhr.readyState != 4 || xhr.status != 200) 
      return;
    var data = JSON.parse(xhr.responseText);
    document.querySelector('#no').value = data.no;
    document.querySelector('#contents').value = data.contents;
    document.querySelector('#viewCount').value = data.viewCount;
    document.querySelector('#createdDate').value = data.createdDate;
  };
  xhr.open('GET', '../../app/json/board/detail?no=' + no, true);
  xhr.send();
}