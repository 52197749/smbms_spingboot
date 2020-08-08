package com.yjl.service.role;

import com.yjl.mapper.role.RoleMapper;
import com.yjl.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Hunter on 2020-05-25.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getRoleList() throws Exception {
        List<Role> roleList = roleMapper.getRoleList();
        return roleList;
    }
}
