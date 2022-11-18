package kr.co.hangloo.hangloo.makeDetail.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.hangloo.hangloo.makeDetail.dto.Monthcover;
import kr.co.hangloo.hangloo.makeDetail.service.MakeDetailService;
import kr.co.hangloo.hangloo.selectBookOption.dto.Photobook;

@Controller
@RequestMapping("/photobookServer")
public class MakeDetailController {

	private final MakeDetailService makeDetailService;
	
	@Autowired
	public MakeDetailController(MakeDetailService makeDetailService) {
		this.makeDetailService = makeDetailService;
	}
	
	// 화면이동
	@GetMapping("makeDetail")
	public String makeDetail() {
		
		
		
		return "makeDetail";
	}
//	
	// 날짜별 대표사진 저장
	@PostMapping("makeDetail")
	public String makeDetailPick(Monthcover monthcover, Photobook photobook) {
		
		monthcover.setPhotobook(photobook);
		
		
		
		System.out.println("시작"+ "url="+ monthcover.getMonth_cover_url() +" date="+ monthcover.getMonth_cover_date());
		
		System.out.println(" ?" + makeDetailService.check(monthcover));
		if( makeDetailService.check(monthcover) ) { 
			System.out.println("들어옴");
			makeDetailService.thumnailUpdate(monthcover);
			
			return "next";
		}
		 
		// 서비스단에서 저장하기
		makeDetailService.thumnailSave(monthcover);
		
		
		return "next";
	}
	
	
}
