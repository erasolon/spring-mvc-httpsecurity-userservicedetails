INSERT INTO credentials(username,password,disabled)
VALUES ('admin','password', false);
INSERT INTO credentials(username,password,disabled)
VALUES ('user1','password', false);
INSERT INTO credentials(username,password,disabled)
VALUES ('user2','password', true);

INSERT INTO roles (username, role)
VALUES ('admin', 'USER');
INSERT INTO roles (username, role)
VALUES ('admin', 'ADMIN');
INSERT INTO roles (username, role)
VALUES ('user1','USER');
INSERT INTO roles (username, role)
VALUES ('user2','USER');

INSERT INTO authorities (username, authority)
VALUES ('admin', 'READ');
INSERT INTO authorities (username, authority)
VALUES ('admin', 'WRITE');
INSERT INTO authorities (username, authority)
VALUES ('user1','READ');
INSERT INTO authorities (username, authority)
VALUES ('user2','READ');