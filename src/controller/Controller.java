package controller;

import java.io.IOException;

import util.TransactionsParser;

public class Controller {
public static void main(String [] args) throws Throwable{
	TransactionsParser trParser = new TransactionsParser("Report.xlsx");
	System.out.println(trParser.parseFromFile().keySet());
}
}