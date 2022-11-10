package kr.co.hangloo.hangloo.photo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.hangloo.hangloo.selectBookOption.dto.Photobook;
import kr.co.hangloo.hangloo.selectBookOption.dto.Userinfo;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PhotoController {
	
	
	@RequestMapping(value="/jsonTest", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public @ResponseBody void jsonRequestTest(@RequestBody HashMap<String, Object> jsonData) {
		System.out.println("실행");
		System.out.println("jsonData" + jsonData);
		
		System.out.println(jsonData.get("pickNotePhoto"));
		
	}
	
	@PostMapping(value="/getPictoPidfromPhotobook")
	public @ResponseBody void getPicToPidFromPhotobook(Userinfo user, Photobook photobook, Integer pid) {
		
	}
	
}
