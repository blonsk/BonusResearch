package dao;

import java.util.*;

public class FieldsNames {
public static  final Map<String,List<String>> fieldsNames = new HashMap<String,List<String>>();
static	
{
		List<String> dealId = Arrays.asList("Deal ID","Deal Id");
		fieldsNames.put("dealId",dealId);
		List<String> tradingSystem = Arrays.asList("TradingSystem", "Trading Platform");
		fieldsNames.put("tradingSystem", tradingSystem);
		List<String> userName = Arrays.asList("Username","Lead Id");
		fieldsNames.put("userName", userName);
		List<String> direction = Arrays.asList("Long/Short", null);
		fieldsNames.put("direction", direction);
		List<String> asset = Arrays.asList("Symbol","Asset");
		fieldsNames.put("asset", asset);
		List<String> volume = Arrays.asList("Volume (ABC)","Volume");
		fieldsNames.put("volume", volume);
		List<String> pNl = Arrays.asList("PaL (ABC)","Pnl");
		fieldsNames.put("pNl", pNl);
		List<String> openDate = Arrays.asList("Open Date","Open Time");
		fieldsNames.put("openDate", openDate);
		List<String> closeDate = Arrays.asList("Close Date","Close Time");
		fieldsNames.put("closeDate", closeDate);
		List<String> postBalance = Arrays.asList("Post Balance (ABC)","Post Balance");
		fieldsNames.put("postBalance", postBalance);
		List<String> openReason = Arrays.asList("Open Reason","Open Reason");
		fieldsNames.put("openReason", openReason);
		List<String> closeReason = Arrays.asList("Close Reason","Close Reason");
		fieldsNames.put("closeReason", closeReason);
		List<String> pnlPips = Arrays.asList("PaL Pips","Pnl Pips");
		fieldsNames.put("pnlPips", pnlPips);
		List<String> tranactionId = Arrays.asList("ID","Transaction Id");
		fieldsNames.put("tranactionId", tranactionId);
		List<String> transactionDate = Arrays.asList("Date","Created");
		fieldsNames.put("transactionDate", transactionDate);
		List<String> transactionType = Arrays.asList("Transaction Type","Transaction Type");
		fieldsNames.put("transactionType", transactionType);
		List<String> transactionSubType = Arrays.asList("Transaction Sub Type","Transaction SubType");
		fieldsNames.put("transactionSubType", transactionSubType);
		List<String> transactionAmount = Arrays.asList("Amount","Amount");
		fieldsNames.put("transactionAmount", transactionAmount);
		List<String> transactionComment = Arrays.asList("Comment","Comment");
		fieldsNames.put("transactionComment", transactionComment);
		List<String> transactionCreator = Arrays.asList("Created By","Initiated By");
		fieldsNames.put("transactionCreator", transactionCreator);
		List<String> transactionStatus = Arrays.asList("Status","Status");
		fieldsNames.put("transactionStatus", transactionStatus);
	}

static Map<Integer,String> boSystem = new HashMap<Integer,String>();
	static
	{
		boSystem.put(0, "PGX");
		boSystem.put(1, "Deltix");
	}

public FieldsNames() {
	super();
}

public static  Map<String,List<String>> getFieldsNames() {
	return fieldsNames;
}

public static Map<Integer, String> getBoSystem() {
	return boSystem;
}

public static void setBoSystem(Map<Integer, String> boSystem) {
	FieldsNames.boSystem = boSystem;
}



}
