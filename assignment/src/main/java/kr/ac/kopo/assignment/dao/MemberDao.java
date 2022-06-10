package kr.ac.kopo.assignment.dao;

import java.util.List;

import kr.ac.kopo.assignment.model.Memeber;
import kr.ac.kopo.assignment.util.Search;

public interface MemberDao {

	List<Memeber> list(Search search);

	void add(Memeber item);

	Memeber item(int num);

	void update(Memeber item);

	void delete(int num);

	int total(Search search);

	void order(Memeber order);

}
