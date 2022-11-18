package kr.co.hangloo.hangloo.makeDatePost;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kr.co.hangloo.hangloo.selectBookOption.dto.Photobook;

public interface MakeDatePostRepository extends JpaRepository<MakeDatePostVO, Integer>{
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("Update MakeDatePostVO n set n.postIsDel=?2 where n.postNum =?1")
	void updateNoticeIsDel(Integer noticeNum, Integer isDel);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("Update MakeDatePostVO n set n.postPicPos=?2 where n.photobook=?1")
	void updateNoticePicPosAll(Photobook photobookNum, Integer picPos);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("Update MakeDatePostVO n set n.postPicPos=?2 where n.postNum=?1")
	void updateNoticePicPosOne(Integer noticeNum, Integer picPos);
}
