drop table board;

create table board (
  no int not null primary key auto_increment,
  contents text null,
  created_date datetime not null default now(),
  view_count int null default 0
);

create table lesson (
  no int not null primary key auto_increment,
  contents text null,
  created_date datetime null default now(),
  view_count int null default 0
);

create table member (
  no int not null primary key auto_increment,
  contents text null,
  created_date datetime null default now(),
  view_count int null default 0
);


insert into board(contents) values(?);

select * from board order by no desc;
  
select * from board where no = ?;
  
update board set contents = ?, created_date = ? where no = ?;

delete from board where no = ?;















