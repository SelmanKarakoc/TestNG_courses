package day13_crossBrowserTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {


    /*
        Verilen 4 farkli websitesine gidin
        o sayfaya gidildigini test edin
        sayfayi kapatin

        amazonUrl
        wiseUrl
        qdUrl
        youtubeUrl
     */

    @DataProvider
    public static Object[][] urlList() {

        String[][] siteList={{"amazonUrl"},{"wiseUrl"},{"qdUrl"},{"youtubeUrl"}};

        return siteList;
    }

    @Test(dataProvider = "urlList")
    public void urlTest(String gidilecekSite){

        Driver.getDriver().get(ConfigReader.getProperty(gidilecekSite));

        String actualUrl=Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,ConfigReader.getProperty(gidilecekSite)+"/");

        Driver.closeDriver();
    }




}
