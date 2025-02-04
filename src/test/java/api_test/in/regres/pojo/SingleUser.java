package api_test.in.regres.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SingleUser {
    private Data data;
    private Support support;

    @lombok.Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data{
        private String id,email,first_name,last_name,avatar;
    }

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public static class Support{
private String url,text;
}

}


