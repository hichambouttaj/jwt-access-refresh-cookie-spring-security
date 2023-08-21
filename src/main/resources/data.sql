-- create roles
insert into roles (id, name) value (1, 'ADMIN');
insert into roles (id, name) value (2, 'MANAGER');
insert into roles (id, name) value (3, 'USER');

-- create permissions
insert into permissions (id, operation, resource) values (1, 'READ', 'USER');
insert into permissions (id, operation, resource) values (2, 'CREATE', 'USER');
insert into permissions (id, operation, resource) values (3, 'UPDATE', 'USER');
insert into permissions (id, operation, resource) values (4, 'DELETE', 'USER');

-- link roles with permissions
-- role admin permissions
insert into role_permission (role_id, permission_id) VALUES (1, 1);
insert into role_permission (role_id, permission_id) VALUES (1, 2);
insert into role_permission (role_id, permission_id) VALUES (1, 3);
insert into role_permission (role_id, permission_id) VALUES (1, 4);
-- role manager permissions
insert into role_permission (role_id, permission_id) VALUES (2, 1);
insert into role_permission (role_id, permission_id) VALUES (2, 2);
-- role user permissions
insert into role_permission (role_id, permission_id) VALUES (3, 1);






