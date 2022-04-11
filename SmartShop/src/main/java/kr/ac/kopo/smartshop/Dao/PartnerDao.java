package kr.ac.kopo.smartshop.Dao;

import java.util.List;

import kr.ac.kopo.smartshop.model.Partner;
import kr.ac.kopo.smartshop.utli.Pager;

public interface PartnerDao {

	List<Partner> list(Pager pager);

	int total(Pager pager);

	void add(Partner item);

	Partner item(int code);

	void update(Partner item);

	void delete(int code);
	
}
