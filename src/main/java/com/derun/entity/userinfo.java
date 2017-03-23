package com.derun.entity;

public class userinfo {
	
	private String builddate;
	private String operatorcode;
	private String operatorname;
	private String operatorpassword;
	private String operatortype;
	private String operatorrestrict;
	private String deleteflag;
	private String tmemo;
	
	public String getBuilddate() {
		return builddate;
	}
	public void setBuilddate(String builddate) {
		this.builddate = builddate;
	}
	public String getOperatorcode() {
		return operatorcode;
	}
	public void setOperatorcode(String operatorcode) {
		this.operatorcode = operatorcode;
	}
	public String getOperatorname() {
		return operatorname;
	}
	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}
	public String getOperatorpassword() {
		return operatorpassword;
	}
	public void setOperatorpassword(String operatorpassword) {
		this.operatorpassword = operatorpassword;
	}
	public String getOperatortype() {
		return operatortype;
	}
	public void setOperatortype(String operatortype) {
		this.operatortype = operatortype;
	}
	public String getOperatorrestrict() {
		return operatorrestrict;
	}
	public void setOperatorrestrict(String operatorrestrict) {
		this.operatorrestrict = operatorrestrict;
	}
	public String getDeleteflag() {
		return deleteflag;
	}
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}
	public String getTmemo() {
		return tmemo;
	}
	public void setTmemo(String tmemo) {
		this.tmemo = tmemo;
	}
	public String toString(){
		
		return this.builddate+" "+
				this.operatorcode+" "+
				this.operatorname+" "+
				this.operatorpassword+" "+
				this.operatortype+" "+
				this.operatorrestrict+" "+
				this.deleteflag+" "+
				this.tmemo;
	}
}
