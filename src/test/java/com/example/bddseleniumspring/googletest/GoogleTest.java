package com.example.bddseleniumspring.googletest;

import com.example.bddseleniumspring.SpringBaseTestNGTest;
import com.example.bddseleniumspring.page.google.GooglePage;
import com.example.bddseleniumspring.util.ScreenShotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class GoogleTest extends SpringBaseTestNGTest {

    @Autowired
    private GooglePage googlePage;

    @Lazy
    @Autowired
    private ScreenShotUtil screenShotUtil;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        this.googlePage.closeCookies();
        Assert.assertTrue(this.googlePage.isAt());

        this.googlePage.getSearchComponent().search("Environment ");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        this.screenShotUtil.takeScreenShot("googleTest_" + Instant.now().getEpochSecond() + ".png");
    }

}
