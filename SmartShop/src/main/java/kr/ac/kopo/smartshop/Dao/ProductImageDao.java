package kr.ac.kopo.smartshop.Dao;

import kr.ac.kopo.smartshop.model.ProductImage;

public interface ProductImageDao {

	void add(ProductImage image);

	boolean delete(int code);
	

}
