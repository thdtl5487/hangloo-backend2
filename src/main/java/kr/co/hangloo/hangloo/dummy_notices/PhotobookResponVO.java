package kr.co.hangloo.hangloo.dummy_notices;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.core.io.JsonStringEncoder;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="PICKNOTICE")
@SequenceGenerator(
		name ="PICKNOTICE_SEQ_GEN",
		sequenceName = "NOTICE_SEQ",
		initialValue = 1,
		allocationSize = 1
		)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PhotobookResponVO {
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "PICKNOTICE_SEQ_GEN"
			)
	@Column(name="notice_num")
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
	
//	@Type(type = "jsonb")
//	@Column(name = "test_col", columnDefinition = "jsonb", nullable = true)
//	private Map<String, Object> testColumn = new HashMap<String, Object>();

}
