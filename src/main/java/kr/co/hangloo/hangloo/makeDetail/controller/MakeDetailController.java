package kr.co.hangloo.hangloo.makeDetail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	// 날짜별 대표사진 저장
	@PostMapping("makeDetail")
	public String makeDetailPick(Monthcover monthcover, Photobook photobook) {
		monthcover.setPhotobook(photobook);
		
		// 서비스로 넘겨주기
		makeDetailService.thumnailSave(monthcover);
		
		
		return "next";
	}
	
	
	
}
