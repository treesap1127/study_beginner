package kr.ac.kopo.smartshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.smartshop.Dao.ProductDao;
import kr.ac.kopo.smartshop.Dao.ProductImageDao;
import kr.ac.kopo.smartshop.model.Product;
import kr.ac.kopo.smartshop.model.ProductImage;
import kr.ac.kopo.smartshop.utli.Pager;

@Service // (서비스 레이어, 내부에서 자바 로직을 처리함)
public class ProductServiceImpl implements productService {// 서비스를 구현한다는 뜻!
	@Autowired // 자바 빈을 편히 쓰기 위함 객체 생성에 필요함
	ProductDao dao;// dao파일로 보낸다..?
	
	@Autowired
	ProductImageDao productImageDao;
	
	@Override // 서비스에 있는것을 구현하기 위해 오버라이드 해줌 "코드를 더 작성함"
	public List<Product> list(Pager pager) {// List에 있는 모델을 dao.list에 반환해줌
		int total = dao.total(pager);
		pager.setTotal(total);
		return dao.list(pager);
	}

	@Override
	@Transactional
	public void add(Product item) {// add 를 하기 위해 오버라이드로 dao로 보냄
		dao.add(item);
		
		 if(item.getImages() != null) {
		for (ProductImage image : item.getImages()) {
			image.setProductCode(item.getCode());
			
			productImageDao.add(image);
		}
	} 
}

	@Override
	public Product item(int code) {// item을 오버라이드로 dao로 보냄
		return dao.item(code);
	}

	@Override
	@Transactional
	public void update(Product item) {// update 를 하기 위해 오버라이드로 dao로 보냄
		dao.update(item);
		if(item.getImages() != null) {
			for (ProductImage image : item.getImages()) {
				image.setProductCode(item.getCode());
				
				productImageDao.add(image);
			}}
		}

	@Override
	@Transactional
	public void delete(int code) {// delete 를 하기 위해 오버라이드로 dao로 보냄
		Product item = dao.item(code);
		
		for (ProductImage image : item.getImages())
			productImageDao.delete(image.getCode());
		
		dao.delete(code);
	}

	@Override
	public void dummy() {
		for (int index = 1; index < 100; index++) {
			Product item = new Product();
			item.setName("제품명" + index);
			item.setSpec("규격" + index);
			item.setCategory("범주" + index);
			item.setManufacture("제조사" + index);
			item.setPrice(index * 1000);
			item.setBarcode("1"+index);

			dao.add(item);
		}
	}

	@Override
	public void init() {
		Pager pager = new Pager();
		do{
		
		List<Product> list = dao.list(pager);
		
		if (list.size()<1)
			break;
		for (Product item : list)
			dao.delete(item.getCode());
		}while(true);

	}

	@Override
	public List<Product> list() {
		Pager pager =new Pager();
		int total=dao.total(pager);
		pager.setTotal(total);
		pager.setPerPage(total);
		
		return dao.list(pager);
	}



	@Override
	public boolean deleteImage(int code) {
		return productImageDao.delete(code);
	}
	
	@Transactional
	@Override
	public void deleteList(List<Integer> list) {
		
		for(Integer code : list)
			dao.delete(code);
	}
	


}
