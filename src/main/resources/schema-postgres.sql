DROP TABLE IF EXISTS role;
create table role
(
    roleid   bigint not null
        constraint role_pkey
            primary key,
    rolename varchar(255)
);

