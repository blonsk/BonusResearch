package dao;

import java.util.*;

public class Deal {
long dealId;
String userName;
String direction;
String asset;
Double volume;
Double pNl;
Date openDate;
Date closeDate;
Double lockedVolume;
Double postBalance;
String openReason;
String closeReason;
String tradingSystem;
Double pnlPips;

public Deal() {
	super();
	// TODO Auto-generated constructor stub
}
public Deal(long id, String asset, String direction,   Date openDate, Date closeDate, Double volume,  String userName) {
	super();
	this.dealId = id;
	this.direction = direction;
	this.asset = asset;
	this.volume = volume;
	this.openDate = openDate;
	this.closeDate = closeDate;
	this.lockedVolume = 0.0;
	this.userName = userName;

}
public long getDealId() {
	return dealId;
}
public void setDealId(int dealId) {
	this.dealId = dealId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getDirection() {
	return direction;
}
public void setDirection(String direction) {
	this.direction = direction;
}
public String getAsset() {
	return asset;
}
public void setAsset(String asset) {
	this.asset = asset;
}
public Double getVolume() {
	return volume;
}
public void setVolume(Double volume) {
	this.volume = volume;
}
public Double getpNl() {
	return pNl;
}
public void setpNl(Double pNl) {
	this.pNl = pNl;
}
public Date getOpenDate() {
	return openDate;
}
public void setOpenDate(Date openDate) {
	this.openDate = openDate;
}
public Date getCloseDate() {
	return closeDate;
}
public void setCloseDate(Date closeDate) {
	this.closeDate = closeDate;
}

public Double getLockedVolume() {
	return lockedVolume;
}
public void setLockedVolume(Double lockedVolume) {
	this.lockedVolume = lockedVolume;
}

@Override
public String toString() {
	return "Deal [id=" + dealId + ", userName=" + userName + ", direction=" + direction + ", asset=" + asset + ", volume="
			+ volume + ", pNl=" + pNl + ", openDate=" + openDate + ", closeDate=" + closeDate + ", lockedVolume="
			+ lockedVolume + "]";
}

}
