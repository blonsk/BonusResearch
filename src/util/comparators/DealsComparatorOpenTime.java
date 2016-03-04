package util.comparators;

import java.util.Comparator;

import dao.Deal;

public class DealsComparatorOpenTime implements Comparator<Deal> {

	@Override
	public int compare(Deal d0, Deal d1) {
		if(d0.getOpenDate().compareTo(d1.getOpenDate()) > 0)
			return 1;
		else if(d0.getOpenDate().compareTo(d1.getOpenDate()) < 0)
			return -1;
		else
			return 0;
	}

}
