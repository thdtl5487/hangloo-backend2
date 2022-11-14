package kr.co.hangloo.hangloo.dummy_notices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/photobookServer")
public class PhotoBookController {
	
	@PostMapping(value = "/sendPhotoAlbumInfo")
	public void sendPhotoAlbumData(@RequestBody List<HashMap<String, Object>> req) {
				
		for(int i = 0; i<req.size(); i++) {
			System.out.println("수신한 정보 : "+req.get(i));
		}
		
		System.out.println(req.get(0).getClass().getName());
		System.out.println(req.get(0).get("noticeNum"));
		
		System.out.println(req.get(req.size()-1).get("data"));
		// 파싱 테스트 시작 -------------------
		
		String testStr = req.get(req.size()-1).get("data").toString(); 
		
		 
		getJsonValueFromStringJsonArray(testStr, "aaa");
		getJsonValueFromStringJsonArray(testStr, "bbb");
		getJsonValueFromStringJsonArray(testStr, "ccc");
	
	}
	
	
	// 리스트형 문자열 데이터의 value를 추출하는 함수
	public String getJsonValueFromStringJsonArray(String jsonArray ,String key) {
		
		String value = "";
		
		if(jsonArray.contains(key)) {
			int target_num = jsonArray.indexOf(key);
			if(jsonArray.substring(target_num).contains(",")) { // 마지막 element인지 확인하기 위한 조건문
				value = jsonArray.substring(target_num + key.length() +1, (jsonArray.substring(target_num).indexOf(',') + target_num));				
			}else {
				value = jsonArray.substring(target_num + key.length() +1, (jsonArray.substring(target_num).indexOf('}') + target_num));
			}	
		}else {
			System.out.println("해당 문자가 존재하지않음");
			return null;
		}
		return value;
	}
	
}