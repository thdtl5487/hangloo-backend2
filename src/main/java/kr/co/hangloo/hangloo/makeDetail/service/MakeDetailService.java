package kr.co.hangloo.hangloo.makeDetail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.hangloo.hangloo.makeDetail.dto.Monthcover;
import kr.co.hangloo.hangloo.makeDetail.repository.MakeDetailRepository;

@Service
@Transactional
public class MakeDetailService {

	MakeDetailRepository makeDetailRepository;
	
	@Autowired
	public MakeDetailService(MakeDetailRepository makeDetailRepository) {
		this.makeDetailRepository = makeDetailRepository;
	}
	
	// 대표사진 저장
	public String thumnailSave(Monthcover monthcover) {
		
		// 레파지토리 저장
		makeDetailRepository.save(monthcover);
		return monthcover.getMonth_cover_date();
	}
	
	
	
	
	
	
}
