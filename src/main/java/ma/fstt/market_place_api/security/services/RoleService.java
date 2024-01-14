package ma.fstt.market_place_api.security.services;

import ma.fstt.market_place_api.security.entities.Role;
import ma.fstt.market_place_api.security.repositories.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
public class RoleService {

    private RoleRepo roleRepo;

    @Autowired
    public void setRoleRepo(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public String saveRole(Role role) {
        Optional<Role> foundRole =  roleRepo.findByRoleName(role.getRoleName());
        if (foundRole.isPresent()){
            throw new RuntimeException("Role already exists");
        }
        roleRepo.save(role);
        return "Role Saved Successfully";
    }
}
