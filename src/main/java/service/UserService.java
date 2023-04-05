package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class UserService {
    private
    @GetMapping("/users")
    String index()
    {
        String sql = "SELECT * FROM Users";
        return sql;
    }
}
