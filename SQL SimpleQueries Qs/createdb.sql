CREATE TABLE designation (
  did INTEGER NOT NULL PRIMARY KEY,
  status BOOLEAN NOT NULL,
  designation varchar(20) NOT NULL
);

CREATE TABLE employees (
  cantact varchar(20) NOT NULL,
  username varchar(20) NOT NULL,
  password varchar(20) NOT NULL,
  status BOOLEAN NOT NULL,
  name varchar(20) NOT NULL
);

CREATE TABLE payments (
  paymented INTEGER NOT NULL PRIMARY KEY,
  basicpay INTEGER NOT NULL,
  date_ DATE NOT NULL,
  allowances INTEGER NOT NULL
);

CREATE TABLE interview (
  venue varchar(20) NOT NULL,
  status BOOLEAN NOT NULL,
  date_ DATE NOT NULL,
  selectionround varchar(20) NOT NULL,
  interviewed INTEGER NOT NULL PRIMARY KEY
);

CREATE TABLE vacancies (
  publish varchar(20) NOT NULL,
  vacid INTEGER NOT NULL PRIMARY KEY,
  criteria varchar(20) NOT NULL,
  vacancy varchar(20) NOT NULL,
  qualification varchar(20) NOT NULL,
  status BOOLEAN NOT NULL
);

CREATE TABLE projects (
  projectid INTEGER NOT NULL PRIMARY KEY,
  title varchar(20) NOT NULL,
  documents varchar(20) NOT NULL,
  startdate DATE NOT NULL,
  enddate DATE NOT NULL
);

CREATE TABLE projectstatus (
  element varchar(20) NOT NULL,
  projectid INTEGER NOT NULL PRIMARY KEY,
  module varchar(20) NOT NULL,
  startday DATE NOT NULL,
  enddate DATE NOT NULL,
  status BOOLEAN NOT NULL
);

CREATE TABLE applicanstatus (
  stid varchar(20) NOT NULL PRIMARY KEY,
  date_ DATE NOT NULL,
  aboutstatus BOOLEAN NOT NULL,
  aboutapp varchar(20) NOT NULL
);

CREATE TABLE attendance (
  logindate DATE NOT NULL,
  attandanceid INTEGER NOT NULL PRIMARY KEY,
  logoutdate DATE NOT NULL
);

CREATE VIEW view_ AS
  SELECT did, status
    FROM designation
    WHERE status = TRUE;
    
INSERT INTO view_
  SELECT TRUE, 'des_example';
    
INSERT INTO designation (status, designation)
  VALUES (TRUE, 'des_example1'),
  (FALSE, 'des_example2'),
  (TRUE, 'des_example3'),
  (FALSE, 'des_example4'),
  (TRUE, 'des_example5'),
  (FALSE, 'des_example6'),
  (TRUE, 'des_example7'),
  (FALSE, 'des_example8'),
  (TRUE, 'des_example9'),
  (FALSE, 'des_example10');
    
INSERT INTO employees (cantact, username, password, status, name)
  VALUES ('cantact_ex1', 'username1', 'pass1', FALSE, 'name1'),
    ('cantact_ex2', 'username2', 'pass2', FALSE, 'name2'),
    ('cantact_ex3', 'username3', 'pass3', FALSE, 'name3'),
    ('cantact_ex4', 'username4', 'pass4', FALSE, 'name4'),
    ('cantact_ex5', 'username5', 'pass5', FALSE, 'name5'),
    ('cantact_ex6', 'username6', 'pass6', TRUE, 'name6'),
    ('cantact_ex7', 'username7', 'pass7', TRUE, 'name7'),
    ('cantact_ex8', 'username8', 'pass8', TRUE, 'name8'),
    ('cantact_ex9', 'username9', 'pass9', TRUE, 'name9'),
    ('cantact_ex10', 'username10', 'pass10', TRUE, 'name10');
    
INSERT INTO payments (basicpay, date_, allowances)
  VALUES (100, '2020-12-17', 1000),
    (200, '2020-12-18', 2000),
    (300, '2020-12-19', 3000),
    (400, '2020-12-20', 4000),
    (500, '2020-12-21', 5000),
    (600, '2020-12-22', 6000),
    (700, '2020-12-23', 7000),
    (800, '2020-12-24', 8000),
    (900, '2020-12-25', 9000),
    (1000, '2020-12-26', 10000);
    
INSERT INTO interview ( venue, status, date_)
  VALUES ('venue-ex1', FALSE, '2021-01-01'),
    ('venue-ex2', FALSE, '2021-01-02'),
    ('venue-ex3', FALSE, '2021-01-03'),
    ('venue-ex4', FALSE, '2021-01-04'),
    ('venue-ex5', FALSE, '2021-01-05'),
    ('venue-ex6', FALSE, '2021-01-06'),
    ('venue-ex7', FALSE, '2021-01-07'),
    ('venue-ex8', FALSE, '2021-01-08'),
    ('venue-ex9', FALSE, '2021-01-09'),
    ('venue-ex10', FALSE, '2021-01-10');
    
INSERT INTO vacancies ( criteria, vacancy, qualification, status)
  VALUES ('criteria-ex1', 'vac1', 'qual1', TRUE),
    ('criteria-ex2', 'vac2', 'qual2', TRUE),
    ('criteria-ex3', 'vac3', 'qual3', TRUE),
    ('criteria-ex4', 'vac4', 'qua4', TRUE),
	('criteria-ex5', 'vac5', 'qual5', TRUE),
    ('criteria-ex6', 'vac6', 'qual6', TRUE),
    ('criteria-ex7', 'vac7', 'qual7', TRUE),
    ('criteria-ex8', 'vac8', 'qual8', TRUE),
    ('criteria-ex9', 'vac9', 'qual9', TRUE),
    ('criteria-ex10', 'vac10', 'qual10', TRUE);
  
INSERT INTO projects ( title, documents, enddate)
  VALUES ('title1', 'doc1', '2021-02-01'),
    ('title2', 'doc2', '2021-02-02'),
    ('title3', 'doc3', '2021-02-03'),
    ('title4', 'doc4', '2021-02-04'),
    ('title5', 'doc5', '2021-02-05'),
    ('title6', 'doc6', '2021-02-06'),
    ('title7', 'doc7', '2021-02-07'),
    ('title8', 'doc8', '2021-02-08'),
    ('title9', 'doc9', '2021-02-09'),
    ('title10', 'doc10', '2021-02-10');
    
INSERT INTO projectstatus ( element, module, enddate, status)
  VALUES ('elem1', 'mod1', '2021-02-01', TRUE),
    ('elem2', 'mod2', '2021-02-02', FALSE),
    ('elem3', 'mod3', '2021-02-03', FALSE),
    ('elem4', 'mod4', '2021-02-04', FALSE),
    ('elem5', 'mod5', '2021-02-05', FALSE),
    ('elem6', 'mod6', '2021-02-06', TRUE),
    ('elem7', 'mod7', '2021-02-07', TRUE),
    ('elem8', 'mod8', '2021-02-08', TRUE),
    ('elem9', 'mod9', '2021-02-09', TRUE),
    ('elem10', 'mod10', '2021-02-10', TRUE);
    
INSERT INTO applicanstatus ( aboutapp, aboutstatus, date_)
  VALUES ('aboutapp1', FALSE, '2021-02-01'),
    ('aboutapp2', TRUE, '2021-02-02'),
    ('aboutapp3', TRUE, '2021-02-03'),
    ('aboutapp4', TRUE, '2021-02-04'),
    ('aboutapp5', TRUE, '2021-02-05'),
    ('aboutapp6', TRUE, '2021-02-06'),
    ('aboutapp7', FALSE, '2021-02-07'),
    ('aboutapp8', FALSE, '2021-02-08'),
    ('aboutapp9', FALSE, '2021-02-09'),
    ('aboutapp10', FALSE, '2021-02-10');
    
INSERT INTO attendance (logoutdate)
  VALUES ('2021-02-01'),
    ('2021-02-02'),
    ('2021-02-03'),
    ('2021-02-04'),
    ('2021-02-05'),
    ('2021-02-06'),
    ('2021-02-07'),
    ('2021-02-08'),
    ('2021-02-09'),
    ('2021-02-10');
    
UPDATE designation
SET status = FALSE
WHERE status = TRUE;

UPDATE employees
SET status = FALSE
WHERE status = TRUE;

UPDATE payments
SET allowances = 0
WHERE allowances = 1000;

UPDATE interview
SET status = FALSE
WHERE status = TRUE;

UPDATE vacancies
SET status = FALSE
WHERE status = TRUE;

UPDATE projects
SET enddate = '2022-02-01'
WHERE title = 'title1';

UPDATE projectstatus
SET status = FALSE
WHERE status = TRUE;

UPDATE applicanstatus
SET aboutstatus = FALSE
WHERE aboutstatus = TRUE;

UPDATE attendance
SET logoutdate = '2022-02-01'
WHERE logoutdate = '2021-02-01';

UPDATE view_
SET designation = 'updated_title';
WHERE status = TRUE;

DELETE FROM designation
WHERE status = TRUE;

DELETE FROM employees
WHERE status = TRUE;

DELETE FROM payments
WHERE allowances = 1000;

DELETE FROM interview
WHERE status = TRUE;

DELETE FROM vacancies
WHERE status = TRUE;

DELETE FROM projects
WHERE title = 'title1';

DELETE FROM projectstatus
WHERE status = TRUE;

DELETE FROM applicanstatus
WHERE aboutstatus = TRUE;

DELETE FROM attendance
WHERE logoutdate = '2021-02-01';

DELETE FROM view_
WHERE status = TRUE;

ALTER TABLE designation
RENAME TO designation_;

ALTER TABLE employees
RENAME TO employees_;

ALTER TABLE payments
RENAME TO payments_;

ALTER TABLE interview
RENAME TO interview_;

ALTER TABLE vacancies
RENAME TO vacancies_;

ALTER TABLE projects
RENAME TO projects_;

ALTER TABLE projectstatus
RENAME TO projectstatus_;

ALTER TABLE applicanstatus
RENAME TO applicanstatus_;

ALTER TABLE attendance
RENAME TO attendance_;

ALTER TABLE view_
RENAME TO view__;