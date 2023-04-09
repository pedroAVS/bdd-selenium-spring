package com.example.bddseleniumspring.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

import java.net.URL;

@Lazy
@Configuration
@Profile("remote")
public class RemoteWebDriverConfig {

    @Value("${default.timeout:30}")
    private int timeout;

    @Value("${selenium.grid.url}")
    private URL url;

    @Bean
    @ConditionalOnProperty(name= "browser", havingValue = "firefox")
    public WebDriver remoteFirefoxDriver(){
        return new RemoteWebDriver(this.url, DesiredCapabilities.firefox());
    }

    @Bean
    @ConditionalOnMissingBean
    public WebDriver remoteChromeDriver(){
        return new RemoteWebDriver(this.url, DesiredCapabilities.chrome());
    }

    @Bean
    public WebDriverWait webDriverWait(WebDriver driver){
        return new WebDriverWait(driver, this.timeout);
    }
}
