package repository;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByFirstName(String firstName);
    public User findByLastName(String lastName);
    public User findByEmail(String email);
    public boolean emailExists(String email);
    @Query("UPDATE Users " +
            "SET FirstName=:firstName, " +
            "LastName=:lastName, " +
            "Email=:email, " +
            "Password=:password, " +
            "RoleId=:roleId " +
            "WHERE UserId=:userId", nativeQuery = true)
    void update(String firstName, String lastName, String email, String password, int roleId, int userId);

    Optional<Object> findByRoleId(int id);

    void update(String roleName, int roleId);
}
