package kr.co.hangloo.hangloo.makeDateNotice;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kr.co.hangloo.hangloo.selectBookOption.dto.Photobook;

public interface MakeDateNoticeRepository extends JpaRepository<MakeDateNoticeVO, Integer>{
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("Update MakeDateNoticeVO n set n.noticeIsDel=?2 where n.noticeNum =?1")
	void updateNoticeIsDel(Integer noticeNum, Integer isDel);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("Update MakeDateNoticeVO n set n.noticePicPos=?2 where n.photobook=?1")
	void updateNoticePicPosAll(Photobook photobookNum, Integer picPos);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("Update MakeDateNoticeVO n set n.noticePicPos=?2 where n.noticeNum=?1")
	void updateNoticePicPosOne(Integer noticeNum, Integer picPos);
}
