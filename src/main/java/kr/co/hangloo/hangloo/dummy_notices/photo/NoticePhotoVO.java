package kr.co.hangloo.hangloo.dummy_notices.photo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Notice_photo")
public class NoticePhotoVO {
	
	@Column(name ="noticeNum")
	@Id
	private Integer noticeNum;
	
	@Column(name ="url")
	private String url;
	
}
