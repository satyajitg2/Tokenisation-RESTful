package com.rest.tokenisation;


public class Account {
	public int employeeId;
	public String employeeName;
	public String emailId;
	public int managerId;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	

	@Override
	public String toString() {
		return "Account [employeeId=" + this.employeeId + ", employeeName=" + this.employeeName + ", emailId=" + this.emailId + ", managerId=" + this.managerId + "]";
	}	
	

}
