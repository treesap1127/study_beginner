package kr.ac.kopo.smartshop.Dao;

import java.util.List;

import kr.ac.kopo.smartshop.model.Product;
import kr.ac.kopo.smartshop.utli.Pager;

public interface ProductDao {// 서비스에 온것을 받아주고 구현하기 편하게 인터페이스로 잡아줌!

	List<Product> list(Pager pager);

	void add(Product item);

	Product item(int code);

	void update(Product item);

	void delete(int code);

	int total(Pager pager);

}
