package kr.co.hangloo.hangloo.selectBookOption.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import kr.co.hangloo.hangloo.selectBookOption.dto.Photobook;
import kr.co.hangloo.hangloo.selectBookOption.dto.Thema;

@Repository
public class JpaBookOptionRepository implements BookOptionRepository{

	private final EntityManager em;
	public JpaBookOptionRepository(EntityManager em) {
		this.em = em;
	}
	
	// 사용자 선택값 저장하기
	@Override
	public Photobook save(Photobook photobook) {
		
//		photobook.setThema(null);
//		Thema thema = new Thema();
//		thema.setThema_num(photobook.getThema().getThema_num());
//		photobook.changeThema(thema);
		
		// db에 저장
		em.persist(photobook);
		return photobook;
	}

	// 모든 테마 가져오기
	@Override
	public List<Thema> themaList() {
			
		return em.createQuery("select t from Thema t", Thema.class).getResultList();
	}
	
	
	
	
}
