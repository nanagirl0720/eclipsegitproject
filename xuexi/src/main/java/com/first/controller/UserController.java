package com.first.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.first.bean.User;
import com.first.service.UserService;
import com.first.util.BlogRepository;

import net.bytebuddy.TypeCache.Sort;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private BlogRepository blogRepository;
	/**
	 * 查询所有用户信息：
	 * 一个URL访问到业务层，查询到数据后，展示到前台
	 * */
	@RequestMapping("/get")
	public String selectAllUserTable(Model model){
		List<User> userList=userService.selectAllUser();
		model.addAttribute("list", userList);
		return "showuser";
	}
	
	/**
	 * 添加用户：
	 * 首先存在方法：一个跳转页面，使之跳转到添加页面
	 * 第二新增一个添加页面HTML：前台action方法
	 * 第三编写后台action方法
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
	
	/**
	 * 更新用户：
	 * ①将要更新的用户查询出来
	 * ②更新
	 * ③显示结果
	 */
	@RequestMapping("/findUserById")
	public String findUserById(Integer id,Model model,User user) {
		User u=userService.selectById(id);
		model.addAttribute("user",u);
		return "edituser";
	}
	
	@RequestMapping("/updateuser")
	public String editOk(@Valid User user,BindingResult result) {
		if(result.hasErrors()) {
			return "adduser";
		}
		this.userService.updateUserById(user);;
		return "redirect:/user/get";
	}
		
	/**
	 * 删除用户
	 */
	@RequestMapping("/deleteById")
	public String deleteUserById(Integer id) {
		userService.deleteUserById(id);
		return "redirect:/user/get";
	}
	/**
	 * 添加用户跳转到添加页面
	 * @param user
	 * @return
	 */
	@RequestMapping("/adduser")
	public String adduser(User user) {
		return "adduser";
	}
	/**
	 * 添加用户
	 * @Valid 开启对user的数据校验，找到user实体类，配合对象的属性校验
	 */
	@RequestMapping("/add")
	public String insertUser(@Valid User user,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "adduser";
		}
		userService.insertUser(user);
		model.addAttribute("user",user);
		return "redirect:/user/get";
	}
	
	/*@RequestMapping("/show")
	public String demoThymeleaf(Model model) {
		model.addAttribute("msg", "Thymeleaf是一个HTML视图渲染技术!");
		model.addAttribute("key", new Date());
		model.addAttribute("sex", "女");
		model.addAttribute("id", "3");
		return "index";
	}*/
	@RequestMapping("/qj_error")	//	自定义异常页面内容error.html
	public String erronZdy() {
/*		String str=null;
		str.length();*/
		int a=2;
		a=a/0;
		return "index";
	}
	
	/**
	 * page，第几页，从0开始，默认为第0页
	 * size，每一页的大小，默认为20
	 * sort，排序相关的信息，以property,property(,ASC|DESC)的方式组织，
	 * 例如sort=firstname&sort=lastname,desc表示在按firstname
	 * 正序排列基础上按lastname倒序排列
	 * @param pageable
	 * @return
	 */
	@RequestMapping(value = "", method=RequestMethod.GET)
	public Page<User> getEntryByPageable(@PageableDefault(value = 15, sort = { "id" }) 
	    Pageable pageable) {
	    return blogRepository.findAll(pageable);
	}
}
