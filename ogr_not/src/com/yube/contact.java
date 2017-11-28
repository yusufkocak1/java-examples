package com.yube;

public class contact {

	private String name;
	private String ogr_no;
	private String not;
	
	public contact( String ogr_no,String name, String not) {
		this.name = name;
		this.ogr_no = ogr_no;
		this.not = not;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOgr_no() {
		return ogr_no;
	}
	public void setOgr_no(String ogr_no) {
		this.ogr_no = ogr_no;
	}
	public String getNot() {
		return not;
	}
	public void setNot(String not) {
		this.not = not;
	}
	
	

}
