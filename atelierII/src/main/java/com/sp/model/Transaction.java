package com.sp.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transaction {
	@Id
	@GeneratedValue
    private int id;
    private int userId;
    private int cardId;
    private int price;
    private String action;
    private Date timeSt;
    
    public Transaction() {
		
	}

    public Transaction(int id, int userId, int cardId, int price, String action, Date timeSt) {
    	super();
        this.id = id;
        this.userId = userId;
        this.cardId = cardId;
        this.price = price;
        this.action = action;
        this.timeSt = timeSt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getTimeSt() {
        return timeSt;
    }

    public void setTimeSt(Date date) {
        this.timeSt = date;
    }
}
