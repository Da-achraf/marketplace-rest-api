package ma.fstt.market_place_api.security.request;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
