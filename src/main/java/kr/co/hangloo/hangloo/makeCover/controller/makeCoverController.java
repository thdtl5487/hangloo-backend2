package kr.co.hangloo.hangloo.makeCover.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kr.co.hangloo.hangloo.makeCover.dto.Cover;
import kr.co.hangloo.hangloo.makeCover.service.MakeCoverService;
import kr.co.hangloo.hangloo.makeDetail.controller.MakeDetailController;
import kr.co.hangloo.hangloo.selectBookOption.dto.Photobook;

@RestController
@RequestMapping("/photobookServer")
public class makeCoverController {
	
	private final MakeCoverService makeCoverService;
	
	@Autowired
	public makeCoverController(MakeCoverService makeCoverService) {
		this.makeCoverService = makeCoverService;
	}

	// 화면이동
	@GetMapping("MakeCover")
	public String makeCoverPage() {
		
		return "makeCover";
	}
	
	// 파일저장
	@PostMapping("MakeCover")
	public void upload(Cover cover, Photobook photobook, @RequestPart(name="file", required = false) MultipartFile file) throws IllegalStateException, IOException {
		
		System.out.println("cover : " + cover.getCover_title());
		System.out.println("photobook : " + photobook.getPhotobook_num());
		System.out.println("file name : " + file.getName());
		// 서비스로 넘겨주기
		makeCoverService.coverSave(cover, photobook, file);
		
		
		
	}
	
	
}
