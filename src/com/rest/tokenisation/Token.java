package com.rest.tokenisation;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "employeeId", "employeeIdTk", "employeeNameTk",
		"emailIdTk", "managerIdTk" })
public class Token {

	@JsonProperty("employeeId")
	private String employeeId;
	@JsonProperty("employeeIdTk")
	private String employeeIdTk;
	@JsonProperty("employeeNameTk")
	private String employeeNameTk;
	@JsonProperty("emailIdTk")
	private String emailIdTk;
	@JsonProperty("managerIdTk")
	private String managerIdTk;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The employeeId
	 */
	@JsonProperty("employeeId")
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * 
	 * @param employeeId
	 *            The employeeId
	 */
	@JsonProperty("employeeId")
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * 
	 * @return The employeeIdTk
	 */
	@JsonProperty("employeeIdTk")
	public String getEmployeeIdTk() {
		return employeeIdTk;
	}

	/**
	 * 
	 * @param employeeIdTk
	 *            The employeeIdTk
	 */
	@JsonProperty("employeeIdTk")
	public void setEmployeeIdTk(String employeeIdTk) {
		this.employeeIdTk = employeeIdTk;
	}

	/**
	 * 
	 * @return The employeeNameTk
	 */
	@JsonProperty("employeeNameTk")
	public String getEmployeeNameTk() {
		return employeeNameTk;
	}

	/**
	 * 
	 * @param employeeNameTk
	 *            The employeeNameTk
	 */
	@JsonProperty("employeeNameTk")
	public void setEmployeeNameTk(String employeeNameTk) {
		this.employeeNameTk = employeeNameTk;
	}

	/**
	 * 
	 * @return The emailIdTk
	 */
	@JsonProperty("emailIdTk")
	public String getEmailIdTk() {
		return emailIdTk;
	}

	/**
	 * 
	 * @param emailIdTk
	 *            The emailIdTk
	 */
	@JsonProperty("emailIdTk")
	public void setEmailIdTk(String emailIdTk) {
		this.emailIdTk = emailIdTk;
	}

	/**
	 * 
	 * @return The managerIdTk
	 */
	@JsonProperty("managerIdTk")
	public String getManagerIdTk() {
		return managerIdTk;
	}

	/**
	 * 
	 * @param managerIdTk
	 *            The managerIdTk
	 */
	@JsonProperty("managerIdTk")
	public void setManagerIdTk(String managerIdTk) {
		this.managerIdTk = managerIdTk;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

/*	@Override
	public int hashCode() {
		
	}
*/
/*	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Token) == false) {
			return false;
		}
		Token rhs = ((Token) other);
		return new EqualsBuilder().append(employeeId, rhs.employeeId)
				.append(employeeIdTk, rhs.employeeIdTk)
				.append(employeeNameTk, rhs.employeeNameTk)
				.append(emailIdTk, rhs.emailIdTk)
				.append(managerIdTk, rhs.managerIdTk)
				.append(additionalProperties, rhs.additionalProperties)
				.isEquals();
	}*/

}

/*public class Token {
	public int employeeId;
	public int employeeIdTk;
	public String employeeNameTk;
	public String emailIdTk;
	public int managerIdTk;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getEmployeeIdTk() {
		return employeeIdTk;
	}
	public void setEmployeeIdTk(int employeeIdTk) {
		this.employeeIdTk = employeeIdTk;
	}
	public String getEmployeeNameTk() {
		return employeeNameTk;
	}
	public void setEmployeeNameTk(String employeeNameTk) {
		this.employeeNameTk = employeeNameTk;
	}
	public String getEmailIdTk() {
		return emailIdTk;
	}
	public void setEmailIdTk(String emailIdTk) {
		this.emailIdTk = emailIdTk;
	}
	public int getManagerIdTk() {
		return managerIdTk;
	}
	public void setManagerIdTk(int managerIdTk) {
		this.managerIdTk = managerIdTk;
	}


}*/

