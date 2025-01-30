package api_test.in.regres.pojo.list_users;

import org.junit.jupiter.api.Disabled;

@Disabled("Нужно переписать")
public class ListUsers {
     String page, per_page, total, total_pages;
     Data data;
     Support support;

    public ListUsers() {
    }

    public ListUsers(String page, String per_page, String total, String total_pages, Data data) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ListUsers{" +
                "page='" + page + '\'' +
                ", per_page='" + per_page + '\'' +
                ", total='" + total + '\'' +
                ", total_pages='" + total_pages + '\'' +
                ", data=" + data +
                ", support=" + support +
                '}';
    }

    public  static class Data {
        public String id;
        public String email, first_name, last_name, avatar;
    }

    public static class Support {
        public String url, text;
    }
}


