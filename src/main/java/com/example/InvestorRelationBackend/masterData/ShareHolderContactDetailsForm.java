package com.example.InvestorRelationBackend.masterData;

public class ShareHolderContactDetailsForm {
	
	private String id;
		
	private String name;
	
	private String poc;
	
	private String email;
	
	private String minorcode;
	
	private String address;
	
	private String contact;

	
	
	public ShareHolderContactDetailsForm() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ShareHolderContactDetailsForm(String id, String name, String poc, String email, String minorcode,
			String address, String contact) {
		super();
		this.id = id;
		this.name = name;
		this.poc = poc;
		this.email = email;
		this.minorcode = minorcode;
		this.address = address;
		this.contact = contact;
	}



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



	public String getMinorcode() {
		return minorcode;
	}



	public void setMinorcode(String minorcode) {
		this.minorcode = minorcode;
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
				+ ", minorcode=" + minorcode + ", address=" + address + ", contact=" + contact + "]";
	}

	
	
}
