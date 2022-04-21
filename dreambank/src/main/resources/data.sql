-- ADMIN ROLE PRE-INSERT
INSERT INTO user (id, email, first_name, last_name) VALUES (1, "admin@bank.com", "admin", "admin", "admin");
INSERT INTO role (id, name) VALUES (1, "ROLE_ADMIN");
INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);