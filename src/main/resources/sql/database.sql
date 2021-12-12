#DELETE EXISTING DATABASE, TABLES, USERS
DROP USER IF EXISTS GoodCompanyUser@localhost;
DROP DATABASE IF EXISTS GoodCompany;

#CREATE DATABASE
CREATE DATABASE GoodCompany;
USE GoodCompany;

#CREATE USER
CREATE USER GoodCompanyUser@localhost IDENTIFIED BY "GoodCompanyPassword";
GRANT ALL ON GoodCompany.* TO GoodCompanyUser@localhost;

#CREATE TABLE
CREATE TABLE employee (
    ID INT (6) NOT NULL AUTO_INCREMENT,
    Name VARCHAR (30) NOT NULL,
    EID VARCHAR (7) NOT NULL,
    Password VARCHAR (60),
    Salary INT (10),
    SSN VARCHAR(11),
    PRIMARY KEY (ID)
);

#ADD EMPLOYEES TO TABLE
INSERT INTO employee(Name, EID, Password, Salary, SSN) VALUES ("Alice", "EID5000", "passwd00", 100000, "555-00-5555");
INSERT INTO employee(Name, EID, Password, Salary, SSN) VALUES ("Leah", "EID5001", "passwd01", 80000, "555-01-5555");
INSERT INTO employee(Name, EID, Password, Salary, SSN) VALUES ("Charlie", "EID5002", "passwd02", 90000, "555-02-5555");
INSERT INTO employee(Name, EID, Password, Salary, SSN) VALUES ("Victoria", "EID5003", "passwd03", 120000, "555-03-5555");
INSERT INTO employee(Name, EID, Password, Salary, SSN) VALUES ("Jacob", "EID5004", "passwd04", 75000, "555-04-5555");
INSERT INTO employee(Name, EID, Password, Salary, SSN) VALUES ("Edward", "EID5005", "passwd05", 90000, "555-05-5555");
INSERT INTO employee(Name, EID, Password, Salary, SSN) VALUES ("Jasper", "EID5006", "passwd06", 115000, "555-06-5555");
INSERT INTO employee(Name, EID, Password, Salary, SSN) VALUES ("Bella", "EID5007", "passwd07", 85000, "555-07-5555");
INSERT INTO employee(Name, EID, Password, Salary, SSN) VALUES ("Rosalie", "EID5008", "passwd08", 80000, "555-08-5555");
INSERT INTO employee(Name, EID, Password, Salary, SSN) VALUES ("Emmett", "EID5009", "passwd09", 105000, "555-09-5555");
INSERT INTO employee(Name, EID, Password, Salary, SSN) VALUES ("Carlisle", "EID5010", "passwd10", 90000, "555-10-5555");
INSERT INTO employee(Name, EID, Password, Salary, SSN) VALUES ("Esme", "EID5011", "passwd11", 105000, "555-11-5555");