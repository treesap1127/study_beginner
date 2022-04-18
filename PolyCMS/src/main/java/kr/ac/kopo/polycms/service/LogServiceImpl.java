package kr.ac.kopo.polycms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.polycms.dao.LogDao;
import kr.ac.kopo.polycms.model.Member;

@Service
public class LogServiceImpl implements LogService {
	@Autowired
	LogDao dao;

	@Override
	public void login(Member member, boolean result) {
		dao.login(member,result);
		
	}
	
}
