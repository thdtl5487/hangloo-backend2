package kr.co.hangloo.hangloo.theme;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ThemeController {

	@Autowired
	private ThemeService service;
	
	@GetMapping(value = "/getTheme/{id}") // id를 매개변수로 단일 테마 정보를 검색하는 기능
	public ResponseEntity<Map<String, Object>> GetThemeInfo(@PathVariable("id") Integer id){
		
		return service.selectOne(id);
	}
	
	@GetMapping(value ="/getThemeImg/{id}") // id를 매개변수로 테마의 이미지를 검색하는 기능
	public ResponseEntity<byte[]> GetImage(@PathVariable("id") Integer id){
		return service.selectOneThemeImg(id);
	}
	
	@GetMapping(value ="/getThemeSubImg/{id}") // id를 매개변수로 테마의 이미지를 검색하는 기능
	public ResponseEntity<byte[]> GetSubImage(@PathVariable("id") Integer id){
		return service.selectOneThemeSubImg(id);
	}
	
	@GetMapping(value = "/getThemeAll") // 저장된 모든 테마의 정보를 검색하는 기능
	public ResponseEntity<List<ThemeVO>> GetAllThemeInfo(){
		return service.selectAll();
	} 
}
