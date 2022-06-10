package kr.ac.kopo.assignment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.assignment.model.Memeber;
import kr.ac.kopo.assignment.util.Search;
@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	SqlSession sql;
	@Override
	public List<Memeber> list(Search search) {
		return sql.selectList("member.list", search);
	}
	@Override
	public void add(Memeber item) {
		sql.insert("member.add", item);
		
	}
	@Override
	public Memeber item(int num) {
		// TODO Auto-generated method stub
		return sql.selectOne("member.item",num);
	}
	@Override
	public void update(Memeber item) {
		// TODO Auto-generated method stub
		sql.update("member.update", item);
	}
	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		sql.delete("member.delete", num);
	}
	@Override
	public int total(Search search) {
		return sql.selectOne("member.total", search);
	}
	@Override
	public void order(Memeber order) {
		sql.update("member.order", order);
		
	}

}
