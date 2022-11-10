package kr.co.hangloo.hangloo.dummy_notices;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="Dummy_Notices")
public class DummyNoticesVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "dummyNoticeSeq", sequenceName = "dummy_notice_seq", allocationSize = 1)
	@Column(name ="notice_num")
	private Integer noticeNum;
	
	@Column(name ="notice_title")
	private String noticeTitle;
	
	@Column(name ="notice_writer")
	private String noticeWriter;
	
	@Column(name = "notice_content")
	private String noticeContent;
	
	@Column(name ="notice_fromhome")
	private Boolean noticeFromHome;
	
	@Column(name ="notice_kids_status")
	private String noticeKidsStatus;
	
	@Column(name ="notice_regdate")
	private Date noticeRegDate;	

}
