package com.yjl.mapper.role;

import com.yjl.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
	
	public List<Role> getRoleList()throws Exception;

}
