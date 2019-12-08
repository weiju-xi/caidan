package com.caidan.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.caidan.user.pojo.vo.UserMenuVO;
@Repository
public interface MenuDao {

	List<UserMenuVO> selectUserMenu(String userName);
}
