package util.parcers;

import java.io.*;
import java.lang.reflect.*;
import java.text.*;
import java.util.*;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.*;
import util.*;
import util.validators.DealsValidatorXls;

public class DealsParcerXls extends DealsParser {
	String filePath;
	Workbook workbook;
	DateFormat df;
	
	
	public DealsParcerXls(String boSystem,String filePath) throws Exception {
		super(boSystem);
		this.filePath = filePath;
		FileInputStream inputStream = new FileInputStream(new File(filePath));
		this.workbook = new XSSFWorkbook(inputStream);
		this.df = FieldsNames.dateFormat.get(boSystem);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> parceEntry() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException {
		Map<String, Object> result = new TreeMap<String, Object>();
		
		Sheet sheet = this.workbook.getSheetAt(0);
		Iterator<Row> iteratorRows = sheet.iterator();
		if(boSystem == 0){
			for(int i = 0; i < 3; i++) iteratorRows.next();
		}
		Row row = iteratorRows.next();
		Map<String, Object> validateFieldsResult = validateFields(row);
		if(validFields.containsKey("Error"))
			return validateFieldsResult;
		this.validFields = (Map<String, Integer>) validateFieldsResult.get("Success");
		Set<Entry<String, Integer>> entryFields =  this.validFields.entrySet();
		while(iteratorRows.hasNext()){
			Row row1 = iteratorRows.next();
			Deal deal = new Deal();
			for(Entry<String, Integer> entry:entryFields){
				Field field = deal.getClass().getField(entry.getKey());
				Object fieldValue;
				if(entry.getKey().contains("Date")){
					fieldValue = FieldsNames.dateFormat.get(this.boSystem).parse(row1.getCell(entry.getValue()).getStringCellValue());
				}
				else if(row1.getCell(entry.getValue()).getCellType() == Cell.CELL_TYPE_NUMERIC){
					fieldValue = row1.getCell(entry.getValue()).getNumericCellValue();
				}
				else{
					fieldValue = row1.getCell(entry.getValue()).getStringCellValue();
				}
				field.set(deal, fieldValue);
					
			}
			this.deals.add(deal);
			this.dealsSorter.sortDeals(deal);
		}
		return result;
		
	}

	@Override
	public Map<String, Object> validateFields(Object row) {
		DealsValidatorXls validator = new DealsValidatorXls(this.boSystem,(Row) row);
		Map<String, Object> result = validator.validateFields(FieldsNames.dealsFields);
		return result;
	}

}
