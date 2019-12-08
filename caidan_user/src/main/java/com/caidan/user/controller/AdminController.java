package com.caidan.user.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.caidan.result.AjaxResult;
import com.caidan.result.Constant;
import com.caidan.result.TableDataInfo;
import com.caidan.user.pojo.Admin;
import com.caidan.user.pojo.vo.AdminVO;
import com.caidan.user.pojo.vo.UserMenuVO;
import com.caidan.user.service.AdminService;
import com.caidan.user.service.UserService;
import com.caidan.util.JwtUtil;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminServie;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@RequestMapping("/add")
	@ResponseBody
	public AjaxResult<Admin> add(@RequestBody Admin admin) {
		return adminServie.add(admin);
	}
	@RequestMapping("/login")
	public AjaxResult<AdminVO> login(@RequestBody Admin admin){
		
		 Admin loginAdmin = adminServie.findAdmin(admin);
		 
		 if(loginAdmin != null) {
			 AdminVO adminVO = new AdminVO();
			 BeanUtils.copyProperties(loginAdmin, adminVO);
			 String createJWT = jwtUtil.createJWT(loginAdmin.getId(), loginAdmin.getLoginname(), "admin");
			 
			 adminVO.setToken(createJWT);
			 adminVO.setRoles("admin");
			 
			 return new AjaxResult<AdminVO>(Constant.OK, "登录成功！", adminVO);
		 }
		 
		 return new AjaxResult<AdminVO>(Constant.BAD_REQUEST, "用户名密码不正确！");
	}
	
	@GetMapping("/menus/{name}")
	public TableDataInfo<UserMenuVO> menus(@PathVariable("name") String userName){
		return adminServie.selectUserMenu(userName);
	}
}
