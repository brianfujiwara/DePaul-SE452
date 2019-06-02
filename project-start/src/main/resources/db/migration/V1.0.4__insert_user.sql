create table authority (
    id int primary key auto_increment,
    name varchar(15)
);

create table user_authority (
    authority_id int,
    user_id int
);

create table user (
    id int primary key auto_increment,
    username varchar(15),
    password varchar(80),
    date_created timestamp default current_timestamp
);

INSERT INTO authority(name, id) VALUES ('ROLE_ADMIN', 1);
INSERT INTO authority(name, id) VALUES ('ROLE_USER', 2);
INSERT INTO user_authority(authority_id, user_id) VALUES (1, 1);
INSERT INTO user_authority(authority_id, user_id) VALUES (2, 2);
INSERT INTO user (id, username, password) VALUES (1,'admin','$2a$10$9Qvd5OgmZ42IM/5xDiMeYOpMeGaDygACK1.yP605cie8s2bGH0QDO');
INSERT INTO user (id, username, password) VALUES (2,'user','$2a$10$9Qvd5OgmZ42IM/5xDiMeYOpMeGaDygACK1.yP605cie8s2bGH0QDO');
