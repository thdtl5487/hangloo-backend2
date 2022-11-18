package kr.co.hangloo.hangloo.makeDateNotice;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import kr.co.hangloo.hangloo.selectBookOption.dto.Photobook;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "NOTICE")
@DynamicInsert
@SequenceGenerator(
		name ="NOTICE_SEQ_GEN",
		sequenceName = "NOTICE_SEQ",
		initialValue = 1,
		allocationSize = 1
		)
public class MakeDateNoticeVO {
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "NOTICE_SEQ_GEN"
			)
	@Column(name="notice_num")
	private Integer noticeNum;
	
	@OneToOne
	@JoinColumn(name = "photobook_num", referencedColumnName = "photobook_num")
	private Photobook photobook;

	@Column(name="notice_date")
	private String noticeDate;
	
	@Column(name="notice_pic_pos", columnDefinition = "TINYINT", length = 1)
	@ColumnDefault("0")
	private Integer noticePicPos;
	
	@Column(name="notice_isDel", columnDefinition = "TINYINT", length = 1)
	@ColumnDefault("0")
	private Integer noticeIsDel;
	
	@Column(name="notice_uid")
	private Integer noticeUid;
	
}
