package kr.ac.kopo.smartshop.service;

import java.util.List;

import kr.ac.kopo.smartshop.model.Partner;
import kr.ac.kopo.smartshop.utli.Pager;

public interface PartnerService {

	List<Partner> list(Pager pager);
	
	void add(Partner item);

	Partner item(int code);

	void update(Partner item);

	void delete(int code);

	List<Partner> list();



}
