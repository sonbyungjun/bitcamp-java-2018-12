drop table x_board;

create table x_board (
  board_id int not null primary key auto_increment,
  title varchar(255) not null,
  contents text null,
  created_date datetime null default now(),
  view_count int null default 0
);

insert into x_board(title, contents) 
values('제목1', '내용');

insert into x_board(title, contents) 
values('제목2', '내용');

insert into x_board(title, contents) 
values('제목3', '내용');

insert into x_board(title, contents) 
values('제목4', '내용');

insert into x_board(title, contents) 
values('제목5', '내용');

insert into x_board(title, contents) 
values('제목6', '내용');

select
  *
from
  x_board
order by board_id desc;
  
  
select
  board_id,
  title,
  contents,
  created_date,
  view_count
from
  x_board
where 
  board_id = 3;
  
update x_board set
  view_count = view_count + 1,
  created_date = now()
where
  board_id = 3;

delete from x_board
where
  board_id = 3;















