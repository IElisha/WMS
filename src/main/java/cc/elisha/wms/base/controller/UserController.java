package cc.elisha.wms.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cc.elisha.wms.base.domain.User;
import cc.elisha.wms.base.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	/**
	 * 	保存或更新操作
	 * @param user
	 */
	@RequestMapping("/saveOrUpdate")
	public String saveOrUpdate(User user) {
		if (user.getId() == null) {
			this.userService.save(user);
		} else {
			this.userService.update(user);
		}
		return "redirect:/user/list";
	}

	/**
	 * 	删除操作
	 * @param id
	 */
	@RequestMapping("/delete")
	public String delete(Long id) {
		this.userService.delete(id);
		return "redirect:/user/list";
	}

	/**
	 * 	列表查询
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("users", this.userService.listAll());
		return "/user/list";
	}

	/**
	 * 	进入编辑页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/input")
	public String input(Long id, Model model) {
		if (id != null) {
			model.addAttribute("user", this.userService.get(id));
		}
		return "/user/input";
	}
}
