INSERT INTO users (id, username, password, active, roles) values
(1, 'einstein', 'einstein', 'true', 'USER'),
(2, 'newton', 'newton', 'true', 'USER');

INSERT INTO user_profile (id, username, theme, summary, first_name, last_name, email, phone, designation) values
(1, 'einstein', '1', 'Developed Theory of Relativity', 'Albert', 'Einstein', 'albert@einstein.com', '12345678901', 'physicist'),
(2, 'newton', '1', 'Developed Theory of Gravity', 'Isaac', 'Newton', 'isaac@newton.com', '12345678909', 'physicist');
