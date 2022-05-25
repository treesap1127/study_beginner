package kr.ac.kopo.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.assignment.dao.MemberDao;
import kr.ac.kopo.assignment.model.Member;
import kr.ac.kopo.assignment.util.Search;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao dao;
	
	@Override
	public List<Member> list(Search search) {
		int total = dao.total(search);
		search.setTotal(total);
		return dao.list(search);
	}

	@Override
	public void add(Member item) {
		dao.add(item);
		
	}

	@Override
	public Member item(int num) {
		return dao.item(num);
	}

	@Override
	public void update(Member item) {
		dao.update(item);
		
	}

	@Override
	public void delete(int num) {
		dao.delete(num);
	}

	@Override
	public void order(Member order) {
		dao.order(order);
	}

	@Override
	public void dummy() {
		for (int index = 1; index < 5; index++) {
			Member item = new Member();
			item.setName("이름" + index);
			item.setTel("010-1234-124"+index);
			dao.add(item);
		}
		
	}

}
