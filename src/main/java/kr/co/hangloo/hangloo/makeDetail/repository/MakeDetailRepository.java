package kr.co.hangloo.hangloo.makeDetail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.hangloo.hangloo.makeDetail.dto.Monthcover;


public interface MakeDetailRepository{

	//대표이미지 저장
	 Monthcover save(Monthcover monthcover); 
	 
	 //업데이트
	 String update(String url, String date);

	 // 찾기
//	 boolean find(int pNum, String date);
	 List<Monthcover> find(int pNum, String date);
	 
	
}
