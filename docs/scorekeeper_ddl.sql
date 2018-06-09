DROP DATABASE IF EXISTS scorekeeper_scheduling;

CREATE DATABASE scorekeeper_scheduling;

USE scorekeeper_scheduling;

CREATE TABLE scorekeeper
(
  scorekeeper_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(20) NOT NULL,
  last_name VARCHAR(20) NOT NULL,
  deleted CHAR(1) NOT NULL DEFAULT 'N'
);

CREATE TABLE game_type
(
  game_type_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  game_type_description VARCHAR(20) NOT NULL
);

CREATE TABLE field
(
  field_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  field_name VARCHAR(20) NOT NULL
);


CREATE TABLE field_scorekeeper_schedule
(
  field_id INT NOT NULL,
  scorekeeper_id INT NOT NULL,
  scheduled_date DATE NOT NULL,
  game_type_id INT NOT NULL,
  PRIMARY KEY (field_id, scorekeeper_id, scheduled_date),
  FOREIGN KEY (field_id) REFERENCES field(field_id),
  FOREIGN KEY (scorekeeper_id) REFERENCES scorekeeper(scorekeeper_id),
  FOREIGN KEY (game_type_id) REFERENCES game_type(game_type_id)
);


CREATE TABLE scorekeeper_user
(
  email_address VARCHAR(20) NOT NULL PRIMARY KEY,
  password VARCHAR(20) NOT NULL,
  login_attempts INT NOT NULL DEFAULT 0,
  lock_out CHAR(1) NOT NULL DEFAULT 'N'
);

-- Setup inserts into scorekeeper_user table:

INSERT INTO scorekeeper_user
(email_address, password)
VALUES
('jbadams@regis.edu', '3806AAaa');
INSERT INTO scorekeeper_user
(email_address, password)
VALUES
('cmartin007@regis.edu', 'password');

-- Setup inserts into game_type table:

INSERT INTO game_type
(game_type_description)
VALUES
('Mens');

INSERT INTO game_type
(game_type_description)
VALUES
('Mens Advanced');

INSERT INTO game_type
(game_type_description)
VALUES
('Co-ed');

INSERT INTO game_type
(game_type_description)
VALUES
('Co-ed Advanced');

-- Setup inserts into field table:

INSERT INTO field
(field_name)
VALUES
('Field 1');

INSERT INTO field
(field_name)
VALUES
('Field 2');

INSERT INTO field
(field_name)
VALUES
('Field 3');

-- Setup inserts into scorekeeper table:

INSERT INTO scorekeeper
(first_name, last_name, deleted)
VALUES
('Ben', 'Adams', 'N');

INSERT INTO scorekeeper
(first_name, last_name, deleted)
VALUES
('Carri', 'Martin', 'N');

INSERT INTO scorekeeper
(first_name, last_name, deleted)
VALUES
('John', 'Doe', 'N');

INSERT INTO scorekeeper
(first_name, last_name, deleted)
VALUES
('Jane', 'Doey', 'N');

INSERT INTO scorekeeper
(first_name, last_name, deleted)
VALUES
('Kevin', 'Pyatt', 'N');


-- Setup inserts into scorekeeper table, please edit dates for demo:

--Sunday

INSERT INTO field_scorekeeper_schedule
(field_id, scorekeeper_id, scheduled_date, game_type_id)
VALUES
(1, 1, '2018-06-03', 4);

INSERT INTO field_scorekeeper_schedule
(field_id, scorekeeper_id, scheduled_date, game_type_id)
VALUES
(2, 2, '2018-06-03', 3);

INSERT INTO field_scorekeeper_schedule
(field_id, scorekeeper_id, scheduled_date, game_type_id)
VALUES
(3, 3, '2018-06-03', 2);

-- Monday

INSERT INTO field_scorekeeper_schedule
(field_id, scorekeeper_id, scheduled_date, game_type_id)
VALUES
(1, 5, '2018-06-04', 1);

INSERT INTO field_scorekeeper_schedule
(field_id, scorekeeper_id, scheduled_date, game_type_id)
VALUES
(2, 4, '2018-06-04', 3);

INSERT INTO field_scorekeeper_schedule
(field_id, scorekeeper_id, scheduled_date, game_type_id)
VALUES
(3, 1, '2018-06-04', 4);

-- Tuesday

INSERT INTO field_scorekeeper_schedule
(field_id, scorekeeper_id, scheduled_date, game_type_id)
VALUES
(1, 2, '2018-06-05', 1);

INSERT INTO field_scorekeeper_schedule
(field_id, scorekeeper_id, scheduled_date, game_type_id)
VALUES
(2, 3, '2018-06-05', 3);

INSERT INTO field_scorekeeper_schedule
(field_id, scorekeeper_id, scheduled_date, game_type_id)
VALUES
(3, 4, '2018-06-05', 4);

-- Wednesday

INSERT INTO field_scorekeeper_schedule
(field_id, scorekeeper_id, scheduled_date, game_type_id)
VALUES
(1, 1, '2018-06-06', 2);

INSERT INTO field_scorekeeper_schedule
(field_id, scorekeeper_id, scheduled_date, game_type_id)
VALUES
(2, 3, '2018-06-06', 3);

INSERT INTO field_scorekeeper_schedule
(field_id, scorekeeper_id, scheduled_date, game_type_id)
VALUES
(3, 5, '2018-06-06', 4);

-- Thursday

INSERT INTO field_scorekeeper_schedule
(field_id, scorekeeper_id, scheduled_date, game_type_id)
VALUES
(1, 1, '2018-06-07', 1);

INSERT INTO field_scorekeeper_schedule
(field_id, scorekeeper_id, scheduled_date, game_type_id)
VALUES
(2, 2, '2018-06-07', 2);

INSERT INTO field_scorekeeper_schedule
(field_id, scorekeeper_id, scheduled_date, game_type_id)
VALUES
(3, 3, '2018-06-07', 3);


-- Friday

INSERT INTO field_scorekeeper_schedule
(field_id, scorekeeper_id, scheduled_date, game_type_id)
VALUES
(1, 3, '2018-06-08', 4);

INSERT INTO field_scorekeeper_schedule
(field_id, scorekeeper_id, scheduled_date, game_type_id)
VALUES
(2, 4, '2018-06-08', 3);

INSERT INTO field_scorekeeper_schedule
(field_id, scorekeeper_id, scheduled_date, game_type_id)
VALUES
(3, 5, '2018-06-08', 1);

-- Saturday

INSERT INTO field_scorekeeper_schedule
(field_id, scorekeeper_id, scheduled_date, game_type_id)
VALUES
(1, 2, '2018-06-09', 2);

INSERT INTO field_scorekeeper_schedule
(field_id, scorekeeper_id, scheduled_date, game_type_id)
VALUES
(2, 3, '2018-06-09', 3);

INSERT INTO field_scorekeeper_schedule
(field_id, scorekeeper_id, scheduled_date, game_type_id)
VALUES
(3, 4, '2018-06-09', 4);

