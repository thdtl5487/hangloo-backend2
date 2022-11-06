package kr.co.hangloo.hangloo.selectBookOption.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Userinfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySequenceGenerator")
	@SequenceGenerator(name = "mySequenceGenerator", sequenceName = "userinfo_seq", allocationSize = 1 )
	private int user_num;
	
	@OneToMany(mappedBy = "userinfo")
	private List<Photobook> photobook = new ArrayList<>();
	
	private String user_id;
	
}
