create database kanban_board;

use kanban_board;

create table ticket (
  id int(11) auto_increment not null,
  title varchar(50) not null,
  description varchar(500),
  status varchar(20) not null,
  primary key (id)
);

create table task (
  id int(11) auto_increment not null,
  name varchar(100) not null,
  done tinyint(1) not null,
  ticket_id int not null,
  primary key (id),
  foreign key (ticket_id) references ticket (id)
);

insert into ticket (title, description, status) values ('Write some code', 'Code along with the samples in the book. The complete source can be found at [github](https://github.com/pro-react)','todo');
insert into ticket (title, description, status) values ('Read the book', 'I should read the whole book','in-progress');

insert into task (name, done, ticket_id) values ('ContactList Example', 1, 1);
insert into task (name, done, ticket_id) values ('Kanban Example', 0, 1);
insert into task (name, done, ticket_id) values ('My Own Experiments', 0, 1);
