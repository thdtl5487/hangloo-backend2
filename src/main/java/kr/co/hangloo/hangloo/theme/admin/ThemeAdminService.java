package kr.co.hangloo.hangloo.theme.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.hangloo.hangloo.theme.ThemeRepository;
import kr.co.hangloo.hangloo.theme.ThemeVO;

@Service
public class ThemeAdminService {
	
	static final String FILE_PATH = "c:\\images\\theme\\";
	
	@Autowired
	ThemeRepository repo;
	
	public Boolean searchTheme(ThemeVO themeVO, MultipartFile mainImg, MultipartFile subImg) {
		Boolean isExist;
		ThemeVO existVO = repo.findBythemeMainImg(mainImg.getOriginalFilename());
		if(existVO != null) {
			System.out.println("이거 중복되는 메인이미지 이름임");
			return false;
		}
		
		existVO = repo.findBythemeSubImg(subImg.getOriginalFilename());
		if(existVO != null) {
			System.out.println("이거 중복되는 서브이미지 이름임");
			return false;
		}
		
		return true;
	}
	
	// 입력받은 데이터를 DB에 저장
	public void insertTheme(ThemeVO themeVO, MultipartFile mainImg, MultipartFile subImg) {
		ThemeVO saveData = new ThemeVO();
		saveData = themeVO;
		saveData.setThemeMainImg(mainImg.getOriginalFilename());
		saveData.setThemeSubImg(subImg.getOriginalFilename());
				
		repo.save(themeVO);
	}
	
	// 업로드한 이미지를 서버 컴퓨터에 저장하는 기능
	public void saveThemeImage(MultipartFile mainImg, MultipartFile subImg) throws Exception{
		mainImg.transferTo(new File(FILE_PATH + mainImg.getOriginalFilename()));
		subImg.transferTo(new File(FILE_PATH + subImg.getOriginalFilename()));
	}
	
	public List<ThemeVO> selectAll(){
		
		List<ThemeVO> result = repo.findAll();
		
		return result;
	}
	
	
	public void removeTheme(ThemeVO themeVO) throws IOException {
		
		Optional<ThemeVO> oVO = repo.findById(themeVO.getThemeNum());
		themeVO = oVO.get();
				
		Path mainImg = Paths.get(FILE_PATH + themeVO.getThemeMainImg());
		Path subImg = Paths.get(FILE_PATH + themeVO.getThemeSubImg());
		System.out.println("mainImg : " + mainImg);
		
		Files.delete(mainImg);
		Files.delete(subImg);
		
		repo.deleteById(themeVO.getThemeNum());
	}
}
