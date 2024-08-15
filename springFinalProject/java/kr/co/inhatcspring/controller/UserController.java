package kr.co.inhatcspring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.inhatcspring.beans.freeBoardVO;
import kr.co.inhatcspring.beans.userVO;
import kr.co.inhatcspring.database.MapperInterface;

@Controller
public class UserController {
	
	@Autowired
	MapperInterface user_mapper;
	
	
	//회원가입 페이지 반환
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm(Model model) {
		//사용자 등록 폼 페이지를 반환합니다.
		model.addAttribute("user", new userVO());
		return "register";
	}
	
	
	//회원가입
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Model model, @ModelAttribute userVO user) {
		//사용자 등록 메서드 호출
	    user_mapper.register_user(user);  
	    //회원가입 후 홈페이지로 리다이렉트
	    return "redirect:/";
	}
	
	//로그인 페이지 반환
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(Model model) {
		//로그인 폼 페이지를 반환.
		model.addAttribute("user", new userVO());
		return "login";
	}
	
	//로그인
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, @ModelAttribute userVO user, HttpSession session) {
        //사용자의 아이디로 사용자 정보 조회
    	userVO saveUser = user_mapper.getUserById(user.getUserId());
        if (saveUser != null && saveUser.getPassword().equals(user.getPassword())) {
            //로그인 성공 시 세션에 사용자 정보 저장
            session.setAttribute("currentUser", saveUser);
            return "redirect:/";
        } else {
            //로그인 실패 시 로그인 페이지로 돌아감
            return "login";
        }
    }
    
    //로그아웃
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
    	//세션 무효화
    	session.invalidate();
    	//로그아웃 후 홈페이지로 리다이렉트
    	return "redirect:/";
    }
    
    //회원정보페이지 반환
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Model model, HttpSession session) {
        //로그인한 사용자 정보 가져오기
        userVO currentUser = (userVO) session.getAttribute("currentUser");
        if (currentUser != null) {
            //로그인한 사용자 정보를 Model에 추가
            model.addAttribute("user", currentUser);
        }
        return "profile";
    }
    
    //회원정보 수정 페이지 반환
    @RequestMapping(value = "/editprofile", method = RequestMethod.GET)
    public String editprofileform(Model model, HttpSession session) {
        //현재 로그인한 사용자 정보 가져오기
        userVO currentUser = (userVO) session.getAttribute("currentUser");
        
        //사용자 정보를 모델에 추가
        model.addAttribute("user", currentUser);
        
        return "editprofile";
    }
    
    //회원정보 수정
    @RequestMapping(value = "/editprofile", method = RequestMethod.POST)
    public String editprofile(@ModelAttribute("user") userVO user, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            //폼 데이터 유효성 검사에 실패한 경우
            return "editprofile";
        }

        //로그인한 사용자 정보 가져오기
        userVO currentUser = (userVO) session.getAttribute("currentUser");
        if (currentUser != null) {
            //로그인한 사용자의 정보를 폼에서 입력받은 데이터로 업데이트
            currentUser.setUserId(user.getUserId());
            currentUser.setPassword(user.getPassword());
            currentUser.setUserName(user.getUserName());

            //업데이트된 사용자 정보를 세션에 다시 저장
            session.setAttribute("currentUser", currentUser);
            
            //업데이트 된 사용자 정보를 세션에 다시 저장
            user_mapper.update_user(user);

            //프로필 수정 완료 후 프로필 페이지로 리다이렉트
            return "redirect:/profile";
        }

        //로그인한 사용자 정보가 없는 경우 메인으로 이동
        return "redirect:/";
    }
	
    
    //내가 쓴 게시글
    @RequestMapping(value = "/myboard", method = RequestMethod.GET)
    public String myboard(Model model, HttpSession session) {
        //세션에서 로그인한 사용자의 ID 가져오기
        String userId = ((userVO) session.getAttribute("currentUser")).getUserId();
        
        if (userId == null) {
            //세션에 currentUser가 없는 경우, 로그인 페이지로 리다이렉트
            return "redirect:/login";
        }
        
        //로그인한 사용자의 게시글 목록 조회
        List<freeBoardVO> myBoards = user_mapper.getMyBoards(userId);

        //조회된 게시글 목록을 모델에 추가
        model.addAttribute("myBoards", myBoards);
        return "myboard";
    }

    
}
