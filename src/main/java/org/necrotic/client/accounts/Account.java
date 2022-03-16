package org.necrotic.client.accounts;

import java.io.Serializable;

/**
 * Represents an account save 
 * @author Tedi
 */
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private int box;
	private int gender;
	private int helmet;
	private int IDKHead;
	private int jaw;

	public Account(String username, String password, int gender, int helmet, int IDKHead, int jaw) {
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.helmet = helmet;
		this.IDKHead = IDKHead;
		this.jaw = jaw;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public int getBox() {
		return box;
	}
	
	public int getGender() {
		return gender;
	}
	
	public int getHelmet() {
		return helmet;
	}
	
	public int getIDKHead() {
		return IDKHead;
	}
	
	public int getJaw() {
		return jaw;
	}
	
	public void setBox(int box) {
		this.box = box;
	}
	
	public void setHelmet(int helmet) {
		this.helmet = helmet;
	}
	
	public void setIDKHead(int iDKHead) {
		IDKHead = iDKHead;
	}
	
	public void setJaw(int jaw) {
		this.jaw = jaw;
	}
	
	public void setGender(int gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" username : ");
		sb.append(getUsername());
		sb.append(" password : ");
		sb.append(getPassword());
		return sb.toString();
	}
}
