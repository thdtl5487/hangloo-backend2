package kr.co.hangloo.hangloo.selectBookOption.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.hangloo.hangloo.selectBookOption.dto.Photobook;

import kr.co.hangloo.hangloo.selectBookOption.dto.Userinfo;
import kr.co.hangloo.hangloo.selectBookOption.service.BookOptionService;
import kr.co.hangloo.hangloo.theme.ThemeRepository;
import kr.co.hangloo.hangloo.theme.ThemeVO;

@Controller
public class BookOptionController {
	
	private final BookOptionService bookOptionService;
	
	@Autowired
	ThemeRepository themeRepo;
	
	public BookOptionController(BookOptionService bookOptionService) {
		this.bookOptionService = bookOptionService;
	}
	
	//화면이동
	@GetMapping("SelectBookOption")
	public String selectBookoption(Model model) {
		// 테마리스트 받아와서 넘겨주기
		List<ThemeVO> themes = themeRepo.findAll();
		model.addAttribute("theme", themes);
//		System.out.println(themes.get(0).gettheme_name());
		
		
		return "selectOption";
	}
	
	//데이터 저장
	@PostMapping("SelectBookOption")
	public String selectBookOptionCreate(Photobook photobook, ThemeVO theme, Userinfo userinfo) {
		//넘어온 테마번호와 유저번호 포토북테이블에 셋팅
		photobook.setTheme(theme);
		photobook.setUserinfo(userinfo);
		
//		System.out.println(theme.getThemeMainImg());
//		System.out.println(theme.getThemeName());
//		System.out.println(theme.gettheme_price());
//		System.out.println(theme.gettheme_sub_img());
		// 서비스단으로 넘겨주기
		bookOptionService.option(photobook);
	
		
		return "next";
	}
}
