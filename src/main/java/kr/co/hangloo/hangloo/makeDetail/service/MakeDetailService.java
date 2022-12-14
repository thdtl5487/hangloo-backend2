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

	
	// 대표사진 업데이트
	  public String thumnailUpdate(Monthcover monthcover) {
		  String date = monthcover.getMonth_cover_date();
		  String url = monthcover.getMonth_cover_url();
		  
		  System.out.println("서비스"+ "url="+ url +" date="+ date);
		  
		  makeDetailRepository.update(url, date);
	  
		  return monthcover.getMonth_cover_date();
	 
	 }
	  
	 public boolean check(Monthcover monthcover) {
		int pNum = monthcover.getPhotobook().getPhotobook_num();
		String date = monthcover.getMonth_cover_date();
		System.out.println("checkdptj find로 찾은거 : " + makeDetailRepository.find(pNum, date));
		 if (makeDetailRepository.find(pNum, date).size() == 0) {
			 return false;
		 }else{
			 return true;
		 }
	 }
	 

}
