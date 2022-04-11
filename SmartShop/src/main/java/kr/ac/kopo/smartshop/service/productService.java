package kr.ac.kopo.smartshop.service;

import java.util.List;

import kr.ac.kopo.smartshop.model.Product;
import kr.ac.kopo.smartshop.utli.Pager;

public interface productService {

	List<Product> list(Pager pager); //제품들을 리스트에서 받아옴!

	void add(Product item);//아이템의 값은  추가하는 값들을 받아와서 서비스로 보내야함!

	Product item(int code);// 아이템의 값은 기본키인 코드를 기준으로 보내는구나

	void update(Product item);//아이템의 값은  변경하는 값들을 받아와서 서비스로 보내야함!

	void delete(int code);//코드 번호만 가지고 delete가능

	void dummy();

	void init();

	List<Product> list();

	boolean deleteImage(int code);

	void deleteList(List<Integer> list);

}
