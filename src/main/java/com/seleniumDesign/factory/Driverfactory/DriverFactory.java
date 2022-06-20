package com.seleniumDesign.factory.Driverfactory;

import com.seleniumDesign.factory.Driverfactory.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import sun.security.krb5.internal.crypto.Des;

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

    private static final  Supplier<WebDriver> remoteDriverSupplier =()->
    {
        String host="localhost";
        DesiredCapabilities cp;
        WebDriver remoteWebDriver = null;
        if(System.getProperty("BROWSER")!=null&&System.getProperty("BROWSER").equalsIgnoreCase("firefox"))
        {
            cp=DesiredCapabilities.firefox();
        }
        else {
            cp= DesiredCapabilities.chrome();
        }
        if(System.getProperty("HUB_HOST")!=null)
        {
            host=System.getProperty("HUB_HOST");
        }
        String completeUrl="http://"+host+":4444/wd/hub";
        try {
            remoteWebDriver = new RemoteWebDriver(new URL(completeUrl),cp);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return remoteWebDriver;
    };

    static {
        driverMap.put(BrowserType.CHROME,chromeDriverSupplier);
        driverMap.put(BrowserType.FIREFOX,firefoxDriverSupplier);
        driverMap.put(BrowserType.REMOTE,remoteDriverSupplier);
    }

    public static WebDriver getDriver(BrowserType type)
    {
        return driverMap.get(type).get();
    }

}
