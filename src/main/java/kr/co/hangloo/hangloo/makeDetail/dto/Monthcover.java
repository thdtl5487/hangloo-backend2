package kr.co.hangloo.hangloo.makeDetail.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import kr.co.hangloo.hangloo.selectBookOption.dto.Photobook;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Monthcover {
	
	@Id
	private String month_cover_date;
	
	@ManyToOne
	@JoinColumn(name = "photobook_num", referencedColumnName = "photobook_num")
	private Photobook photobook;
	//	private int photobook_num;
	
	private String month_cover_url;
	
	
}
