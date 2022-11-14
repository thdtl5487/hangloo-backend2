package kr.co.hangloo.hangloo.dummy_notices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.hangloo.hangloo.dummy_notices.photo.NoticePhotoVO;
import kr.co.hangloo.hangloo.photo.photoVO;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/photobookServer")
public class DummyNoticesController {
	
	@Autowired
	DummyNoticesService service;
	
	// 모든 알림장 정보 받아오기
	@GetMapping(value ="/getAllNoticesInfo")
	public ResponseEntity<List<DummyNoticesVO>> getAllNoticesInfo(){
			
		return service.getAll();
	}
	
	// noticeNum으로 검색한 이미지 리스트로 전달받기
	@PostMapping(value ="/getPhotoToNoticeNum")
	public ResponseEntity<List<NoticePhotoVO>> getPhotoToNoticeNum(@RequestBody HashMap<String, Object> requestJsonHashMap){
		
//		System.out.println(requestJsonHashMap.get("noticeNum"));
		
		Integer getNum = (Integer)requestJsonHashMap.get("noticeNum");
		
		System.out.println("찾고있는 사진 번호 : " + getNum);
		
		return service.getPhoto(getNum);
	}
}