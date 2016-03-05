package util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import dao.Transaction;

public class TransactionsParser {
	List<Transaction> trs;
	String filePath;
	Workbook workbook;
	
	public TransactionsParser(String filePath) throws IOException {
		super();
		this.filePath = filePath;
		this.trs = new LinkedList<Transaction>();
		FileInputStream inputStream = new FileInputStream(new File(filePath));
		this.workbook = new XSSFWorkbook(inputStream);
	}
	
	public Map<String,Object> parseFromFile() throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		Sheet sheet = this.workbook.getSheetAt(0);
		Iterator<Row> iteratorRows = sheet.iterator();
		Row row = iteratorRows.next();
		@SuppressWarnings("unchecked")
		Map<String,Integer> validFields = (Map<String, Integer>) validateFields(row).get("Success");
		if(validFields == null){
			return validateFields(row);
		}
		List<Transaction> transactions = new LinkedList<Transaction>();
		while(iteratorRows.hasNext()){
			row = iteratorRows.next();
			String status = row.getCell(validFields.get("status")).toString();
			if(!status.equals("OK")) continue;
			Date date = df.parse(row.getCell(validFields.get("date")).toString());
			Double doubleId = row.getCell(validFields.get("id")).getNumericCellValue();
			long id = doubleId.longValue();
			double amount = row.getCell(validFields.get("amount")).getNumericCellValue();
			double postBalance = row.getCell(validFields.get("postBalance")).getNumericCellValue();
			String username = row.getCell(validFields.get("username")).toString();
			String type = row.getCell(validFields.get("type")).toString();
			String subType = row.getCell(validFields.get("subType")).toString();
			String comment = row.getCell(validFields.get("comment")).toString();
			String createdBy = row.getCell(validFields.get("createdBy")).toString();
			Transaction transaction = new Transaction(id,date, username, type, subType, amount, postBalance,
					comment, createdBy, status);
			transactions.add(transaction);
			System.out.println(transaction.toString());
		}
		return result;
	}

	private Map<String, Object> validateFields(Row row) {
		Map<String,Object> result = new HashMap<String,Object>();
		Iterator<Cell> iteratorCells = row.cellIterator();
		Map<String,Integer> fieldsMap = new HashMap<String,Integer>();
		
		while(iteratorCells.hasNext()){
			Cell cell = iteratorCells.next();
			String value = cell.getStringCellValue();
			int i = cell.getColumnIndex();
			switch(value){
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
			i++;
		}
		if(fieldsMap.size()<9){
			result.put("Error", "Requested fields are absent");
		}
		else{
			result.put("Success",fieldsMap);
		}
		for(Entry<String, Integer> entry:fieldsMap.entrySet()) {System.out.println(entry.getKey() + " " + entry.getValue());}
		return result;
	}
}
