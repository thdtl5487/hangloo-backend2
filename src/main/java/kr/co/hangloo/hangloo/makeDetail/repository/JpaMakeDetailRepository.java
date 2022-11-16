package kr.co.hangloo.hangloo.makeDetail.repository;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import kr.co.hangloo.hangloo.makeDetail.dto.Monthcover;

@Repository
public class JpaMakeDetailRepository implements MakeDetailRepository{
	
	private final EntityManager em;
	public JpaMakeDetailRepository(EntityManager em) {
		this.em = em;
	}
	
	
	// 대표사진 저장
	@Override
	public Monthcover save(Monthcover monthcover) {
		
		// db 저장
		em.persist(monthcover);
		return monthcover;
	}

}
