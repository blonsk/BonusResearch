package util;

import java.io.*;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import dao.Deal;

public class DealsParser {
	String filePath;
	Workbook workbook;
	Map<String,Map<String,Set<Deal>>> sortedDeals;
	List<Deal> dealsList;
	
	public DealsParser(String filePath) throws Exception {
		super();
		this.filePath = filePath;
		FileInputStream inputStream = new FileInputStream(new File(filePath));
		this.workbook = new XSSFWorkbook(inputStream);
		this.sortedDeals = new TreeMap<String,Map<String,Set<Deal>>>();
		this.dealsList = new LinkedList<Deal>();
	}
	
	public Map<String,Object> parseFromFile(){
		Map<String, Object> result = new TreeMap<String, Object>();
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		List<Deal> deals = new LinkedList<Deal>();
		Sheet sheet = this.workbook.getSheetAt(0);
		Iterator<Row> iteratorRows = sheet.iterator();
		Row row = iteratorRows.next();
		Map<String, Object> validFields = validateFields(row);
		if(validFields.containsKey("Error"))
			return validFields;
		Map<String,Integer> fieldsMap = (Map<String, Integer>) validFields.get("Success");
		Class<Deal> dealClass = Deal.class;
		Field[] dealFields = dealClass.getFields();
		for(Field field:dealFields){
			field.getName();
		}
		while(iteratorRows.hasNext()){
			
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
			case "Open Date":
				fieldsMap.put("openDate", i);
			case "Username":
				fieldsMap.put("username", i);
			case "Long/Short":
				fieldsMap.put("direction", i);
			case "Volume (ABC)":
				fieldsMap.put("volume", i);
			case "Symbol":
				fieldsMap.put("asset", i);
			case "Close Date":
				fieldsMap.put("closeDate", i);
			case "Created By":
				fieldsMap.put("createdBy", i);
			case "Post Balance (ABC)":
				fieldsMap.put("postBalance", i);
			case "Deal ID":
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
		//for(Entry<String, Integer> entry:fieldsMap.entrySet()) {System.out.println(entry.getKey() + " " + entry.getValue());}
		return result;
		
	}
}
