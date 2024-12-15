package page_obj.web_tables;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page_obj.practice_form.MainSelenide;

import static com.codeborne.selenide.Selenide.sleep;

public class WebTablesTest extends MainSelenide {
    private final String url ="/webtables";
    @Test
    @DisplayName("Найти пользователя и нажать на редактирование")
    void test1(){
        String user ="Cierra";
        new WebTables().openUrl(url).editUser(user);
        sleep(5000);
    }
    @Test
    @DisplayName("Найти пользователя и нажать на кнопку удалить  и проверить удаление")
    void test2(){
        String user ="Cierra";
        new WebTables().openUrl(url).deliteUser(user).assertDelUser(user);
        //sleep(5000);
    }
}
