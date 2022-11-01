package kr.co.hangloo.hangloo.theme;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

@Service
public class ThemeService {
	
	static final String FILE_PATH = "c:\\images\\theme\\";
	
	@Autowired
	private ThemeRepository repo;
	
	// 하나의 테마 정보만 가져오는 기능
	public ResponseEntity<Map<String, Object>> selectOne(Integer num){
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		Optional<ThemeVO> oVO = repo.findById(num);
		
		ThemeVO themeVO = new ThemeVO();
		themeVO = oVO.get();
		
		result.put("theme", themeVO);
		return ResponseEntity.ok(result);
	}
	
	// 테마VO 전체 리스트를 가져오는 서비스 기능
	public ResponseEntity<List<ThemeVO>> selectAll(){
		List<ThemeVO> result = repo.findAll();
		
		return ResponseEntity.ok(result);
	}
	
	// 하나의 테마 이미지만 가져오는 기능
	public ResponseEntity<byte[]> selectOneThemeImg(Integer num){
		
		ResponseEntity<byte[]> result = null;
		
		Optional<ThemeVO> oVO = repo.findById(num);
		ThemeVO themeVO = oVO.get();
		String fileName = themeVO.getTheme_main_img();
		File file = new File(FILE_PATH + fileName);
		
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 테마의 서브 이미지를 가져오는 기능
	public ResponseEntity<byte[]> selectOneThemeSubImg(Integer num){
		
		ResponseEntity<byte[]> result = null;
		
		Optional<ThemeVO> oVO = repo.findById(num);
		ThemeVO themeVO = oVO.get();
		String fileName = themeVO.getTheme_sub_img();
		File file = new File(FILE_PATH + fileName);
		
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
