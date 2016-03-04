package controller;

import java.io.*;
import java.util.*;

import dao.*;
import util.*;

public class Controller {
public static void main(String [] args) throws Throwable{
	BufferedReader trReader = new BufferedReader(new FileReader("transactions.csv"));
	BufferedReader dlReader = new BufferedReader(new FileReader("deals.csv"));
	TransactionParser trParser = new TransactionParser();
	DealParser dlParser = new DealParser();
	
	Map<String,Object> dls = dlParser.parseFromFile(dlReader);
	if(dls.containsKey("Error"))
		System.out.println(dls.get("Error"));
	WriteToFile dealsWriter = new WriteToFile("deals.txt");
	for(Deal deal:dlParser.getDls()){
		dealsWriter.writeToFile(deal.toString() + System.lineSeparator());
	}
	dealsWriter.closeWriting();
	
	Map<String,Object> trs = trParser.parseFromFile(trReader);
	if(trs.containsKey("Error"))
		System.out.println(trs.get("Error"));
	WriteToFile transWriter = new WriteToFile("transactions.txt");
	for(Transaction tr:trParser.getTrs()){
		transWriter.writeToFile(tr.toString());
	}
	transWriter.closeWriting();
}
}
