package api_and_ui.present_example_sushi_wok.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class User {
    private Integer id;
    private String name;
    private String phone;
    private String email;
    private Object birth_day;
    private Object sex;
    private Boolean sms_subscription;
    private Boolean email_subscription;
    private Object email_confirmed;
    private String phone_confirmed;
    private Object vk_id;
    private Object fb_id;
    private Object ok_id;
    private Object tw_id;
    private Boolean has_franchise;
    private Boolean phone_subscription;
    private Integer order_count;

    @Data
    @NoArgsConstructor
    public static class Addresses {
        private Integer id;
        private Integer user_id;
        private String latitude;
        private String longitude;
        private String address;
        private String city;
        private String street;
        private String house;
        private String building;
        private String entrance;
        private String apartment;
        private Integer floor;
        private Object title;
        private String used_at;
    }
}
