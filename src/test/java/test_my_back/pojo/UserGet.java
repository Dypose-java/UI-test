package test_my_back.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserGet {
   private Data data;
   private Support support;
   @lombok.Data
   @NoArgsConstructor
   @AllArgsConstructor
public static class Data{
   private String id,login,password;
}
   @lombok.Data
   @NoArgsConstructor
   @AllArgsConstructor
public static class Support{
   private String url,message;
}

}
