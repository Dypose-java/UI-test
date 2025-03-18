package api_and_ui.present_example_sushi_wok.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserSWReguest {
    public String phone,code;
}
