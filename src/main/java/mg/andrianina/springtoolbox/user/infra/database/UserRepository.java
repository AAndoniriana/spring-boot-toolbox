package mg.andrianina.springtoolbox.user.infra.database;

import mg.andrianina.springtoolbox.user.infra.database.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findByEmailOrUsername(String email, String username);

    List<UserEntity> findByEmail(String email);

    List<UserEntity> findByUsername(String username);
}
