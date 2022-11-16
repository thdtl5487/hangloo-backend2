package kr.co.hangloo.hangloo.selectBookOption.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

//@Entity @Getter @Setter
public class Thema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySequenceGenerator")
	@SequenceGenerator(name = "mySequenceGenerator", sequenceName = "thema_seq", allocationSize = 1)
	private int thema_num;
	
//	@OneToMany(mappedBy = "thema")
//	@OneToOne(mappedBy = "thema")
//	private List<Photobook> photobook = new ArrayList<>();
	
	private String thema_main_img;
	private String thema_sub_img;
	private String thema_name;
	private int thema_price;
	
	
	
	
	
}
