package kr.co.hangloo.hangloo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.hangloo.hangloo.makeDateNotice.MakeDateNoticeRepository;
import kr.co.hangloo.hangloo.makeDateNotice.MakeDateNoticeVO;
import kr.co.hangloo.hangloo.selectBookOption.dto.Photobook;
//import kr.co.hangloo.hangloo.thema.ThemaRepository;
//import kr.co.hangloo.hangloo.thema.ThemaVO;
import kr.co.hangloo.hangloo.theme.ThemeRepository;
import kr.co.hangloo.hangloo.theme.ThemeVO;

@SpringBootTest
class HanglooApplicationTests {

	@Autowired
	private ThemeRepository themeRepo;
	
	@Autowired
	private MakeDateNoticeRepository noticeRepo;
	
	void selectTest() {
		
		List<ThemeVO> voList = this.themeRepo.findAll();
		System.out.println("voList : " + voList.get(0));
		if(voList == null) {
			System.out.println("데이터 안들어왔음");
		}
		for(int i = 0; i<voList.size(); i++) {
			System.out.println("list : " + voList.get(i));
			System.out.println(i + "번째 데이터 : ");

//			System.out.println(voList.get(i).getTheme_main_img());
			System.out.println(voList.get(i).getThemeMainImg());
//			System.out.println(voList.get(i).getTheme_name());

			System.out.println(voList.get(i).getThemeName());
			System.out.println("---------------------------");
		}
	}
	
	void selectOne() {
		
		Optional<ThemeVO> oVO = this.themeRepo.findById(1);
		ThemeVO vo = oVO.get();
	}
	
//	@Test
	void noticeInsertTest() {
		
		MakeDateNoticeVO noticeVO = new MakeDateNoticeVO();
		Photobook pbNum = new Photobook();
		pbNum.setPhotobook_num(99);
		
		noticeVO.setNoticeDate("2022-10-12");
		noticeVO.setNoticeUid(1341);
		noticeVO.setPhotobook(pbNum);
		
		noticeRepo.save(noticeVO);
		
	}
	
//	@Test
	void noticeIsDelTest() {
		noticeRepo.updateNoticeIsDel(13, 1);
	}
	
//	@Test
	void noticePicPosAll() {
		Photobook pbNum = new Photobook();
		pbNum.setPhotobook_num(1003);
		noticeRepo.updateNoticePicPosAll(pbNum, 1);
	}
	
	@Test
	void noticePicPosOne() {
		noticeRepo.updateNoticePicPosOne(15, 0);
	}
}
