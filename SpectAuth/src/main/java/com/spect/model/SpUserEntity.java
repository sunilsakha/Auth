package com.spect.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the sp_user database table.
 * 
 */
@Entity
@Table(name = "sp_user")
public class SpUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;

	private String addressLine1;

	private String addressLine2;

	private String city;

	private Timestamp createdTimestamp;

	private String firstName;

	private String emailId;

	@Column(name = "hospital_clinic_name")
	private String hospitalClinicName;

	private String lastName;

	@Column(name = "login_name")
	private String loginName;

	@Column(name = "login_password")
	private String loginPassword;

	private String middleName;

	@Column(name = "ph_home")
	private String phHome;

	@Column(name = "ph_mobile")
	private String phMobile;

	@Column(name = "ph_work")
	private String phWork;

	private String salutation;

	private String state;

	private Timestamp updatedTimestamp;

	@Column(name = "user_type")
	private int userType;

	private int zip;

	public SpUserEntity() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Timestamp getCreatedTimestamp() {
		return this.createdTimestamp;
	}

	public void setCreatedTimestamp(Timestamp createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getHospitalClinicName() {
		return this.hospitalClinicName;
	}

	public void setHospitalClinicName(String hospitalClinicName) {
		this.hospitalClinicName = hospitalClinicName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return this.loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPhHome() {
		return this.phHome;
	}

	public void setPhHome(String phHome) {
		this.phHome = phHome;
	}

	public String getPhMobile() {
		return this.phMobile;
	}

	public void setPhMobile(String phMobile) {
		this.phMobile = phMobile;
	}

	public String getPhWork() {
		return this.phWork;
	}

	public void setPhWork(String phWork) {
		this.phWork = phWork;
	}

	public String getSalutation() {
		return this.salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Timestamp getUpdatedTimestamp() {
		return this.updatedTimestamp;
	}

	public void setUpdatedTimestamp(Timestamp updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

	public int getUserType() {
		return this.userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public int getZip() {
		return this.zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

}
