package api_and_ui.present_example_sushi_wok.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Addr {
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
