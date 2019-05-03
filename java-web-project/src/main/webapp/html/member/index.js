var pageNo = 1,
    pageSize = 3,
    tbody = document.querySelector('tbody');

loadList(1);

// 데이터 목록 가져오기
function loadList(pn) {
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (xhr.readyState != 4 || xhr.status != 200) 
      return;
    
    var obj = JSON.parse(xhr.responseText);

    pageNo = obj.pageNo;
    
    tbody.innerHTML = '';
    for (data of obj.list) {
      var tr = '<tr>'
      + '<th scope="row">' + data.no + '</th>'
      + '<td>' + '<a class="bit-view-link alert-link" href="#" data-no="' + data.no + '">' + data.name + '</td>'
      + '<td>' + data.email + '</td>'
      + '<td>' + data.tel + '</td>'
      + '<td>' + data.registeredDate + '</td>'
      + '</tr>';
      tbody.innerHTML += tr;
    }
    
    // 페이지네이션 뷰
    var resultTag = '<li id="prevPage" class="page-item disabled"><a class="page-link" href="#">&laquo;</a></li>\n';
    for (var i = 1; i <= obj.totalPage; i++) {
      resultTag += '<li class="page-item ' + (pn == i ? 'active' : '') + '"><a class="page-link bit-page-no" href="#" data-pageno="' + i + '">' + i + '</a></li>\n';
    }
    resultTag += '<li id="nextPage" class="page-item "><a class="page-link" href="#"">&raquo;</a></li>\n';
    document.querySelector('#bit-page').innerHTML = resultTag;
    
    
    if (pageNo == 1) {
      document.querySelector('#prevPage').className += ' disabled';
    } else {
      document.querySelector('#prevPage').className = document.querySelector('#prevPage').className.replace(' disabled', '');
    }
    
    if (pageNo == obj.totalPage) {
      document.querySelector('#nextPage').className += ' disabled';
    } else {
      document.querySelector('#nextPage').className = document.querySelector('#nextPage').className.replace(' disabled', '');
    }
    
    document.body.dispatchEvent(new Event('loaded-list'));
  };
  xhr.open('GET', '../../app/json/member/list?pageNo=' + pn + '&pageSize=' + pageSize, true);
  xhr.send();
} //loadList() 

document.body.addEventListener('loaded-list', () => {

  document.querySelector('#prevPage > a').onclick = (e) => {
    e.preventDefault();
    loadList(pageNo - 1);
  };
  
  document.querySelector('#nextPage > a').onclick = (e) => {
    e.preventDefault();
    loadList(pageNo + 1);
  };
  
  // 페이지네이션 처리(번호클릭)
  var currPageList = document.querySelectorAll('.bit-page-no');
  for (var i = 0; i < currPageList.length; i++) {
    currPageList[i].onclick = (e) => {
      e.preventDefault();
      loadList(e.target.getAttribute('data-pageno'));
    };
  }
  
  // 제목 클릭 했을 때 view.html 전환
  var alist = document.querySelectorAll('.bit-view-link');
  for (a of alist) {
    a.onclick = (e) => {
      e.preventDefault();
      window.location.href = 'view.html?no=' + e.target.getAttribute('data-no');
    };
  }
  
})
