package ma.fstt.market_place_api.security.repositories;

import ma.fstt.market_place_api.security.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Integer> {

    Optional<Role> findByRoleName(String roleName);
}
