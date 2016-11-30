package com.app.code.model;

public class DBModel {
	private String username;
	private String password;
	private String driver;
	private String url;
	
	public DBModel(String username, String password, String driver, String url) {
		this.username = username;
		this.password = password;
		this.driver = driver;
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
