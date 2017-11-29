package lh.action.shiro;

import lh.action.AbstractAction;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ShiroMemberAction extends AbstractAction {
	@RequestMapping("/admin/logoutUrl")
	@RequiresUser 
	public ModelAndView logoutUrl() {
		ModelAndView mav = new ModelAndView("back/back_forward") ;
		setMsgAndUrl("shiro.logout.msg", "front.index.action",mav);
		super.logout();
		return mav ;
	}
	@RequestMapping("/admin/successUrl") 
	public ModelAndView successUrl() {
		return new ModelAndView("back/index");
	}
	@RequestMapping("/loginUrl") 
	public ModelAndView loginUrl() {
		return new ModelAndView("login");
	}
	@RequestMapping("/unauthUrl")
	public ModelAndView unauthUrl() {
		return new ModelAndView("role");
	}

}
