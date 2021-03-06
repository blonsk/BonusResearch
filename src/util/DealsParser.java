package util;

import java.util.*;

import dao.Deal;
import dao.FieldsNames;
import interfaces.ParcerInterface;

public abstract class DealsParser implements ParcerInterface {

	
	protected Set<Deal> deals;
	protected Map<String,Integer> validFields;
	protected int boSystem;
	protected Map<String,Map<String,Set<Deal>>> sortedDeals;
	protected DealsSorter dealsSorter; 
	
	public DealsParser(String boSystem) {
		this.deals = new TreeSet<Deal>();
		this.validFields = new TreeMap<String,Integer>();
		this.boSystem = FieldsNames.boSystem.get(boSystem);
		this.dealsSorter = new DealsSorter(this.sortedDeals);
	}

	public Set<Deal> getDeals() {
		return deals;
	}

	public void setDeals(Set<Deal> deals) {
		this.deals = deals;
	}

	public Map<String, Integer> getValidFields() {
		return validFields;
	}

	public void setValidFields(Map<String, Integer> validFields) {
		this.validFields = validFields;
	}

	public int getBoSystem() {
		return boSystem;
	}

	public void setBoSystem(int boSystem) {
		this.boSystem = boSystem;
	}

	public Map<String, Map<String, Set<Deal>>> getSortedDeals() {
		return sortedDeals;
	}

	public void setSortedDeals(Map<String, Map<String, Set<Deal>>> sortedDeals) {
		this.sortedDeals = sortedDeals;
	}

	public DealsSorter getDealsSorter() {
		return dealsSorter;
	}

	public void setDealsSorter(DealsSorter dealsSorter) {
		this.dealsSorter = dealsSorter;
	}
	
	
	
}
