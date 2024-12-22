package selenide_file;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Configuration;
import com.codeborne.xlstest.XLS;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FilesParseTest {

    ClassLoader cl = FilesParseTest.class.getClassLoader();

    @BeforeAll
    static void setUP() {
        Configuration.browserSize = "1920x1980";
        Configuration.timeout = 5_000;

    }

    @Test
    void pdfParseTest() throws Exception {
        open("https://junit.org/junit5/docs/current/user-guide/");
        File pdfDownload = $$(".paragraph a").filter(text("PDF download")).first().download();
        PDF content = new PDF(pdfDownload);
        assertThat(content.author).contains("Sam Brannen");
        int i = 0;
    }

    @Test
    void xlsParseTest() throws Exception {
        XLS contents;
        try (InputStream resourceAsStream = cl.getResourceAsStream("xls/090303-UPITo-23_1_varianty.xlsx")) {
            contents = new XLS(resourceAsStream);
            assertThat(contents.excel.getSheetAt(0).getRow(12).getCell(1).getStringCellValue()).contains("Болонкин Даниил Георгиевич");
        }
        int i = 0;
    }

    @Test
    void csvParseTest() throws Exception {
        List<String[]> list52Csv;

        try (InputStream resourceAsStream = cl.getResourceAsStream("csv/52.csv");
             CSVReader reader = new CSVReader(new InputStreamReader(resourceAsStream))
        ) {
            list52Csv = reader.readAll();
            assertThat(list52Csv.get(0)).contains("dypose");
        }
        int i = 0;
    }

    @Test
    void zipParseTest() throws Exception {


        try (InputStream resourceAsStream = cl.getResourceAsStream("zip/WinRAR ZIP archive.zip");
             ZipInputStream zip = new ZipInputStream(resourceAsStream);
        ) {
            ZipEntry entry;
            while ((entry = zip.getNextEntry()) != null) {
                assertThat(entry.getName()).isNotEmpty();
            }
        }
        int i = 0;
    }

    @Test
    void jsonParseTest() throws Exception {
        Gson gson = new Gson();
        try (InputStream resource = cl.getResourceAsStream("json/glossary.json");
             InputStreamReader reader = new InputStreamReader(resource)
        ) {
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            assertThat(jsonObject.get("glossary").getAsJsonObject().get("title").getAsString()).isEqualTo("example glossary");
            assertThat(jsonObject.get("glossary").getAsJsonObject().get("flag").getAsBoolean()).isTrue();
        }
    }
    int i = 0;
}
