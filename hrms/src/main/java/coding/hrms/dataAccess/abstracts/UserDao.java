package coding.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import coding.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
    User getByEmail(String email);
}
