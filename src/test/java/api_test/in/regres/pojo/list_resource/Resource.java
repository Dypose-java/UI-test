package api_test.in.regres.pojo.list_resource;

import api_test.in.regres.pojo.SingleUser;
import api_test.in.regres.pojo.list_users.ListUsers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resource  extends SingleUser.Support {

    private Integer page,per_page,total,total_pages;
    private Data data;
    private  SingleUser.Support support;

    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Data{
        private String id,name,year,color,pantone_value;
    }
}
class testClass{

    public static void main(String[] args) {
        Resource resource = new Resource();
    }
}

