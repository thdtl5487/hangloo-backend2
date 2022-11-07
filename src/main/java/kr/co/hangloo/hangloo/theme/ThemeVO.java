package kr.co.hangloo.hangloo.theme;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "THEME")
public class ThemeVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "theme_num")
	private Integer themeNum;
	
	@Column(name="theme_main_img", length = 300)
	private String themeMainImg;
	
	@Column(name="theme_name", length = 30)
	private String themeName;
	
	@Column(name="theme_price")
	private Integer themePrice;
	
	@Column(name="theme_sub_img")
	private String themeSubImg;
	
}
