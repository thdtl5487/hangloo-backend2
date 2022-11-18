package kr.co.hangloo.hangloo.makeDetail.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import kr.co.hangloo.hangloo.selectBookOption.dto.Photobook;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
@Table(name = "Monthcover")
public class Monthcover {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySequenceGenerator")			
	@SequenceGenerator(name = "mySequenceGenerator", sequenceName = "monthcover_seq", allocationSize = 1)
	private Integer month_cover_num;
	
	@ManyToOne
	@JoinColumn(name = "photobook_num", referencedColumnName = "photobook_num")
	private Photobook photobook;
	//	private int photobook_num;
	
	@Column(nullable = false)
	private String month_cover_date;
	@Column(length = 45, nullable = false)
	private String month_cover_url;
	
	
}
