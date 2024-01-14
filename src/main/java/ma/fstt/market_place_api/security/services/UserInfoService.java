package ma.fstt.market_place_api.security.services;

import ma.fstt.market_place_api.security.entities.Role;
import ma.fstt.market_place_api.security.entities.UserInfo;
import ma.fstt.market_place_api.security.entities.UserInfoDetails;
import ma.fstt.market_place_api.security.repositories.RoleRepo;
import ma.fstt.market_place_api.security.repositories.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserInfoService implements UserDetailsService {

    private UserInfoRepo userInfoRepo;
    private RoleRepo roleRepo;
    private PasswordEncoder encoder;

    @Autowired
    public void setUserInfoRepo(UserInfoRepo userInfoRepo) {
        this.userInfoRepo = userInfoRepo;
    }

    @Autowired
    public void setRoleRepo(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Autowired
    public void setEncoder(PasswordEncoder encoder) {
        this.encoder = encoder;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userInfoRepo.findByName(username);
        if (userInfo.isEmpty()){
            throw new UsernameNotFoundException("User not found!");
        }
        return userInfo
                .map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }


    public String saveUser(UserInfo userInfo) {
        Optional<UserInfo> foundUser = userInfoRepo.findByNameOrEmail(userInfo.getName(), userInfo.getEmail());
        if (foundUser.isPresent()){
            throw new RuntimeException("User already exists!");
        }
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        userInfoRepo.save(userInfo);
        return "User Saved Successfully";
    }

    public List<UserInfo> findAllUsers() {
        return userInfoRepo.findAll();
    }

    public String addRoleToUser(String username, String roleName) {
        UserInfo userInfo = userInfoRepo.findByName(username).orElseThrow(() -> new RuntimeException("User not found"));
        Role role = roleRepo.findByRoleName(roleName).orElseThrow(() -> new RuntimeException("Role not found"));

        // Check if the user already has the role
        Optional<Role> filteredRole = userInfo.getRoles().stream().filter(r -> r.getRoleName().equals(roleName)).findFirst();
        if (filteredRole.isPresent()){
            throw new RuntimeException("User already has this role");
        }

        userInfo.getRoles().add(role);
        return "Role added to user successfully";
    }
}
