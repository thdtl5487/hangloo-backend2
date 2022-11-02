package kr.co.hangloo.hangloo.theme.admin;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kr.co.hangloo.hangloo.theme.ThemeVO;

@Controller
@RequestMapping("/admin")
public class ThemeAdminController {
	
	@Autowired
	ThemeAdminService service;	
	
	@GetMapping("/theme")
	public String JoinThemePage() {
		return "/admin/ThemeUpload";
	}
	
	@PostMapping("/themeUpload")
	public String InsertTheme(@RequestParam("mainImg") MultipartFile mainImg, @RequestParam("subImg") MultipartFile subImg, ThemeVO vo)throws Exception {
		System.out.println(mainImg.getOriginalFilename());
		System.out.println(subImg.getOriginalFilename());
		System.out.println("테마 이름 : "+vo.getThemeName());
		System.out.println("@@@@@@@@@@@@@@@@@@InsertTheme 실행했음");
//		System.out.println("테마이름 : "+theme_name);		
		
		if(service.searchTheme(vo, mainImg, subImg)) {
			service.insertTheme(vo, mainImg, subImg);
			service.saveThemeImage(mainImg, subImg);
		}else {
			System.out.println("중복되는 데이터가 있어서 등록실패");
		}
				
		
		return "/admin/ThemeUpload";
	}
	
}
