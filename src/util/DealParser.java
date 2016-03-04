package util;

import java.io.BufferedReader;
import java.text.SimpleDateFormat;
import java.util.*;

import dao.Deal;
import util.comparators.DealsComparatorOpenTime;

public class DealParser {
	Map<String,Map<String,Set<Deal>>> sortedDeals;
	Date startDate;
	List<Deal> dls;
	
	public DealParser() {
		super();
		sortedDeals = new TreeMap<String,Map<String,Set<Deal>>>();
		
	}

	public Map<String, Map<String, Set<Deal>>> getSortedDeals() {
		return sortedDeals;
	}

	public List<Deal> getDls() {
		return dls;
	}

	public Map<String,Object> parseFromFile(BufferedReader reader) throws Exception{
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		String line = reader.readLine();
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String, Object> validFields = validateFields(line);
		List<Deal> deals = new LinkedList<Deal>();
		if(validFields.containsKey("Error"))
			result = validFields;
		@SuppressWarnings("unchecked")
		Map<String, Integer> fieldsNames =  (Map<String, Integer>) validFields.get("Success");
		while((line = reader.readLine()) != null){
			String [] fields = line.split(",");
			String username = fields[fieldsNames.get("username")];
			long id = Integer.parseInt(fields[1]);
			String asset = fields[fieldsNames.get("asset")];
			String direction = fields[fieldsNames.get("direction")];
			Date openD = df.parse(fields[fieldsNames.get("openD")]);
			Date closeD = df.parse(fields[fieldsNames.get("closeD")]);
			Double volume = Double.parseDouble(fields[fieldsNames.get("volume")]);
			Deal deal = new Deal(id,asset,direction,openD,closeD,volume,username);
			deals.add(deal);
			dealsSorter(deal);
		}
		Collections.sort(deals, new DealsComparatorOpenTime());
		this.dls = deals;
		result.put("Success", deals);
		return result;
		
	}

	private Map<String, Object> dealsSorter(Deal deal) {
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
			
		return null;
	}

	private Map<String, Object> validateFields(String line) {
		String [] fields = line.split(",");
		Map<String, Object> result = new TreeMap<String, Object>();
		Map<String,Integer> fieldsMap = new TreeMap<String,Integer>();
		for(int i = 0; i < fields.length; i++){
			switch(fields[i]){
				case "Deal ID":
					fieldsMap.put("ID", i);
				case "Username":
					fieldsMap.put("username", i);
				case "Symbol":
					fieldsMap.put("asset", i);
				case "Long/Short":
					fieldsMap.put("direction", i);
				case "Open Date":
					fieldsMap.put("openD", i);
				case "Close Date":
					fieldsMap.put("closeD", i);
				case "Volume (ABC)":
					fieldsMap.put("volume", i);
				
			}	
		}
		if(fieldsMap.size() != 7)
			result.put("Error", "Requested fields are absent");
		else
			result.put("Success", fieldsMap);
		/*for(Entry<String,Integer> entry:((Map<String,Integer>)result.get("Success")).entrySet())
			System.out.println(entry.getKey() + " " + entry.getValue());*/
		return result;
	}
}
