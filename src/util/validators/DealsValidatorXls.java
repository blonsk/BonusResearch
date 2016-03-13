package util.validators;

import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import dao.FieldsNames;
import interfaces.ValidatorFieldsInterface;

public class DealsValidatorXls implements ValidatorFieldsInterface {
Map<String,List<String>> dealsFields = FieldsNames.getFieldsNames();
Set<String> fieldsNames;
Row row;
public DealsValidatorXls(int boSystem,Row row) {
	super();
	this.row = row;
	for(String field:dealsFields.keySet()){
		this.fieldsNames.add(dealsFields.get(field).get(boSystem));
	}
}

@Override
public Map<String, Integer> findFieldsNums() {
	Map<String, Integer> result = new TreeMap<String, Integer>();
	Iterator<Cell> iteratorCells = this.row.cellIterator();
	Cell cell;
	while(iteratorCells.hasNext()){
		cell = iteratorCells.next();
		for(String fieldName:fieldsNames){
			if(cell.getStringCellValue().equals(fieldName))
				result.put(fieldName, cell.getColumnIndex());
		}
	}
	return result;
}

@Override
public Map<String, Object> validateFields(Set<String> neededFields) {
	Map<String, Object> result = new HashMap<String, Object>();
	Map<String, Integer> fieldsNums = findFieldsNums();
	if(fieldsNums.size() == 0){
		result.put("Error", "No deal's fields");
		return result;}
	for(String field:neededFields){
		if(!fieldsNums.containsKey(field)){
			result.put("Error", "Requested fields are absent");
			return result;
		}
	}
	result.put("Success", fieldsNums);
	return result;
}

}
