package kr.co.hangloo.hangloo.selectBookOption.repository;

import java.util.List;

import kr.co.hangloo.hangloo.selectBookOption.dto.Photobook;
import kr.co.hangloo.hangloo.selectBookOption.dto.Thema;

public interface BookOptionRepository {
	
	// 사용자 선택값 저장
	Photobook save(Photobook photobook);
	
	// 테마 전체 조회
	List<Thema> themaList();
	 
	
	
}
