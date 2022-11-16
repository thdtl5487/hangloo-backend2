package kr.co.hangloo.hangloo.makeCover.repository;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import kr.co.hangloo.hangloo.makeCover.dto.Cover;

@Repository
public class JpaMakeCoverRepository implements MakeCoverRepository{

	private final EntityManager em;
	public JpaMakeCoverRepository(EntityManager em) {
		this.em = em;
	}
	
	
	@Override
	public Cover save(Cover cover) {
		
		em.persist(cover);
		
		return null;
	}

}
