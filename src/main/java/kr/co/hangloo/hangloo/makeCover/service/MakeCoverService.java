package kr.co.hangloo.hangloo.makeCover.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.co.hangloo.hangloo.makeCover.dto.Cover;
import kr.co.hangloo.hangloo.makeCover.repository.MakeCoverRepository;
import kr.co.hangloo.hangloo.selectBookOption.dto.Photobook;

@Service
@Transactional
public class MakeCoverService {

	MakeCoverRepository makeCoverRepository;
	
	@Autowired
	public MakeCoverService(MakeCoverRepository makeCoverRepository) {
		this.makeCoverRepository = makeCoverRepository;
	}

	

	public void coverSave(Cover cover, Photobook photobook, MultipartFile file) throws IllegalStateException, IOException {
		// 포트북번호 저장
		cover.setPhotobook(photobook);
		
		// 사진저장
		String projectpath = "c:\\images\\cover\\";				 
		UUID uuid = UUID.randomUUID();							// 임의값
		String filename = uuid+"_"+file.getOriginalFilename();	// 랜덤값 + 파일이름
		File saveFile = new File(projectpath, filename);		// 지정경로에 저장
		
		
		file.transferTo(saveFile);								 
		
		// 바뀐파일이름으로 dto 저장
		cover.setCover_img(filename);
		
		
		
		
		makeCoverRepository.save(cover);
	}

	

	
	
	
	
	
	
	
	
}
