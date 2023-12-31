package com.project.user.data;

/**
 * 
 * 관리자 회원 데이터가 담긴 클래스
 *
 */


public class DataAdmin {
	
	private String adminCode; 
	private String id; 
	private String password; 
	private String name; 
	private String tel; 
	private String birth;
	private int using;
	
	public DataAdmin() {
		this.adminCode = "";
		this.id = "";
		this.password = "";
		this.name = "";
		this.tel = "";
		this.birth = "";
		this.using = 0;
	}	
	public DataAdmin(String[] adminLine) {
		this.setDataAdmin(adminLine);
	}	
	
	public void setDataAdmin(String[] adminLine) {
		this.adminCode = adminLine[0];
		this.id = adminLine[1];
		this.password = adminLine[2];
		this.name = adminLine[3];
		this.tel = adminLine[4];
		this.birth = adminLine[5];
		this.using = Integer.parseInt(adminLine[6]);
	}

	public String getAdminCode() {
		return adminCode;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		String temp = tel.replaceAll("-","");
		this.tel = temp;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getUsing() {
		return using;
	}

	public void setUsing(int using) {
		this.using = using;
	}

	@Override
	public String toString() {
		return adminCode + "," + id + "," + password + "," + name
				+ "," + tel + "," + birth + ","	+ using;
	}
	
	
}
