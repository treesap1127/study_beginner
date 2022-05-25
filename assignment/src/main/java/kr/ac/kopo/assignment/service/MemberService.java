package kr.ac.kopo.assignment.service;

import java.util.List;

import kr.ac.kopo.assignment.model.Member;
import kr.ac.kopo.assignment.util.Search;

public interface MemberService {

	List<Member> list(Search search);

	void add(Member item);

	Member item(int num);

	void update(Member item);

	void delete(int num);

	void order(Member order);

	void dummy();

}
