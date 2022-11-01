package kr.co.hangloo.hangloo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.hangloo.hangloo.thema.ThemaRepository;
import kr.co.hangloo.hangloo.thema.ThemaVO;

@SpringBootTest
class HanglooApplicationTests {

	@Autowired
	private ThemaRepository themaRepo;
	
	@Test
	void selectTest() {
		
		List<ThemaVO> voList = this.themaRepo.findAll();
		System.out.println("voList : " + voList.get(0));
		if(voList == null) {
			System.out.println("데이터 안들어왔음");
		}
		for(int i = 0; i<voList.size(); i++) {
			System.out.println("list : " + voList.get(i));
			System.out.println(i + "번째 데이터 : ");
			System.out.println(voList.get(i).getThemaMainImg());
			System.out.println(voList.get(i).getThemaName());
			System.out.println("---------------------------");
		}
	}
	
	@Test
	void selectOne() {
		
		Optional<ThemaVO> oVO = this.themaRepo.findById(1);
		ThemaVO vo = oVO.get();
		
		System.out.println(vo.getThemaMainImg());
		
		
		
		
	}
	
}
