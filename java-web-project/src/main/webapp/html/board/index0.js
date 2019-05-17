var pageNo = 1,
pageSize = 3,
tbody = $('tbody'),
prevPageLi = $('#prevPage'),
nextPageLi = $('#nextPage'),
currSpan = $('#currPage > span');

//데이터 목록 가져오기
function loadList(pn) {

  $.getJSON('../../app/json/board/list?pageNo=' + pn + '&pageSize=' + pageSize, function(obj) {
    pageNo = obj.pageNo;
    tbody.html('');
    for (data of obj.list) {
      $('<tr>')
      .append($('<th>').attr('scope', 'row').html(data.no))
      .append($('<td>').append($('<a>').addClass('bit-view-link').attr('href', '#').attr('data-no', data.no).html(data.contents)))
      .append($('<td>').html(data.createdDate))
      .append($('<td>').html(data.viewCount))
      .appendTo(tbody);
    }

    currSpan.html(String(pageNo));

    if (pageNo == 1) {
      prevPageLi.addClass(' disabled');
    } else {
      prevPageLi.removeClass(' disabled');
    }
    if (pageNo == obj.totalPage) {
      nextPageLi.addClass(' disabled');
    } else {
      nextPageLi.removeClass(' disabled');
    }

    $(document.body).trigger('loaded-list');

  }); // Bitcamp.getJSON()
} //loadList() 

$('#prevPage > a').click((e) => {
  e.preventDefault();
  loadList(pageNo - 1);
});

$('#nextPage > a').click((e) => {
  e.preventDefault();
  loadList(pageNo + 1);
});

loadList(1);

$(document.body).bind('loaded-list', () => {
  // 제목을 클릭 했을 때 view.html로 전환시키기
  $('.bit-view-link').click((e) => {
    e.preventDefault();
    window.location.href = 'view.html?no=' + $(e.target).attr('data-no');
  });
});

