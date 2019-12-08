package com.caidan.user.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.caidan.user.pojo.Admin;
@Repository
public interface AdminDao extends JpaRepository<Admin, String>{


	@Query(value = "select a from Admin a where a.loginname = ?1")
	public Admin getByLoginname(String loginname);
	
}
