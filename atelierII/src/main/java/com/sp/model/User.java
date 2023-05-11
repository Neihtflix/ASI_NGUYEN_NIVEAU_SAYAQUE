package com.sp.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	private String login;
	private String pwd;
	private Integer account;
	private String lastName;
	private String surName;
	private String email;
	@ElementCollection
	private List<Integer> cardList;
	private Integer wallet;
	
	public User() {
		
	}
	
	public User(Integer id,String login, String pwd, Integer account, String lastName, String surName,
			String email, List<Integer> cardList, Integer wallet) {
		super();
		this.id = id;
		this.login = login;
		this.pwd = pwd;
		this.account = account;
		this.lastName = lastName;
		this.surName = surName;
		this.email = email;
		this.cardList = cardList;
		this.setWallet(wallet);
	}
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getAccount() {
		return account;
	}

	public void setAccount(Integer account) {
		this.account = account;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Integer> getCardList() {
		return cardList;
	}

	public void setCardList(List<Integer> cardList) {
		this.cardList = cardList;
	}

	public Integer getWallet() {
		return wallet;
	}

	public void setWallet(Integer wallet) {
		this.wallet = wallet;
	}

	
}