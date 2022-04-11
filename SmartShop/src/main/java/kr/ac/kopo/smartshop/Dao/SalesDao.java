package kr.ac.kopo.smartshop.Dao;

import java.util.List;

import kr.ac.kopo.smartshop.model.Sales;
import kr.ac.kopo.smartshop.model.Stock;
import kr.ac.kopo.smartshop.utli.Pager;

public interface SalesDao {

	List<Sales> list(Pager pager);
	
	void add(Sales item);

	Sales item(int code);

	void update(Sales item);

	void delete(int code);

	int total(Pager pager);

	List<Stock> stock();
	
}
