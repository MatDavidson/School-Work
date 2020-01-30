/*CREATE SCHEMA COMPANY_Mathieu;

CREATE TABLE Department(
	Dname varchar(15) NOT NULL,
    Dnumber int NOT NULL,
    Mgr_SSN char(9) NOT NULL,
    Mgr_start_date Date,
    Primary Key(Dnumber),
    Unique(Dname));
    
INSERT INTO Department values('Research', 5, '333445555', '1988-05-22');
INSERT INTO Department values('Administration', 4, '987654321', '1985-01-01');
INSERT INTO Department values('Headquarters', 1, '888665555', '1981-06-19'); 

CREATE TABLE Employee(
	Fname varchar(15) NOT NULL,
	Minit char(1) NOT NULL,
    Lname varchar(15)NOT NULL,
    Ssn char(9) NOT NULL,
    Bdate Date,
    Address varchar(30) NOT NULL,
    Sex char(1) NOT NULL,
    Salary varchar(7) NOT NULL,
    Super_ssn char(9),
    Dno int NOT NULL,
    Primary Key(Ssn));
    
CREATE TABLE Dept_Locations(
	Dnumber int NOT NULL,
    Dlocation varchar(15));
    
create table Project(
Pname varchar(20) NOT NULL,
Pnumber int NOT NULL,
Plocation varchar(15) NOT NULL,
Dnum int NOT NULL,
primary key (Pnumber));

create table Works_On(
Essn char(9) not null,
Pno int not null,
Hours float);

create table Dependent(
	Essn char(9) not null,
    Dependent_name varchar(15) not null,
    Sex char(1) not null,
    Bdate date,
    Relationship varchar(15) not null);
   
insert into Dept_Locations values('1','Houston');
insert into Dept_Locations values('4','Stanford');
insert into Dept_Locations values('5','Bellaire');
insert into Dept_Locations values('5','Sugarland');
insert into Dept_Locations values('5','Houston');

insert into Project values('ProductX','1','Belaire', '5');
insert into Project values('ProductY','2','Sugarland', '5');
insert into Project values('ProductZ','3','Houston', '5');
insert into Project values('Computerization','10','Stafford','4');
insert into Project values('Reorganization','20','Houston', '1');
insert into Project values('Newbenefits','30','Stafford', '4');

insert into Employee values ('James', 'E', 'Borg', '888665555','1937-11-10', '450 Stone, Houston, TX', 'M', '55000', 'NULL','1'); 
insert into Employee values ('Franklin', 'T', 'Wong', '333445555','1955-12-08', '638 Voss, Houston, TX', 'M', '40000', '888665555','5');     
insert into Employee values ('John', 'B', 'Smith', '123456789','1965-01-09', '731 Fondren, Houston, TX', 'M', '30000', '333445555','5'); 
insert into Employee values ('Alicia', 'J', 'Zelaya', '999887777','1988-01-19', '3321 Castle, Spring, TX', 'F', '25000', '987654321','4'); 
insert into Employee values ('Jennifer', 'S', 'Walace', '987654321','1941-06-20', '291 Berry, Belaire, TX', 'F', '43000', '888665555','4');     
insert into Employee values ('Ramesh', 'K', 'Narayan', '666884444','1962-09-15', '975 Fire Oak, Humble, TX', 'M', '38000', '333445555','5'); 
insert into Employee values ('Ahmad', 'V', 'Jabbar', '987987987','1969-03-29', '980 Dallas, Houston, TX', 'M', '25000', '888665555','4');     
insert into Employee values ('Joyce', 'A', 'English', '453453453','1972-07-31', '5631 Rice, Houston, TX', 'F', '25000', '333445555','5');   

insert into Dependent values('333445555','Alice','F','1986-04-05','Daughter');
insert into Dependent values('333445555','Theodore','M','1983-10-25','Son');
insert into Dependent values('333445555','Joy','F','1958-05-03','Spouse');
insert into Dependent values('987654321','Abner','M','1942-02-28','Spouse');
insert into Dependent values('123456789','Micheal','M','1988-01-04','Son');
insert into Dependent values('123456789','Alice','F','1988-12-30','Daughter');
insert into Dependent values('123456789','Elizabeth','F','1967-05-05','Spouse');

insert into Works_On values('123456789','1','32.5');
insert into Works_On values('123456789','2','7.5');
insert into Works_On values('666884444','3','40.0');
insert into Works_On values('453453453','1','20.0');
insert into Works_On values('453453453','2','20.0');
insert into Works_On values('333445555','2','10.0');
insert into Works_On values('333445555','3','10.0');
insert into Works_On values('333445555','10','10.0');
insert into Works_On values('333445555','20','10.0');
insert into Works_On values('999887777','30','30.0');
insert into Works_On values('999887777','10','10.0');
insert into Works_On values('987987987','10','35.0');
insert into Works_On values('987987987','30','5.0');
insert into Works_On values('987654321','30','20.0');
insert into Works_On values('987654321','20','15.0');
insert into Works_On values('888665555','20','NULL');*/

/*Select Fname, Lname
from Employee
where Address like '%Spring, TX%';*/

Select * from Employee where Sex like '%F';

