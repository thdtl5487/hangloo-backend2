package kr.co.hangloo.hangloo.dummy_notices;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;

public interface DummyNoticesRepository extends JpaRepository<DummyNoticesVO, Integer>{

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("Update DummyNoticesVO n set n.noticeContent=?2 where n.noticeNum = ?1")
	void updateNoticesContent(Integer nn, String c);
}
