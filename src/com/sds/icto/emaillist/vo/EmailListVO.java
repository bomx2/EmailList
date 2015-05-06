package com.sds.icto.emaillist.vo;

public class EmailListVO {
	private long no;
	private String firstname;
	private String lastname;
	private String email;
	
	public EmailListVO() {
	}

	public EmailListVO(long no, String firstname, String lastname, String email) {
		super();
		this.no = no;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmailListVO [no=" + no + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + "]";
	}
	
}
