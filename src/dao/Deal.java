package dao;

import java.util.*;

public class Deal implements Comparable{
long id;
String userName;
String direction;
String asset;
Double volume;
Double pNl;
Date openDate;
Date closeDate;
Double lockedVolume;

public Deal() {
	super();
	// TODO Auto-generated constructor stub
}
public Deal(long id, String asset, String direction,   Date openDate, Date closeDate, Double volume, String username) {
	super();
	this.id = id;
	this.direction = direction;
	this.asset = asset;
	this.volume = volume;
	this.openDate = openDate;
	this.closeDate = closeDate;
	this.lockedVolume = 0.0;
	this.userName = username;
}
public long getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
	return "Deal [id=" + id + ", userName=" + userName + ", direction=" + direction + ", asset=" + asset + ", volume="
			+ volume + ", pNl=" + pNl + ", openDate=" + openDate + ", closeDate=" + closeDate + ", lockedVolume="
			+ lockedVolume + "]";
}
@Override
public int compareTo(Object arg0) {
	// TODO Auto-generated method stub
	return 0;
}

}
