package com.example.InvestorRelationBackend.masterData;

public class ShareHolderContactDetailsForm {
	
	private String id;
		
	private String name;
	
	private String poc;
	
	private String email;
	
	private String minorCode;
	
	private String address;
	
	private String contact;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPoc() {
		return poc;
	}

	public void setPoc(String poc) {
		this.poc = poc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMinorCode() {
		return minorCode;
	}

	public void setMinorCode(String minorCode) {
		this.minorCode = minorCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "ShareHolderContactDetailsForm [id=" + id + ", name=" + name + ", poc=" + poc + ", email=" + email
				+ ", minorCode=" + minorCode + ", address=" + address + ", contact=" + contact + "]";
	}

	public ShareHolderContactDetailsForm(String id, String name, String poc, String email, String minorCode,
			String address, String contact) {
		super();
		this.id = id;
		this.name = name;
		this.poc = poc;
		this.email = email;
		this.minorCode = minorCode;
		this.address = address;
		this.contact = contact;
	}

	public ShareHolderContactDetailsForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
