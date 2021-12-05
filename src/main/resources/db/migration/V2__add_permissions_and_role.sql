insert into role (id, name)
values (1,'USER');
insert into role (id, name)
values (2,'MODERATOR');
insert into role (id, name)
values (3,'ADMIN');
insert into role (id, name)
values (4,'OVERLORD');


insert into permissions (permissions, role_id)
values ('SAVE_OWN_POST',1);
insert into permissions (permissions, role_id)
values ('DELETE_OWN_POST',1);
insert into permissions (permissions, role_id)
values ('MODERATE_OWN_POST',1);
insert into permissions (permissions, role_id)
values ('SAVE_OWN_COMMENT',1);
insert into permissions (permissions, role_id)
values ('DELETE_OWN_COMMENT',1);
insert into permissions (permissions, role_id)
values ('MODERATE_OWN_COMMENT',1);
insert into permissions (permissions, role_id)
values ('BAN_USER',3);
insert into permissions (permissions, role_id)
values ('UNBAN_USER',3);
insert into permissions (permissions, role_id)
values ('MODERATE_POST',2);
insert into permissions (permissions, role_id)
values ('DELETE_POST',2);
insert into permissions (permissions, role_id)
values ('MODERATE_COMMENT',2);
insert into permissions (permissions, role_id)
values ('DELETE_COMMENT',2);
insert into permissions (permissions, role_id)
values ('CALL_THE_POLICE',4);


