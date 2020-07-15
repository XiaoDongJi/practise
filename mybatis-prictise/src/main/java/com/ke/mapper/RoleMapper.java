package com.ke.mapper;

import org.apache.ibatis.annotations.Select;

public interface RoleMapper {

    Role getRole(Long id);

    @Select(value = "select id,role_name as roleName,note from t_role where id = #{id}")
    Role getById();

    void insert(Role role);

}
