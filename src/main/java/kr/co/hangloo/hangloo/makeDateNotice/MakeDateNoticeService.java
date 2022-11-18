package kr.co.hangloo.hangloo.makeDateNotice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MakeDateNoticeService {
	
	@Autowired
	MakeDateNoticeRepository noticeRepo;
	
	public void bulkInsert(List<MakeDateNoticeVO> voList) {
		noticeRepo.saveAll(voList);
	}
	
}
