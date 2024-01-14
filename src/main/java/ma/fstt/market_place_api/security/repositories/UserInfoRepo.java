package ma.fstt.market_place_api.security.repositories;

import ma.fstt.market_place_api.security.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo, Integer> {

    Optional<UserInfo> findByName(String username);

    Optional<UserInfo> findByNameOrEmail(String name, String email);
}
