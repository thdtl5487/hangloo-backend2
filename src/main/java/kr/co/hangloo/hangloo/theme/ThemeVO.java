package kr.co.hangloo.hangloo.theme;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "THEME")
public class ThemeVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySequenceGenerator")
	@SequenceGenerator(name = "mySequenceGenerator", sequenceName = "theme_seq", allocationSize = 1)
	@Column(name= "theme_num")
	private Integer themeNum;
	
	@Column(name="theme_main_img", length = 300, nullable = false)
	private String themeMainImg;
	
	@Column(name="theme_name", length = 30, nullable = false)
	private String themeName;
	
	@Column(name="theme_price", nullable = false)
	private Integer themePrice;
	
	@Column(name="theme_sub_img", length = 300, nullable = false)
	private String themeSubImg;
	
}
