package kr.ac.kopo.smartshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.smartshop.Dao.MemberDao;
import kr.ac.kopo.smartshop.model.Member;
@Service

public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao dao;
	@Override
	public boolean login(Member member) {
		//회원인지 판단 정보를 가져와ㅣ서 회원인지 판단!
		Member item=dao.item(member);
		if(item!=null) {
			member.setPasswd(null);
			member.setAddress(item.getAddress());
			member.setTel(item.getTel());
			return true;
		}
		return false;
	}
	@Override
	public void add(Member member) {
		dao.add(member);
	}
	@Override
	public boolean checkId(String id) {
		if(dao.checkId(id)==0)
			return true;
		else
		return false;
	}

}
