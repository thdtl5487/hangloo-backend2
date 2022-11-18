package kr.co.hangloo.hangloo.makeDatePost;

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
@Table(name = "POST")
@DynamicInsert
@SequenceGenerator(
		name ="POST_SEQ_GEN",
		sequenceName = "POST_SEQ",
		initialValue = 1,
		allocationSize = 1
		)
public class MakeDatePostVO {
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "post_SEQ_GEN"
			)
	@Column(name="post_num")
	private Integer postNum;
	
	@OneToOne
	@JoinColumn(name = "photobook_num", referencedColumnName = "photobook_num")
	private Photobook photobook;

	@Column(name="post_date")
	private String postDate;
	
	@Column(name="post_pic_pos", columnDefinition = "TINYINT", length = 1)
	@ColumnDefault("0")
	private Integer postPicPos;
	
	@Column(name="post_isDel", columnDefinition = "TINYINT", length = 1)
	@ColumnDefault("0")
	private Integer postIsDel;
	
	@Column(name="post_uid")
	private Integer postUid;
	
}
