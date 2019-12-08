package com.caidan.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.caidan.result.AjaxResult;
import com.caidan.result.Constant;
import com.caidan.result.TableDataInfo;
import com.caidan.user.dao.AdminDao;
import com.caidan.user.dao.MenuDao;
import com.caidan.user.pojo.Admin;
import com.caidan.user.pojo.vo.UserMenuVO;
import com.caidan.util.IdWorker;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	@Autowired
	private IdWorker idWorker;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private MenuDao menuDao;
	
	
	public AjaxResult<Admin> add(Admin admin) {
		String roles = String.valueOf(request.getAttribute("claims_amdin"));
		if(roles == null || !"admin".equals(roles)) {
			return new AjaxResult<Admin>(Constant.BAD_REQUEST, "权限不足！", null);
		}
		admin.setId(idWorker.nextId()+"");
		admin.setPassword(encoder.encode(admin.getPassword()));
		Admin save = adminDao.save(admin);
		if(save != null) {
			return new AjaxResult<Admin>(Constant.OK, "用户添加成功！", null);
		}
		return new AjaxResult<Admin>(Constant.BAD_REQUEST, "用户添加失败！", null);
	}


	public Admin findAdmin(Admin admin) {
		Admin loginUser =  adminDao.getByLoginname(admin.getLoginname());
		if(loginUser != null && encoder.matches(admin.getPassword(), loginUser.getPassword())) {
			return loginUser;
		}
		return null;
	}
	
	public TableDataInfo<UserMenuVO> selectUserMenu(String userName){
		List<UserMenuVO> dataList = menuDao.selectUserMenu(userName);
		return new TableDataInfo<UserMenuVO>(dataList, dataList != null ? dataList.size() : 0);
	}
}
