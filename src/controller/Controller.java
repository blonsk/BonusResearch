package controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.FieldsNames;
import util.TransactionsParser;

public class Controller {
public static void main(String [] args) throws Throwable{
	
	System.out.println(FieldsNames.getFieldsNames().keySet());
	System.out.println(FieldsNames.getFieldsNames().values());
	
}
}