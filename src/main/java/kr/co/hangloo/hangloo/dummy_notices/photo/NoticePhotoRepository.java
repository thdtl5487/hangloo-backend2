package kr.co.hangloo.hangloo.dummy_notices.photo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticePhotoRepository extends JpaRepository<NoticePhotoVO, Integer>{
	
	List<NoticePhotoVO> findBynoticeNum(Integer noticeNum);
	
}
