package kr.ac.kopo.assignment.dao;

import java.util.List;

import kr.ac.kopo.assignment.model.Member;
import kr.ac.kopo.assignment.util.Search;

public interface MemberDao {

	List<Member> list(Search search);

	void add(Member item);

	Member item(int num);

	void update(Member item);

	void delete(int num);

	int total(Search search);

	void order(Member order);

}
