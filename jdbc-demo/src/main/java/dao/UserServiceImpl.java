package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by JDP on 2016/12/16.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name) {
        jdbcTemplate.update("insert ignore into user(name) values(?)", name);
    }

    @Override
    public Integer getUserCnt() {
        return jdbcTemplate.queryForObject("select count(*) from user", Integer.class);
    }
}
