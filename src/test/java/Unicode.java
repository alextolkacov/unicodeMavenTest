import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Unicode {
    BaseFunc baseFunc = new BaseFunc();
    private final String URL = "https://unicode-table.com/en/";
    private final By UNICODE = By.xpath(".//li[@class = 'symb']");
    List<String> sym = new ArrayList<String>();
    List<String> attr = new ArrayList<String>();

    @Test
    public void getUnicodeTest() throws InterruptedException, IOException {
        baseFunc.openPage(URL);
        baseFunc.threadSleep(5000);
        List<WebElement> symbols = baseFunc.getAllElements(UNICODE);
        HashMap<List<String>, List<String>> map = new HashMap<List<String>, List<String>>();

        for(WebElement we : symbols) {
            sym.add(we.getText());
        }

        for (WebElement we : symbols) {
            attr.add(we.getAttribute("title").toLowerCase().replaceAll("\\+", ""));
        }

        map.put(attr, sym);

        baseFunc.arrayToJsonFile("unicodeJSON", map);
    }
}
