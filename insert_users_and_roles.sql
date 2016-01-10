INSERT INTO users(username,password,enabled)
VALUES ('admin','admin', TRUE);
INSERT INTO users(username,password,enabled)
VALUES ('user','user', TRUE);
 
INSERT INTO user_roles (username, ROLE)
VALUES ('user', 'ROLE_USER');
INSERT INTO user_roles (username, ROLE)
VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO user_roles (username, ROLE)
VALUES ('admin', 'ROLE_USER');