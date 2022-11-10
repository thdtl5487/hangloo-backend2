package kr.co.hangloo.hangloo.dummy_notices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import kr.co.hangloo.hangloo.dummy_notices.photo.NoticePhotoRepository;
import kr.co.hangloo.hangloo.dummy_notices.photo.NoticePhotoVO;

@Service
public class DummyNoticesService {

	@Autowired
	private DummyNoticesRepository repo;
	
	@Autowired
	private NoticePhotoRepository photoRepo;
	
	public void saveData(DummyNoticesVO noticeVO) {
		
		System.out.println("service에서 실행한 log : "+noticeVO.getNoticeTitle());
		
		repo.save(noticeVO);
		
	}
	
	public ResponseEntity<List<DummyNoticesVO>> getAll(){
		
		List<DummyNoticesVO> result = repo.findAll();
		
		return ResponseEntity.ok(result);
		
	}
	
	public ResponseEntity<List<NoticePhotoVO>> getPhoto(Integer noticeNum){
		
		List<NoticePhotoVO> result = photoRepo.findBynoticeNum(noticeNum);
		
		return ResponseEntity.ok(result);
	}
	
}
