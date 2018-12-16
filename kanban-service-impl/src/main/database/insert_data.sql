insert into ticket (title, description, status) values ('Write some code', 'Code along with the samples in the book. The complete source can be found at [github](https://github.com/pro-react)','todo');
insert into ticket (title, description, status) values ('Read the book', 'I should read the whole book','in-progress');

insert into task (name, done, ticket_id) values ('ContactList Example', 1, 1);
insert into task (name, done, ticket_id) values ('Kanban Example', 0, 1);
insert into task (name, done, ticket_id) values ('My Own Experiments', 0, 1);
