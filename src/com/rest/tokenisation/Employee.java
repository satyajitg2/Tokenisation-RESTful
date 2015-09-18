package com.rest.tokenisation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="employee")
public class Employee {
	public int employeeId;
	public String employeeName;
	public String emailId;
	public int managerId;
	
	@XmlElement(required=true)
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	@XmlElement(required=true)
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	@XmlElement(required=true)
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@XmlElement(required=true)
	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}




	
/*	@XmlElement(required=true)
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	@XmlElement(required=true)
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeID) {
		this.employeeId = employeeID;
	}
	@XmlElement(required=false)
	public String getName() {
		return employeeName;
	}
	public void setName(String name) {
		this.employeeName = name;
	}
	@XmlElement(required=false)
	public String getEmail() {
		return emailId;
	}
	public void setEmail(String email) {
		this.emailId = email;
	}
*/	/*	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", fname=" + fname + ", lname=" + lname + "]";
	}*/
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", emailId=" + emailId + ", managerId=" + managerId + "]";
	}
	
}


