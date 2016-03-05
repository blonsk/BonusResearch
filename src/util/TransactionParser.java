package util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

import dao.Transaction;
import util.comparators.TransactionsComparatorDate;

public class TransactionParser {
List<Transaction> trs;
String username;

public List<Transaction> getTrs() {
	return trs;
}

public String getUsername() {
	return username;
}

public TransactionParser() {
	super();
}
 
public Map<String,Object> parseFromFile(BufferedReader br) throws Exception{
	SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
	String line = br.readLine();
	Map<String,Object> result = new HashMap<String,Object>();
	@SuppressWarnings("unchecked")
	Map<String, Integer> validFields = (Map<String, Integer>) validateFields(line).get("Success");
	if(validFields == null){
		return validateFields(line);
	}
	List<Transaction> transactions = new LinkedList<Transaction>();
	while((line = br.readLine()) != null){
		String [] fields = line.split(",");
		//for(int i = 0; i< fields.length;i++){System.out.print(fields[i] + " " + i +";");}System.out.print(System.lineSeparator());
		Long id = Long.parseLong(fields[validFields.get("id")]);
		Date date = df.parse(fields[validFields.get("date")]);
		String username = fields[validFields.get("username")];
		String type = fields[validFields.get("type")];
		Double amount = Double.parseDouble(fields[validFields.get("amount")]);
		String status = fields[validFields.get("status")];
		if(!status.equals("OK")) continue;
		String comment = fields[validFields.get("comment")];
		String createdBy = fields[validFields.get("createdBy")];
		Double postBalance = Double.parseDouble(fields[validFields.get("postBalance")]);
		String subType = fields[validFields.get("subType")];
		//System.out.println(System.lineSeparator() + id + date.toString() + username+ type+ subType+ amount+ postBalance+ comment+ createdBy+ status);
		Transaction transaction = new Transaction(id,date, username, type, subType, amount, postBalance, comment, createdBy, status);
		transactions.add(transaction);
	}
	
	result.put("Success", transactions);
	if(!result.containsKey("Error")){
		transactions.sort(new TransactionsComparatorDate());
		this.trs = transactions;
	}
	return result;
	
}

private Map<String, Object> validateFields(String line) {
	Map<String,Object> result = new HashMap<String,Object>();
	Map<String, Integer> fieldsMap = new TreeMap<String, Integer>();
	String [] fields = line.split(",");
	for(int i = 0; i< fields.length;i++){System.out.println(fields[i] + " " + i);}
	for(int i = 0; i < fields.length; i++){
		switch(fields[i]){
		case "Date":
			fieldsMap.put("date", i);
		case "Username":
			fieldsMap.put("username", i);
		case "Transaction Type":
			fieldsMap.put("type", i);
		case "Amount":
			fieldsMap.put("amount", i);
		case "Status":
			fieldsMap.put("status", i);
		case "Comment":
			fieldsMap.put("comment", i);
		case "Created By":
			fieldsMap.put("createdBy", i);
		case "Post Balance (ABC)":
			fieldsMap.put("postBalance", i);
		case "ID":
			fieldsMap.put("id", i);
		case "Transaction Sub Type":
			fieldsMap.put("subType", i);
		}
	}
	if(fieldsMap.size()<9){
		result.put("Error", "Requested fields are absent");
	}
	else{
		result.put("Success",fieldsMap);
	}
	for(Entry<String, Integer> entry:((Map<String,Integer>)result.get("Success")).entrySet()) {System.out.println(entry.getKey() + " " + entry.getValue());}
	return result;
}
}
