package kr.co.hangloo.hangloo.selectBookOption.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import kr.co.hangloo.hangloo.theme.ThemeVO;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
@Table(name = "Photobook")
public class Photobook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySequenceGenerator")			
	@SequenceGenerator(name = "mySequenceGenerator", sequenceName = "photobook_seq", allocationSize = 1)
	private int photobook_num;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Theme_num")
	private ThemeVO theme;
//	private int thema_num;
	
	// 테마바꾸기
//	public void changeThema(Thema thema) {
//		if(this.thema != null ) {
//			this.thema.getPhotobook().remove(this);
//		}
//		this.thema = thema;
//		thema.getPhotobook().add(this);
//	}
	
	@ManyToOne
	@JoinColumn(name="user_num")
	private Userinfo userinfo;
//	private int user_num;
	
	private String photobook_size;
	private String photobook_cover;
	private String photobook_coting;
	private String photobook_inside;
	private String photobook_case;
	private int photobook_quantity;
	private int photobook_page;
	
}
