package kr.co.hangloo.hangloo.makeDatePost;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MakeDatePostService {
	
	@Autowired
	MakeDatePostRepository postRepo;
	
	public void bulkInsert(List<MakeDatePostVO> voList) {
		postRepo.saveAll(voList);
	}
	
}
