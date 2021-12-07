package org.kpu.myweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.kpu.myweb.domain.AccountVO;
import org.kpu.myweb.domain.SchedulVO;
import org.kpu.myweb.domain.UserVO;
import org.kpu.myweb.service.CalendarSerivce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/calendar")
public class pageController {
	
	@Autowired
	private CalendarSerivce calendarService;
	
	private static final Logger logger = LoggerFactory.getLogger(pageController.class);
	
	@RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String calendarGET(HttpSession session, Model model) throws Exception {
		try {
			UserVO vo = (UserVO)session.getAttribute("user");
			List<SchedulVO> list = calendarService.readAllSchedul(vo.getId());
			model.addAttribute("list",list);
			logger.info(" /calendar/home GET Schedul called.");
	        return "calendar/home";
		}catch(Exception e) {
			logger.info(" /calendar/home GET called.");
			return "calendar/home";
		}
    }
	
	@RequestMapping(value = {"/home"}, method = RequestMethod.POST)
    public String calendarPOST(Model model, HttpSession session) throws Exception {
		model.addAttribute("session", session);
		logger.info(" /calendar/home POST called.");
        return "redirect:/calendar/home";
    }
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public String registerGET() throws Exception {
		logger.info(" /calendar/register GET called.");
        return "calendar/register";
    }
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public String registerPOST(UserVO vo) throws Exception {
    	calendarService.createUser(vo);
		logger.info(" /calendar/register POST called.");
        return "redirect:/calendar/home";
    }
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String loginGET() throws Exception {
		logger.info(" /calendar/login GET called.");
        return "calendar/login";
    }
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String loginPOST(AccountVO vo, Model model, HttpSession session) throws Exception {
		logger.info(vo.toString());
		try {
			UserVO uvo = calendarService.readUser(vo);
			if(uvo == null) {
				model.addAttribute("msg","false");
				return "calendar/login";
			}else {
				session.setAttribute("user",uvo);
				model.addAttribute("msg", "true");
				logger.info(" /calendar/login POST called.");
		        return "redirect:/calendar/home";
			}
		}catch(Exception e) {
			model.addAttribute("msg","false");
			logger.info("login failed");
			return "calendar/login";
		}
    }
	
	@RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listGET(HttpSession session, Model model) throws Exception {
		UserVO vo = (UserVO)session.getAttribute("user");
    	model.addAttribute("user",vo);
		logger.info(" /calendar/list GET called.");
        return "calendar/list";
    }
	
	@RequestMapping(value = {"/list"}, method = RequestMethod.POST)
    public String listPOST(HttpSession session, Model model) throws Exception {
		UserVO vo = (UserVO)session.getAttribute("user");
    	model.addAttribute("user",vo);
		logger.info(" /calendar/list POST called.");
        return "redirect:/calendar/list";
    }
	
	@RequestMapping(value = {"/modify"}, method = RequestMethod.GET)
    public String modifyGET(HttpSession session, Model model) throws Exception {
		UserVO vo = (UserVO)session.getAttribute("user");
    	model.addAttribute("user",vo);
		logger.info(" /calendar/modify GET called.");
        return "calendar/modify";
    }
	
	@Transactional
	@RequestMapping(value = {"/modify"}, method = RequestMethod.POST)
    public String modifyPOST(HttpSession session, Model model, UserVO vo) throws Exception {
		try {
			calendarService.updateUser(vo);
			session.setAttribute("user", vo);
			logger.info(" /calendar/modify POST called.");
	        return "redirect:/calendar/home";
		}catch(Exception e) {
			logger.info("modify failed");
			return "/calendar/home";
		}
    }
	
	@RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String logoutGET(HttpSession session) throws Exception {
		session.invalidate();
		logger.info("/calendar/logout GET called");
		return "redirect:/calendar/home";
    }
	
	
	
	@RequestMapping(value = {"/delete"}, method = RequestMethod.GET)
    public String deleteGET(HttpSession session) throws Exception {
		UserVO vo = (UserVO)session.getAttribute("user");
		calendarService.deleteUser(vo);
		session.invalidate();
		logger.info("/calendar/delete GET called");
		return "redirect:/calendar/home";
    }
	
	@RequestMapping(value = {"/enter"}, method = RequestMethod.GET)
    public String enterGET(HttpSession session, Model model) throws Exception {
		if(session.getAttribute("user")==null)
			model.addAttribute("msg","false");
		logger.info("/calendar/enter GET called");
		return "calendar/enter";
    }
	
	@RequestMapping(value = {"/enter"}, method = RequestMethod.POST)
    public String enterPOST(HttpSession session, SchedulVO svo) throws Exception {
		try {
			if(svo.getEDate()==" " || svo.getSDate()==" " || svo.getContent()==" ") {
				svo.setEDate(null);
				svo.setSDate(null);
				svo.setContent(null);
			}
			UserVO vo= (UserVO)session.getAttribute("user");
			svo.setId(vo.getId());
			logger.info(svo.toString());
			calendarService.createSchedul(svo);
			logger.info("/calendar/enter POST called");
			return "redirect:/calendar/home";
		}catch(Exception e) {
			logger.info("create schedual failed");
			return "/calendar/home";
		}
    }
	
}
