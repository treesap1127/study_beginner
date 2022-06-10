package kr.ac.kopo.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.assignment.dao.MemberDao;
import kr.ac.kopo.assignment.model.Memeber;
import kr.ac.kopo.assignment.util.Search;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao dao;
	
	@Override
	public List<Memeber> list(Search search) {
		int total = dao.total(search);
		search.setTotal(total);
		return dao.list(search);
	}

	@Override
	public void add(Memeber item) {
		dao.add(item);
		
	}

	@Override
	public Memeber item(int num) {
		// TODO Auto-generated method stub
		return dao.item(num);
	}

	@Override
	public void update(Memeber item) {
		dao.update(item);
		
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		dao.delete(num);
	}

	@Override
	public void order(Memeber order) {
		dao.order(order);
	}

}
