package kr.co.hangloo.hangloo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PrintTest {
	
	@GetMapping("/testBack")
	public ResponseEntity<String> myTest(){
		
		ResponseEntity<String> result = ResponseEntity.ok("헬로우월드맨~~");
		System.out.println("실행됐음");
		
		return result; 
	}
	
}
