package selenide_file;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MyOpenzipTest {

    static ClassLoader cl = MyOpenzipTest.class.getClassLoader();

    @Test
     void selenideParseFilesFromZIP() throws Exception {
        try (InputStream resourceAsStream = cl.getResourceAsStream("zip/WinRAR ZIP archive.zip");
             ZipInputStream zip = new ZipInputStream(resourceAsStream);
        ) {
            ZipEntry entry;
            while ((entry = zip.getNextEntry()) != null) {
                if (entry.getName().endsWith(".csv")) {
                    CSVReader reader = new CSVReader(new InputStreamReader(zip));
                    List<String[]> list52Csv = reader.readAll();
                    assertThat(list52Csv.get(0)[0]).isEqualTo("Болонкин");

                }else if (entry.getName().endsWith(".xlsx")){
                    XLS xls = new XLS(zip);
                    assertThat(xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue()).contains("Dypose");
                }else{
                    PDF pdf = new PDF(zip);
                    assertThat(pdf.text).contains("Мужчина");
                }
            }

        }
    }

}








