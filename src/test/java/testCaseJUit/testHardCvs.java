package testCaseJUit;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class testHardCvs {
    @BeforeEach
    void openUrl(){
        Selenide.open("https://selenide.org/");
    }

    static Stream<Arguments> selenideSiteShouldContainsAllButtonsLocale(){
        return Stream.of(
                Arguments.of(Locale.RU,List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы")),
                Arguments.of(Locale.EN,List.of("Quick start","Docs","FAQ", "Blog" ,"Javadoc" ,"Users" ,"Quotes"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Для локали {0} отабражаются кнопки {1}")
    @Tag("BLOCKER")

    void selenideSiteShouldContainsAllButtonsLocale(Locale locale, List<String> buttons){
        $$("#languages a").find(text(locale.name())).click();
        $$(".main-menu-pages a")
                .filter(visible)
                .shouldHave(texts(buttons));
    }
}
