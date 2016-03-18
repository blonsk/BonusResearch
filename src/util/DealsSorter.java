package util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import dao.Deal;

public class DealsSorter {
	Map<String,Map<String,Set<Deal>>> sortedDeals;
	
	
	
	public DealsSorter(Map<String, Map<String, Set<Deal>>> sortedDeals) {
		super();
		this.sortedDeals = sortedDeals;
	}

	public void sortDeals(Deal deal) {
		String asset = deal.getAsset();
		if(!sortedDeals.containsKey(asset)){
			Map<String,Set<Deal>> dealsByDirection = new HashMap<String,Set<Deal>>();
			dealsByDirection.put("Long", new HashSet<Deal>());
			dealsByDirection.put("Short", new HashSet<Deal>());
			dealsByDirection.get(deal.getDirection()).add(deal);
			this.sortedDeals.put(asset, dealsByDirection);
		}
		else{
			this.sortedDeals.get(deal.getAsset()).get(deal.getDirection()).add(deal);
		}
			
	}
}
