package kr.co.inhatcspring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.inhatcspring.beans.freeBoardVO;
import kr.co.inhatcspring.beans.userVO;
import kr.co.inhatcspring.database.MapperInterface;

/**
 * 게시판과 관련된 요청을 처리하는 컨트롤러 클래스입니다.
 */
@Controller
public class BoardController {
	
	@Autowired
	MapperInterface board_mapper;	
	
	/**
	 * 게시판에 글을 작성하는 페이지로 이동합니다.
	 * @param boardCategory 게시판 카테고리
	 * @param model 게시판 카테고리를 분류할 수 있는 매개변수를 함께 model에 심습니다.
	 * @return writeBoard.jsp 뷰 페이지
	 */
	@RequestMapping(value = "/writeBoard")
	public String writeFreeBoard(@RequestParam("boardCategory") String boardCategory, Model model) {

	    model.addAttribute("boardCategory", boardCategory);
	    return "writeBoard";
	}

	/**
	 * 게시판 페이지로 이동하고 해당 카테고리의 글 목록을 보여줍니다.
	 * CategoryName은 존재하지 않을 경우여도 에러를 발생시키지 않습니다.	
	 * 
	 * @param model SQLMapper에 의해 카테고리에 해당하는 게시물을 저장한 model
	 * @param boardCategory 게시판 카테고리
	 * @param buttonValue 카테고리 명
	 * @return board.jsp 뷰 페이지
	 * @return comToInhatc.jsp 일반 게시판이 아닌, "오시는 길" 카테고리 반환 뷰 페이지
	 */
	
	@RequestMapping(value ="/board", method = RequestMethod.POST)
	public String freeBoard(Model model,
	                        @RequestParam("boardCategory") String boardCategory,
	                        @RequestParam(value = "buttonValue", required = false) String CategoryName,
	                        HttpServletRequest request,
	                        HttpSession session) {
	    

	    
	    //현재 로그인한 사용자의 정보 가져오기
	    userVO currentUser = (userVO) session.getAttribute("currentUser");
	    String userId = currentUser.getUserId();
	    
	    model.addAttribute("boardCategory", boardCategory);
	    
	    if (CategoryName != null)
	        model.addAttribute("CategoryName", CategoryName);
	    
	    //특정 카테고리에 대한 예외 처리
	    if(boardCategory.equals("comToInhatc")) return "comToInhatc";
	    
	    //해당 카테고리의 게시글 목록 가져오기
	    List<freeBoardVO> list = board_mapper.search_board(boardCategory);
	    model.addAttribute("list", list);
	    
	    //현재 로그인한 사용자의 아이디를 모델에 추가
	    model.addAttribute("userId", userId);
	    
	    return "board";
	}

	/**
	 * 게시물 상세 내용을 보여주는 페이지로 이동합니다.
	 * @param model 뷰로 반환할 페이지를 심은 model
	 * @param boardID 게시물 고유 번호
	 * @return viewBoard.jsp 뷰 페이지
	 */
	
	@RequestMapping(value ="/viewBoard")
	public String viewBoard(Model model,@RequestParam("boardID") int boardID, HttpSession session) {
		
	    // 현재 로그인한 사용자의 정보 가져오기
	    userVO currentUser = (userVO) session.getAttribute("currentUser");
	    String userId = currentUser.getUserId();
	    
	    //해당 게시물의 상세 내용 가져오기
		freeBoardVO view = board_mapper.view_board(boardID); 
		model.addAttribute("view",view);
		
	    // 현재 로그인한 사용자의 아이디를 모델에 추가
	    model.addAttribute("userId", userId);
	    
		return "viewBoard";
	}
	
	/**
	 * 작성한 게시물을 DB에 저장 후, 게시판으로 돌아갑니다.
	 * @param freeBoardVO 작성할 게시물 데이터 객체
	 * @param model 카테고리에 해당하는 게시물 list를 담은 model	
	 * @return board.jsp 뷰 페이지
	 */
	
	@RequestMapping(value = "/actionWriteBoard", method = RequestMethod.POST)
	public String writeActionBoard(freeBoardVO freeBoardVO, Model model, HttpSession session) {
		
		//현재 로그인한 사용자의 아이디 가져오기
	    userVO currentUser = (userVO) session.getAttribute("currentUser");
	    freeBoardVO.setUserId(currentUser.getUserId());
		
	    //게시물 작성 메서드 호출
	    board_mapper.write_board(freeBoardVO);
	    
	    //작성 후 해당 카테고리의 게시물 목록 가져오기
	    List<freeBoardVO> list = board_mapper.search_board(freeBoardVO.getBoardCategory());
	    model.addAttribute("list",list);
	    System.out.println("성공");
	    return "board";
	}
	
	/**
	 * 게시물을 수정하고 DB에 업데이트, view 페이지로 반환됩니다.
	 * @param freeBoardVO 수정된 게시물의 데이터를 담은 객체
	 * @param model 수정된 게시물의 데이터를 담은 model
	 * @return viewBoard.jsp 뷰 페이지
	 */
	
	@RequestMapping(value = "/actionEdit", method = RequestMethod.POST)
	public String ActionEditBoard(freeBoardVO freeBoardVO, Model model) {
		
		//게시물 수정 메서드 호출
	    board_mapper.update_board(freeBoardVO);
	    System.out.println(freeBoardVO.getBoardID());
	    System.out.println(freeBoardVO.getTitle());
	    System.out.println(freeBoardVO.getBoardContent());
	    
	    //수정된 게시물의 상세 내용 가져오기
	    freeBoardVO view = board_mapper.view_board(freeBoardVO.getBoardID()); 
	    model.addAttribute("view",view);
	    System.out.println("수정성공");
	    return "viewBoard";
	}
	
	/**
	 * 게시물 수정 페이지로 이동합니다.
	 * @param boardID 수정할 게시물 번호
	 * @param model 수정할 게시물의 내용을 View에 담아 반환합니다.
	 * @return editBoard.jsp 수정페이지로 반환
	 */
	
	@RequestMapping(value = "/editBoard", method = RequestMethod.POST)
	public String editBoard(@RequestParam("boardID") int boardID, Model model) {
		//수정할 게시물의 상세 내용 가져오기
	    freeBoardVO view = board_mapper.view_board(boardID);
	    System.out.println(boardID);
	    model.addAttribute("view",view);	    
	    return "editBoard";
	}
	
	/**
	 * 게시물을 삭제하고 DB에서 제거하여 해당 카테고리의 게시판으로 이동합니다.
	 * @param model 삭제된 게시물의 카테고리에 해당하는 list 반환
	 * @param boardID 삭제 게시물 번호
	 * @param boardCategory 삭제 게시물의 카테고리
	 * @return board.jsp 반환 뷰 페이지
	 */
	
	@RequestMapping(value = "/deleteBoard", method= RequestMethod.POST)
	public String deleteBoard(Model model, @RequestParam("boardID") int boardID, @RequestParam("boardCategory") String boardCategory) {
		//게시물 삭제 메서드 호출
		board_mapper.delete_board(boardID);
		
		//삭제 후 해당 카테고리의 게시물 목록 가져오기
		List<freeBoardVO> list = board_mapper.search_board(boardCategory);
	    model.addAttribute("list",list);
	    model.addAttribute("boardCategory", boardCategory);
		return "board";
	}
	
	
	
}

