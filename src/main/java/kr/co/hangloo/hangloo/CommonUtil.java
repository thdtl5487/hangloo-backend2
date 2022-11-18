package kr.co.hangloo.hangloo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {

	public String dateFormatChange(String originDate) {
		
		Date tempDate = new Date();
		String result = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yy.MM.dd");
		
		try {
			tempDate = sdf.parse(originDate);
			sdf.applyPattern("yyyy-MM-dd");
			System.out.println(sdf.format(tempDate));
			result = sdf.format(tempDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("올바른 날짜 포맷이 아닙니다");
		}
		
		return result;
	}
	
}
