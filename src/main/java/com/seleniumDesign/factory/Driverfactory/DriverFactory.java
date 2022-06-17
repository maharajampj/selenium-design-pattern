package com.seleniumDesign.factory.Driverfactory;

import com.seleniumDesign.factory.Driverfactory.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {
    private static final Map<BrowserType, Supplier<WebDriver>> driverMap=new HashMap<>();

    private static final Supplier<WebDriver> chromeDriverSupplier=()->{
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
                options.addArguments("--headless");
                return new ChromeDriver(options);
    };

    private static final Supplier<WebDriver> firefoxDriverSupplier=()->{
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    };



    static {
        driverMap.put(BrowserType.CHROME,chromeDriverSupplier);
        driverMap.put(BrowserType.FIREFOX,firefoxDriverSupplier);
    }

    public static WebDriver getDriver(BrowserType type)
    {
        return driverMap.get(type).get();
    }

}
