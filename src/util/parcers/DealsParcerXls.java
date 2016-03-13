package util.parcers;

import java.io.*;
import java.text.*;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.*;
import dao.*;
import util.DealsParser;
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

	@Override
	public Map<String, Object> parceEntry() {
		Map<String, Object> result = new TreeMap<String, Object>();
		Sheet sheet = this.workbook.getSheetAt(0);
		Iterator<Row> iteratorRows = sheet.iterator();
		if(boSystem == 0){
			for(int i = 0; i < 3; i++) iteratorRows.next();
		}
		Row row = iteratorRows.next();
		Map<String, Object> validFields = validateFields(row);
		if(validFields.containsKey("Error"))
			return validFields;
		Map<String,Integer> fieldsMap = (Map<String, Integer>) validFields.get("Success");
		return result;
		
	}

	@Override
	public Map<String, Object> validateFields(Object row) {
		DealsValidatorXls validator = new DealsValidatorXls(this.boSystem,(Row) row);
		Map<String, Object> result = validator.validateFields(FieldsNames.dealsFields);
		return result;
	}

}
