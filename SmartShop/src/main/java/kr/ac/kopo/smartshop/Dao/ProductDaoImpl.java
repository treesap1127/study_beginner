package kr.ac.kopo.smartshop.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.smartshop.model.Product;
import kr.ac.kopo.smartshop.utli.Pager;

@Repository//  (퍼시스턴스 레이어, DB나 파일같은 외부 I/O 작업을 처리함)
public class ProductDaoImpl implements ProductDao {

	@Autowired//자바 빈을 편히 쓰기 위함  객체들 이용하면 붙여줘야함 sqlSession을 이용하기 위함인가..?
	SqlSession sql;
	
	@Override
	public List<Product> list(Pager pager) {
		return sql.selectList("product.list", pager);//제품에 대한 리스트를 받아온다 생각함
	}

	@Override
	public void add(Product item) {
		sql.insert("product.add",item);//아이템에 있는걸 넣어주는 sql문! 여기서 처리함!!!!!
	}

	@Override
	public Product item(int code) {
		return sql.selectOne("product.item",code);//item코드를 셀렉트 보여주는 코드!
	}

	@Override
	public void update(Product item) {
		sql.update("product.update",item);//제품의 수정을 해주는 코드 product에 대한 업데이트를 item을 적용하여 넣어줌!
	}
		// mybatis에 있는 제품파일로 보내주는 느낌 sql문을 거기에서 실행하게 됨
	@Override
	public void delete(int code) {
		sql.delete("product.delete",code);//code에 해당하는걸 삭제 해줌
	}

	@Override
	public int total(Pager pager) {
		
		return sql.selectOne("product.total",pager);
	}

}
