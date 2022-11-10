package kr.co.hangloo.hangloo.dummy_notices;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.hangloo.hangloo.dummy_notices.photo.NoticePhotoRepository;
import kr.co.hangloo.hangloo.dummy_notices.photo.NoticePhotoVO;

@SpringBootTest
class DummyNoticesServiceTest {

	@Autowired
	DummyNoticesService service;
	
	@Autowired
	DummyNoticesRepository repo;
	
	@Autowired
	NoticePhotoRepository photoRepo;
	
//	@Test
	void insertTest() {
		
		Date today = new Date();
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
				
		for(int i = 1; i<=100; i++) {
			
			DummyNoticesVO vo = new DummyNoticesVO();
						
			if(i % 10 == 0) {
				
				vo.setNoticeKidsStatus("나빴따");
			}else {
				
				vo.setNoticeKidsStatus("조아따");
				vo.setNoticeContent("내용내용" + i);
			}
			
			if(i % 5 == 0) {
				vo.setNoticeFromHome(true);
			}else{
				vo.setNoticeFromHome(false);
			}
			
			vo.setNoticeTitle("알림장제목 " +i);
			vo.setNoticeWriter("제이스쌤");
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -2 * i);
			cal.add(Calendar.YEAR, -2);
			
			today = new Date(cal.getTimeInMillis());
			
			vo.setNoticeRegDate(today);
			
			System.out.println(vo.getNoticeRegDate());
			
			service.saveData(vo);
		}
	}
	
	@Test
	void matchedPhoto() {
		
		NoticePhotoVO vo = new NoticePhotoVO();
		
		List<String> urlList = new ArrayList<String>();
		
		urlList.add("https://s3.ap-northeast-2.amazonaws.com/hangloo.erp/94811/picture/82186/221005142118_2393_thumb.jpg?v=1");
		urlList.add("https://s3.ap-northeast-2.amazonaws.com/hangloo.erp/94811/picture/82186/221005142119_5742_thumb.jpg?v=1");
		urlList.add("https://s3.ap-northeast-2.amazonaws.com/hangloo.erp/94811/picture/82186/221005142119_7296_thumb.jpg?v=1");
		urlList.add("https://s3.ap-northeast-2.amazonaws.com/hangloo.erp/94811/picture/82186/221005142340_3035_thumb.jpg?v=1");
		urlList.add("https://s3.ap-northeast-2.amazonaws.com/hangloo.erp/94811/picture/82186/221005142340_4341_thumb.jpg?v=1");
		urlList.add("https://s3.ap-northeast-2.amazonaws.com/hangloo.erp/94811/picture/82186/221005142341_8110_thumb.jpg?v=1");
		
		
		int random = 0;
		
		for(int i = 1; i<=100; i++) {
			if(random == 0) {
				vo.setUrl(urlList.get(random));
				vo.setNoticeNum(700+i);
				photoRepo.save(vo);
				random +=1;
			}else if(random == 1) {
				vo.setUrl(urlList.get(random));
				vo.setNoticeNum(700+i);
				photoRepo.save(vo);
				random +=1;
			}else if(random == 2) {
				vo.setUrl(urlList.get(random));
				vo.setNoticeNum(700+i);
				photoRepo.save(vo);
				random +=1;
			}else if(random == 3) {
				vo.setUrl(urlList.get(random));
				vo.setNoticeNum(700+i);
				photoRepo.save(vo);
				random +=1;
			}else if(random == 4) {
				vo.setUrl(urlList.get(random));
				vo.setNoticeNum(700+i);
				photoRepo.save(vo);
				random +=1;
			}else if(random == 5) {
				vo.setUrl(urlList.get(random));
				vo.setNoticeNum(700+i);
				photoRepo.save(vo);
				random = 0;
			}
		}
	}
	
//	@Test
	@DisplayName("업데이트 컨텐트 실행")
	void updateContent() {
		
		DummyNoticesVO vo = new DummyNoticesVO();
		
		for(int i = 501; i<= 600; i++) {
			if(i%10 == 0) {
				
			}else {
				vo.setNoticeNum(i);
				vo.setNoticeContent("알림장내용"+i);
				repo.updateNoticesContent(vo.getNoticeNum(), vo.getNoticeContent());
			}
		}
		
	}
	
	
	
	
}
