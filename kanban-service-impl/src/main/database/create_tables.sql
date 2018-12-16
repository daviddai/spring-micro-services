use kanban_board;

create table ticket (
  id int auto_increment not null,
  title varchar(50) not null,
  description varchar(500),
  status varchar(20) not null,
  primary key (id)
);

create table task (
  id int auto_increment not null,
  name varchar(100) not null,
  done tinyint(1) not null,
  ticket_id int not null,
  primary key (id),
  foreign key (ticket_id) references ticket (id)
);