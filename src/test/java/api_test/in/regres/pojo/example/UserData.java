package api_test.in.regres.pojo.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)//для игнорирование полей которые нам не нужны
@Getter
public class UserData {
    private User data;
}
