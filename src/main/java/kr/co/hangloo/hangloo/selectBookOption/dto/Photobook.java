package kr.co.hangloo.hangloo.selectBookOption.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import kr.co.hangloo.hangloo.makeDetail.dto.Monthcover;
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
	
	@OneToOne
	@JoinColumn(name = "Theme_num", referencedColumnName = "Theme_num")
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
	@JoinColumn(name="user_num", referencedColumnName = "user_num")
	private Userinfo userinfo;
//	private int user_num;
	
	@OneToMany(mappedBy = "photobook")
	private List<Monthcover> monthcover = new ArrayList<>();
	
	@Column(length = 30, nullable = false)
	private String photobook_size;
	@Column(length = 30, nullable = false)
	private String photobook_cover;
	@Column(length = 30, nullable = false)
	private String photobook_coting;
	@Column(length = 30, nullable = false)
	private String photobook_inside;
	@Column(length = 30, nullable = false)
	private String photobook_case;
	@Column(nullable = false, columnDefinition = "TINYTNT", length = 1)
	private Integer photobook_quantity;
	@Column(nullable = false, columnDefinition = "TINYTNT", length = 1)
	private Integer photobook_page;
	@Column(nullable = false, columnDefinition = "TINYTNT", length = 1)
	private Integer notice_comment;
	@Column(nullable = false, columnDefinition = "TINYTNT", length = 1)
	private Integer notice_content;
	@Column(nullable = false, columnDefinition = "TINYTNT", length = 1)
	private Integer notice_kids_status;
	@Column(nullable = false, columnDefinition = "TINYTNT", length = 1)
	private Integer notice_pic_qr;
	@Column(nullable = false, columnDefinition = "TINYTNT", length = 1)
	private Integer notice_video_qr;
	@Column(nullable = false, columnDefinition = "TINYTNT", length = 1)
	private Integer post_comment;
	@Column(nullable = false, columnDefinition = "TINYTNT", length = 1)
	private Integer post_content;
	@Column(nullable = false, columnDefinition = "TINYTNT", length = 1)
	private Integer post_pic_qr;
	@Column(nullable = false, columnDefinition = "TINYTNT", length = 1)
	private Integer post_video_qr;
	
}
