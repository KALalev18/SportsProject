package repository;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByFirstName(String firstName);
    User findByLastName(String lastName);
    User findByEmail(String email);
    boolean emailExists(String email);

    void update(String firstName, String lastName, String email, String password, int roleId, int userId);

    Optional<Object> findByRoleId(int id);

    void update(String roleName, int roleId);
}
