package api_test.in.regres.pojo.Auth;

import java.util.Objects;

public class ResponseUser{
    private String id,token;

    public ResponseUser(String id, String token) {
        this.id = id;
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

}
