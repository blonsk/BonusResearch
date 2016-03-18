package controller;

import java.util.*;
import java.util.Map.Entry;

import dao.*;
import util.*;
import util.parcers.DealsParcerXls;

public class Controller {
public static void main(String [] args) throws Throwable{

	DealsParser parser = new DealsParcerXls("PGX","ReportDeals.xls");
	WriteToFile writer = new WriteToFile("result.txt");
	WriteToFile writer1 = new WriteToFile("deals.txt");
	
	Set<Entry<String,Map<String,Set<Deal>>>> sortedDeals0 = parser.getSortedDeals().entrySet();
	for(Entry<String,Map<String,Set<Deal>>> sortedDeals1:sortedDeals0){
		writer.writeToFile(sortedDeals1.getKey()+System.lineSeparator());
		Set<Entry<String,Set<Deal>>> sortedDeals2 = sortedDeals1.getValue().entrySet();
		for(Entry<String,Set<Deal>> sortedDeals3:sortedDeals2){
			writer.writeToFile(sortedDeals3.getKey()+System.lineSeparator());
			
			for(Deal dl:sortedDeals3.getValue()){
				if(dl.getLockedVolume().compareTo(0.0) > 0)
				writer1.writeToFile(dl.getDealId() + " " + dl.getLockedVolume() + System.lineSeparator());}
			for(Deal deal:sortedDeals3.getValue()){
				writer.writeToFile(deal.toString()+System.lineSeparator());
			}
		}
	}
}
}