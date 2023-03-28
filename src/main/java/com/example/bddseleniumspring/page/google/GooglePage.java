package com.example.bddseleniumspring.page.google;

import com.example.bddseleniumspring.page.Base;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GooglePage  extends Base {

    @Value("${application.url}")
    private String url;

    @Autowired
    private SearchComponent searchComponent;

    @Autowired
    private SearchResult searchResult;

    public void goTo(){
        this.driver.get(url);
    }

    public void closeCookies() {
        this.driver.findElement(By.xpath("//div[text()='Aceitar tudo']")).click();
    }
    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public SearchResult getSearchResult() {
        return searchResult;
    }

    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }
}
