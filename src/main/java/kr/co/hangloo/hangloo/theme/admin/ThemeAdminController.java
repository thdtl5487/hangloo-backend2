package kr.co.hangloo.hangloo.theme.admin;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kr.co.hangloo.hangloo.theme.ThemeService;
import kr.co.hangloo.hangloo.theme.ThemeVO;

@Controller
@RequestMapping("/admin")
public class ThemeAdminController {
	
	@Autowired
	ThemeAdminService adminService;	
	
	@Autowired
	ThemeService service;
	
	@GetMapping("/theme")
	public String JoinThemePage() {
		return "/admin/ThemeUpload";
	}
	
	@PostMapping("/themeUpload")
	public String InsertTheme(@RequestParam("mainImg") MultipartFile mainImg, @RequestParam("subImg") MultipartFile subImg, ThemeVO vo)throws Exception {
		if(adminService.searchTheme(vo, mainImg, subImg)) {
			adminService.insertTheme(vo, mainImg, subImg);
			adminService.saveThemeImage(mainImg, subImg);
		}else {
			System.out.println("중복되는 데이터가 있어서 등록실패");
		}
		return "/admin/ThemeUpload";
	}
	
	@GetMapping("/themeList")
	public String selectListTheme(Model model) {
		System.out.println("테마리스트 페이지 접근");
		
		List<ThemeVO> themeList = adminService.selectAll();
		model.addAttribute("themeList", themeList);
		
		return "/admin/ThemeList";
	}
	
	@GetMapping("/removeTheme/{id}")
	public String removeTheme(Integer themaNum) {
		
		return null;
	}
	
}
