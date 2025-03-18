package api_and_ui.present_example_sushi_wok.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSWResponse {
    public User user;
    public Addresses addresses;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    static class User{
        private String id,name,phone,email,birth_day,sex,sms_subscription,email_subscription,
                email_confirmed,phone_confirmed,vk_id,fb_id,ok_id,tw_id,has_franchise,phone_subscription,order_count;
        List<Object> favorites;
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    static class Addresses{
       private Integer id,user_id;
       private String latitude,longitude,address,city,street,house,building,entrance,apartment;
       private Integer floor;
       private String title,used_at;
    }

}
class tersdad{
    public static void main(String[] args) {
        UserSWResponse.User sdad = new UserSWResponse.User();
    }
}
