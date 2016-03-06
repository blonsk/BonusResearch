package dao;

import java.util.Date;

public class Transaction implements Comparable<Transaction>{
	
	long tranactionId;
	Date transactionDate;
	String username;
	String transactionType;
	String transactionSubType;
	Double transactionAmount;
	Double postBalance;
	String transactionComment;
	String transactionCreator;
	String transactionStatus;
	public Transaction(long tranactionId,Date transactionDate, String username, String transactionType, String subType, Double amount, Double postBalance,
			String comment, String createdBy, String status) {
		super();
		this.tranactionId = tranactionId;
		this.transactionDate = transactionDate;
		this.username = username;
		this.transactionType = transactionType;
		this.transactionSubType = subType;
		this.transactionAmount = amount;
		this.postBalance = postBalance;
		this.transactionComment = comment;
		this.transactionCreator = createdBy;
		this.transactionStatus = status;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date date) {
		this.transactionDate = date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String type) {
		this.transactionType = type;
	}
	public String getTransactionSubType() {
		return transactionSubType;
	}
	public void setTransactionSubType(String subType) {
		this.transactionSubType = subType;
	}
	public Double getAmount() {
		return transactionAmount;
	}
	public void setAmount(Double amount) {
		this.transactionAmount = amount;
	}
	public Double getPostBalance() {
		return postBalance;
	}
	public void setPostBalance(Double postBalance) {
		this.postBalance = postBalance;
	}
	public String getComment() {
		return transactionComment;
	}
	public void setComment(String comment) {
		this.transactionComment = comment;
	}
	public String getTransactionCreator() {
		return transactionCreator;
	}
	public void setTransactionCreator(String createdBy) {
		this.transactionCreator = createdBy;
	}
	public String getStatus() {
		return transactionStatus;
	}
	public void setStatus(String status) {
		this.transactionStatus = status;
	}
	
	@Override
	public String toString() {
		return "Transaction [tranactionId=" + tranactionId + ", date=" + transactionDate + ", username=" + username + ", type="
				+ transactionType + ", subType=" + transactionSubType + ", amount=" + transactionAmount + ", postBalance=" + postBalance + ", comment="
				+ transactionComment + ", createdBy=" + transactionCreator + ", status=" + transactionStatus + "]";
	}
	@Override
	public boolean equals(Object arg0) {
		if(this.tranactionId == ((Transaction)arg0).tranactionId)
			return true;
		return false;
	}
	@Override
	public int compareTo(Transaction arg0) {
		if(this.transactionDate.compareTo(arg0.transactionDate) > 0)
			return 1;
		else if(this.transactionDate.compareTo(arg0.transactionDate) < 0)
			return -1;
		return 0;
	}

	

}
