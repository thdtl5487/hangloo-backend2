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
	private Integer theme_num;
	
	@Column(length = 300)
	private String theme_main_img;
	
	@Column(length = 30)
	private String theme_name;
	
	private Integer theme_price;
	
	private String theme_sub_img;
	
}
