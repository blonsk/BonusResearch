package util.comparators;

import java.util.Comparator;

import dao.Transaction;

public class TransactionsComparatorDate implements Comparator<Transaction> {

	@Override
	public int compare(Transaction t1, Transaction t2) {
		if(t1.compareTo(t2) > 0)
			return 1;
		else if(t1.compareTo(t2) < 0)
			return -1;
		else
		return 0;
	}

}
