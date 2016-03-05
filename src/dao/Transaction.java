package dao;

import java.util.Date;

public class Transaction implements Comparable<Transaction>{
	
	long tranactionId;
	Date date;
	String username;
	String type;
	String subType;
	Double amount;
	Double postBalance;
	String comment;
	String createdBy;
	String status;
	public Transaction(long tranactionId,Date date, String username, String type, String subType, Double amount, Double postBalance,
			String comment, String createdBy, String status) {
		super();
		this.tranactionId = tranactionId;
		this.date = date;
		this.username = username;
		this.type = type;
		this.subType = subType;
		this.amount = amount;
		this.postBalance = postBalance;
		this.comment = comment;
		this.createdBy = createdBy;
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getPostBalance() {
		return postBalance;
	}
	public void setPostBalance(Double postBalance) {
		this.postBalance = postBalance;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Transaction [tranactionId=" + tranactionId + ", date=" + date + ", username=" + username + ", type="
				+ type + ", subType=" + subType + ", amount=" + amount + ", postBalance=" + postBalance + ", comment="
				+ comment + ", createdBy=" + createdBy + ", status=" + status + "]";
	}
	@Override
	public boolean equals(Object arg0) {
		if(this.tranactionId == ((Transaction)arg0).tranactionId)
			return true;
		return false;
	}
	@Override
	public int compareTo(Transaction arg0) {
		if(this.date.compareTo(arg0.date) > 0)
			return 1;
		else if(this.date.compareTo(arg0.date) < 0)
			return -1;
		return 0;
	}

	

}
