package dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class FieldsNames {
public static  final Map<String,List<String>> fieldsNames = new HashMap<String,List<String>>();
public static final Set<String> dealsFields = new TreeSet<String>();
static	
{
		List<String> dealId = Arrays.asList("Deal ID","Deal Id");
		fieldsNames.put("dealId",dealId);
		dealsFields.add("dealId");
		List<String> tradingSystem = Arrays.asList("TradingSystem", "Trading Platform");
		fieldsNames.put("tradingSystem", tradingSystem);
		dealsFields.add("tradingSystem");
		List<String> userName = Arrays.asList("Username","Lead Id");
		fieldsNames.put("userName", userName);
		dealsFields.add("userName");
		List<String> direction = Arrays.asList("Long/Short", null);
		fieldsNames.put("direction", direction);
		dealsFields.add("direction");
		List<String> asset = Arrays.asList("Symbol","Asset");
		fieldsNames.put("asset", asset);
		dealsFields.add("asset");
		List<String> volume = Arrays.asList("Volume (ABC)","Volume");
		fieldsNames.put("volume", volume);
		dealsFields.add("volume");
		List<String> pNl = Arrays.asList("PaL (ABC)","Pnl");
		fieldsNames.put("pNl", pNl);
		dealsFields.add("pNl");
		List<String> openDate = Arrays.asList("Open Date","Open Time");
		fieldsNames.put("openDate", openDate);
		dealsFields.add("openDate");
		List<String> closeDate = Arrays.asList("Close Date","Close Time");
		fieldsNames.put("closeDate", closeDate);
		dealsFields.add("closeDate");
		List<String> postBalance = Arrays.asList("Post Balance (ABC)","Post Balance");
		fieldsNames.put("postBalance", postBalance);
		dealsFields.add("postBalance");
		List<String> openReason = Arrays.asList("Open Reason","Open Reason");
		fieldsNames.put("openReason", openReason);
		dealsFields.add("openReason");
		List<String> closeReason = Arrays.asList("Close Reason","Close Reason");
		fieldsNames.put("closeReason", closeReason);
		dealsFields.add("closeReason");
		List<String> pnlPips = Arrays.asList("PaL Pips","Pnl Pips");
		fieldsNames.put("pnlPips", pnlPips);
		dealsFields.add("pnlPips");
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

public static Map<String,Integer> boSystem = new HashMap<String,Integer>();
	static
	{
		boSystem.put("PGX",0);
		boSystem.put("Deltix",1);
	}

public static Map<Integer,DateFormat> dateFormat;
static{
	dateFormat.put(0, new SimpleDateFormat("MM/dd/yyyy hh:mm:ss"));
	dateFormat.put(1, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
	
}
	
public FieldsNames() {
	super();
}

public static  Map<String,List<String>> getFieldsNames() {
	return fieldsNames;
}

public static Map<String, Integer> getBoSystem() {
	return boSystem;
}

public static void setBoSystem(Map<String, Integer> boSystem) {
	FieldsNames.boSystem = boSystem;
}



}
