package kr.co.hangloo.hangloo.selectBookOption.controller;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.hangloo.hangloo.selectBookOption.dto.Photobook;
import kr.co.hangloo.hangloo.selectBookOption.dto.Thema;
import kr.co.hangloo.hangloo.selectBookOption.dto.Userinfo;
import kr.co.hangloo.hangloo.selectBookOption.service.BookOptionService;

@Controller
public class BookOptionController {
	
	private final BookOptionService bookOptionService;
	
	public BookOptionController(BookOptionService bookOptionService) {
		this.bookOptionService = bookOptionService;
	}
	
	//화면이동
	@GetMapping("SelectBookOption")
	public String selectBookoption(Model model) {
		// 테마리스트 받아와서 넘겨주기
		List<Thema> themas = bookOptionService.findThemaList();
		model.addAttribute("thema", themas);
		System.out.println(themas.get(0).getThema_name());
		
		
		return "selectOption";
	}
	
	//데이터 저장
	@PostMapping("SelectBookOption")
	public String selectBookOptionCreate(Photobook photobook, Thema thema, Userinfo userinfo) {
		//넘어온 테마번호와 유저번호 포토북테이블에 셋팅
		photobook.setThema(thema);
		photobook.setUserinfo(userinfo);
		
		System.out.println(thema.getThema_main_img());
		System.out.println(thema.getThema_name());
		System.out.println(thema.getThema_price());
		System.out.println(thema.getThema_sub_img());
		// 서비스단으로 넘겨주기
		bookOptionService.option(photobook);
	
		
		return "next";
	}
}
