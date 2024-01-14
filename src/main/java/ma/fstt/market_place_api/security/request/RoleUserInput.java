package ma.fstt.market_place_api.security.request;

import lombok.Data;

@Data
public class RoleUserInput {

    private String username;
    private String roleName;
}
