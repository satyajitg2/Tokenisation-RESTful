CREATE TABLE `employee` (
  `employeeId` int(11) NOT NULL,
  `employeeName` varchar(45) NOT NULL,
  `emailId` varchar(45) NOT NULL,
  `managerId` int(11) NOT NULL,
  PRIMARY KEY (`employeeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tokentable` (
  `tokenRand` varchar(45) NOT NULL,
  `dataString` varchar(45) NOT NULL,
  PRIMARY KEY (`tokenRand`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into employee (employeeId, employeeName, emailId, managerId) VALUES (51372440, "Sushil Kumar", "sushil-k@hcl.com", 0);
insert into employee (employeeId, employeeName, emailId, managerId) VALUES (51558323, "Neeti Saxena", "neeti.s@hcl.com", 51372440);
insert into employee (employeeId, employeeName, emailId, managerId) VALUES (51336253, "Mohan Kambhampati", "mohan.k@hcl.com", 51372440);
insert into employee (employeeId, employeeName, emailId, managerId) VALUES (51513185, "Sarita Singh", "sarita.si@hcl.com", 51372440);
insert into employee (employeeId, employeeName, emailId, managerId) VALUES (51513185, "Sarita Singh", "sarita.si@hcl.com", 51372440);
insert into employee (employeeId, employeeName, emailId, managerId) VALUES (51519712, "Satyajit Singh", "satyajit.s@hcl.com", 51372440);
insert into employee (employeeId, employeeName, emailId, managerId) VALUES (51519712, "Satyajit Singh", "satyajit.s@hcl.com", 51372440);

SELECT `employee`.`employeeId`,
    `employee`.`employeeName`,
    `employee`.`emailId`,
    `employee`.`managerId`
FROM `scott`.`employee`;

 
update employee set managerId=51372440 where employeeId!=51372440;
	
select * from employee;
delete from employee where employeeId=11110000;
select * from tokentable;
select * from employee where employeeId=51559712;
