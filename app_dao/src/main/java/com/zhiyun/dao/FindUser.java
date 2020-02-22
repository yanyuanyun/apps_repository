package com.zhiyun.dao;

import com.zhiyun.domian.User;
import com.zhiyun.util.JDBCUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class FindUser {
    public static User find(User user){
        JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDs());
        User user1 = null;
        try {
            String sql = "select * from user where username = ? and password = ?";
            user1 = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUsername(), user.getPassword());
//            return user1;
        } catch (DataAccessException e) {
//            e.printStackTrace();
        }
        return user1;
    }
}
