package dev.warriorg.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v100.network.Network;
import org.openqa.selenium.devtools.v100.network.model.RequestId;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author gao shiyong
 * @since 2022/5/11 10:43
 */
public class Application {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        Map<String, Object> map = new HashMap<>(2);
        map.put("source", "Object.defineProperty(navigator, 'webdriver', { get: () => undefined })");
        ((ChromeDriver) driver).executeCdpCommand("Page.addScriptToEvaluateOnNewDocument", map);
        driver.get("http://credit.customs.gov.cn/");
        devTools.addListener(Network.responseReceived(),responseReceived -> {
            RequestId requestId = responseReceived.getRequestId();
            Network.GetResponseBodyResponse response = devTools.send(Network.getResponseBody(requestId));
            String body = response.getBody();
            System.out.println("==============================");
            System.out.println(body);
        });

        Thread.currentThread().join();
    }
}
