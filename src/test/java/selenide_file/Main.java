package selenide_file;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.ex.FileNotDownloadedError;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Main  {
    @BeforeAll
    static void setUp(){
        Configuration.browserSize="1920x1980";
        Configuration.timeout=5000;
    }

    static void clearBrowserLocalStorageAndBrowserCookies(){
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
    /**
     *Эта конструкция нужна только для файлов без href(просто так нельзя писать его во всех тестах->из-за прокси тесты
     * не рабортают стабильно)
     */
    /*static {
        Configuration.fileDownload = FileDownloadMode.PROXY;
    }*/

    /**
     * скачка файла только если у кнопки есть href на скачку файла(иначе селенид из под капота не сможет скачать файл)
     * */
    @Test
    void selenideDownloadTest() throws Exception {
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        clearBrowserLocalStorageAndBrowserCookies();
        File download = $("[data-testid=raw-button]").download();//путь файла

        try (InputStream is = new FileInputStream(download)) {
            byte[] readContent = is.readAllBytes();
            String textContent = new String(readContent, StandardCharsets.UTF_8);
            assertThat(textContent).contains("This repository is the home of _JUnit 5_.");
        }
    }
    @Test
    void uploadFile(){
        Selenide.open("https://uploadnow.io/");
        $(".fc-footer-buttons button").click();
        $("input[type='file']").uploadFromClasspath("img/practiceForm.png");
        $(".cards_overlay_title__SKsjB").shouldHave(text("selected file ready to send"));
        int i = 0;
    }
}
