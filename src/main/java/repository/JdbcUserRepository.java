package repository;

import model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public abstract class JdbcUserRepository implements UserRepository{
    private JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findAll() {
        return jdbcTemplate.query(
                "SELECT userId, firstName, lastName, email, password, isAdmin FROM Users",
                (rs, rowNum) -> new User(
                        rs.getInt("userId"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getBoolean("isAdmin")

                )
        );
    }
}
