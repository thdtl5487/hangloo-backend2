package kr.co.hangloo.hangloo.makeDetail.repository;

import kr.co.hangloo.hangloo.makeDetail.dto.Monthcover;

public interface MakeDetailRepository {

	//대표이미지 저장
	Monthcover save(Monthcover monthcover);
	
}
