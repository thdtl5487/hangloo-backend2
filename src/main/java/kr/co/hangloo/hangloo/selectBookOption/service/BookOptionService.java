package kr.co.hangloo.hangloo.selectBookOption.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import kr.co.hangloo.hangloo.selectBookOption.dto.Photobook;
import kr.co.hangloo.hangloo.selectBookOption.repository.BookOptionRepository;
import kr.co.hangloo.hangloo.theme.ThemeRepository;
import kr.co.hangloo.hangloo.theme.ThemeVO;

@Service
@Transactional
public class BookOptionService {
	
	BookOptionRepository bookOptionRepository;
	
	@Autowired
	ThemeRepository themerepo;
	
	
	@Autowired
	public BookOptionService(BookOptionRepository bookOptionRepository) {
		this.bookOptionRepository = bookOptionRepository;
	}
	
	// 사용자 선택값 저장	
	public Integer option(Photobook photobook) {

		System.out.println("이거 실행은했니???");
		// 레파지토리에 저장
		bookOptionRepository.save(photobook);
		System.out.println("save실행했니????");
		return photobook.getPhotobook_num();
	}
	// 테마리스트 받아오기
	public List<ThemeVO> findthemeList(){
		return bookOptionRepository.themeList();
	}
	
}
