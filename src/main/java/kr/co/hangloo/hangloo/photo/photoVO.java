package kr.co.hangloo.hangloo.photo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonAutoDetect
@AllArgsConstructor
@NoArgsConstructor
public class photoVO {
	
	private String picName;
	private Integer noteNum;
	
}
