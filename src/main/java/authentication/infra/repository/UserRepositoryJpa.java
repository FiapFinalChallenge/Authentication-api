package authentication.infra.repository;

import authentication.domain.model.User;
import authentication.domain.repository.IUserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJpa extends JpaRepository<User, Long>, IUserRepository {
}
