package kr.co.hangloo.hangloo.makeDetail.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

	// 업데이트하기
	@Override
	public String update(String url, String date) {
		System.out.println("업데이트"+ "url="+ url +" date="+ date);
		
		 em.createQuery("update Monthcover m set m.month_cover_url = :url where m.month_cover_date = :date")
				.setParameter("url",url).setParameter("date",date).executeUpdate();
		 em.flush();
		 return "성공"; 
		 
	}


	// 찾기
	@Override
	public List<Monthcover> find(int pNum, String date) {

	return	em.createQuery("select m from Monthcover m where m.photobook.photobook_num = :pNum and m.month_cover_date = :date", Monthcover.class)
			.setParameter("pNum", pNum).setParameter("date", date).getResultList();
			
		
	}


	

}
