package kr.co.hangloo.hangloo.theme;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<ThemeVO, Integer> {
	
	ThemeVO findBythemeMainImg(String theme_main_img);
	ThemeVO findBythemeSubImg(String theme_sub_img);
	
	
}
