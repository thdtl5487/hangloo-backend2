package kr.co.hangloo.hangloo.makeDatePost;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.hangloo.hangloo.CommonUtil;
import kr.co.hangloo.hangloo.dummy_notices.JsonUtil;
import kr.co.hangloo.hangloo.selectBookOption.dto.Photobook;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/photobookServer")
public class MakeDatePostController {
	
	@Autowired
	MakeDatePostService postService;
	
	@PostMapping("/sendPhotoPostInfo")
	public ResponseEntity<String> getPhotoNoticeInfo(@RequestBody String req){
		List<MakeDatePostVO> voList = new ArrayList<>();
		Photobook pbNum = new Photobook();
		CommonUtil util = new CommonUtil();
		
		pbNum.setPhotobook_num(1003);
		System.out.println("req : "+req);
		
		JSONArray jArray = new JSONArray(req.substring(req.indexOf('['), req.indexOf("]}")+1));
		for(int i = 0; i < jArray.length(); i++) {
			MakeDatePostVO vo = new MakeDatePostVO();
			JSONObject jObj = jArray.getJSONObject(i);
			
			vo.setPostDate(util.dateFormatChange(jObj.getString("dateWeek").substring(0, 8)));
			Integer getUID = Integer.parseInt(jObj.getString("linkUrl").substring(jObj.getString("linkUrl").indexOf("uid=")+4));
			
			vo.setPostUid(getUID);
			vo.setPhotobook(pbNum);
			voList.add(vo);
		}
		
		postService.bulkInsert(voList);

		return ResponseEntity.ok("success");
	}
}
