package kr.co.hangloo.hangloo.makeCover.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import kr.co.hangloo.hangloo.selectBookOption.dto.Photobook;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
@Table(name = "Cover")
public class Cover {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySequenceGenerator")
	@SequenceGenerator(name = "mySequenceGenerator", sequenceName = "cover_seq", allocationSize = 1)
	private int cover_num;
	
	@OneToOne
	@JoinColumn(name = "photobook_num", referencedColumnName = "photobook_num")
	private Photobook photobook;
	// private int photo_num;
	
	private String cover_img;
	private String cover_title;
	
	
	

}
