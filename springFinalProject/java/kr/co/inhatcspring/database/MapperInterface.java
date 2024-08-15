package kr.co.inhatcspring.database;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.inhatcspring.beans.freeBoardVO;
import kr.co.inhatcspring.beans.userVO;

/**
 * MyBatis 매퍼 인터페이스입니다.
 * SQLmapper를 통해 SQL 로직을 해당 인터페이스를 통해 처리합니다.
 */
public interface MapperInterface {

    /**
     * 게시판 글 작성 쿼리
     * @param freeBoardVO 작성할 게시물 데이터를 담은 객체
     */
	@Insert("INSERT INTO freeboard (userId, title, boardContent, nowDate, boardCategory) " +
	        "VALUES (#{userId, jdbcType=VARCHAR}, #{title}, #{boardContent}, SYSDATE, #{boardCategory})")
	void write_board(freeBoardVO freeBoardVO);

	
    /**
     * 게시판 글 수정 쿼리
     * @param freeBoardVO 수정할 게시물 데이터를 담은 객체
     */
	@Update("UPDATE freeboard SET title = #{title}, boardContent = #{boardContent} WHERE boardID = #{boardID}")
	void update_board(freeBoardVO freeBoardVO);
	
    /**
     * 특정 카테고리의 게시판 글 목록 조회 쿼리
     * @param boardCategory 조회할 게시판 카테고리
     * @return 해당 카테고리의 글 목록
     */
    @Select("SELECT * FROM freeboard where boardCategory = #{boardCategory} order by nowDate desc")
    List<freeBoardVO> search_board(String boardCategory);
    
    /**
     * 특정 글의 상세 내용 조회 쿼리
     * @param boardID 조회할 글의 고유 번호
     * @return 해당 글의 상세 내용
     */
    @Select("SELECT * FROM freeboard where boardID = #{boardID}")
    freeBoardVO view_board(int boardID);
    
    /**
     * 특정 글 삭제 쿼리
     * @param boardID 삭제할 글의 고유 번호
     */
    @Delete("DELETE FROM freeboard where boardID = #{boardID}")
    void delete_board(int boardID);
   
    
    
    
    /*** 회원관리 ***/
    
    
    //회원가입을 위한 SQL 쿼리
    //USERS 테이블에 새로운 사용자 정보를 삽입하는 메서드
    @Insert("INSERT INTO USERS (USERID, USERNAME, PASSWORD) VALUES (#{userId, jdbcType=VARCHAR}, "
    		+ "#{userName, jdbcType=VARCHAR}, #{password, jdbcType=VARCHAR})")
    void register_user(userVO userVO);

    //사용자 ID로 사용자를 조회하는 SQL 쿼리
    //특정 사용자 ID로 사용자 정보를 조회하는 메서드
    @Select("SELECT * FROM USERS WHERE USERID = #{userId}")
    userVO getUserById(String userId);
    
    //사용자 정보를 업데이트하는 SQL 쿼리
    //특정 사용자 ID로 사용자 정보를 업데이트하는 메서드
	@Update("UPDATE USERS SET userId = #{userId}, password = #{password}, userName = #{userName} WHERE userId = #{userId}")
	void update_user(userVO userVO);
	
	//특정 사용자 ID로 해당 사용자가 작성한 게시물 목록을 조회하는 SQL 쿼리
	//FREEBOAD 테이블에서 사용자 ID로 게시물 목록을 조회하는 메서드
    @Select("SELECT * FROM FREEBOARD WHERE USERID = #{userId, jdbcType=VARCHAR}")
    List<freeBoardVO> getMyBoards(String userId);
}
