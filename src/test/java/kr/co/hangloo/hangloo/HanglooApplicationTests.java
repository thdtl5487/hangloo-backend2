package kr.co.hangloo.hangloo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import kr.co.hangloo.hangloo.thema.ThemaRepository;
//import kr.co.hangloo.hangloo.thema.ThemaVO;
import kr.co.hangloo.hangloo.theme.ThemeRepository;
import kr.co.hangloo.hangloo.theme.ThemeVO;

@SpringBootTest
class HanglooApplicationTests {

	@Autowired
	private ThemeRepository themeRepo;
	
	@Test
	void selectTest() {
		
		List<ThemeVO> voList = this.themeRepo.findAll();
		System.out.println("voList : " + voList.get(0));
		if(voList == null) {
			System.out.println("데이터 안들어왔음");
		}
		for(int i = 0; i<voList.size(); i++) {
			System.out.println("list : " + voList.get(i));
			System.out.println(i + "번째 데이터 : ");
			System.out.println(voList.get(i).getThemeMainImg());
			System.out.println(voList.get(i).getThemeName());
			System.out.println("---------------------------");
		}
	}
	
	@Test
	void selectOne() {
		
		Optional<ThemeVO> oVO = this.themeRepo.findById(1);
		ThemeVO vo = oVO.get();
		
		System.out.println(vo.getThemeMainImg());
		
		
		
		
	}
	
}
