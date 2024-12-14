package my_test;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CssCelector {
  @Test
    void test(){
      open("https://alfabank.ru/");
      $(byText("Войти")).click();
      int i = 0;
  }
}
