package kr.ac.kopo.polycms.dao;

import kr.ac.kopo.polycms.model.Member;

public interface LogDao {

	void login(Member member, boolean result);

}
