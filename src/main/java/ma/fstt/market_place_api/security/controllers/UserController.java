package ma.fstt.market_place_api.security.controllers;

import ma.fstt.market_place_api.security.entities.Role;
import ma.fstt.market_place_api.security.entities.UserInfo;
import ma.fstt.market_place_api.security.entities.UserInfoDetails;
import ma.fstt.market_place_api.security.request.AuthRequest;
import ma.fstt.market_place_api.security.request.RoleUserInput;
import ma.fstt.market_place_api.security.services.JwtService;
import ma.fstt.market_place_api.security.services.RoleService;
import ma.fstt.market_place_api.security.services.UserInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserInfoService userInfoService;
    private final RoleService roleService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public UserController(UserInfoService userInfoService, RoleService roleService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userInfoService = userInfoService;
        this.roleService = roleService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserInfo>> users() {
        List<UserInfo> users = new ArrayList<>(userInfoService.findAllUsers());
        return ResponseEntity.ok(users);
    }

    @PostMapping("/register")
    public ResponseEntity<String> addNewUser(@RequestBody UserInfo userInfo) {
        try{
            return ResponseEntity.ok(userInfoService.saveUser(userInfo));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    authRequest.getUsername(),
                                    authRequest.getPassword()
                            )
                    );

            if (authentication.isAuthenticated()) {
                UserInfoDetails usrInfoDetails = (UserInfoDetails) authentication.getPrincipal();
                return ResponseEntity.ok(jwtService.generateToken(authRequest.getUsername()));
            } else {
                throw new UsernameNotFoundException("invalid user request !");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/roles")
    public ResponseEntity<String> saveRole(@RequestBody Role role){
        try{
            String response = roleService.saveRole(role);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/add-role-to-user")
    public ResponseEntity<String> addRoleToUser(@RequestBody RoleUserInput roleUserInput){
        try{
            return ResponseEntity.ok(userInfoService.addRoleToUser(roleUserInput.getUsername(), roleUserInput.getRoleName()));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
