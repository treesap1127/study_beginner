package kr.ac.kopo.assignment.service;

import java.util.List;

import kr.ac.kopo.assignment.model.Memeber;
import kr.ac.kopo.assignment.util.Search;

public interface MemberService {

	List<Memeber> list(Search search);

	void add(Memeber item);

	Memeber item(int num);

	void update(Memeber item);

	void delete(int num);

	void order(Memeber order);

}
