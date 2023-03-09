package day13_crossBrowserTests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_DataProviderNegatifLoginTest {
     /*
        Verilen 5 farkli username ve password'u kullanarak
        qualitydemy uygulamasina girilemedigini test edin
     */


    @DataProvider
    public static Object[][] kullanicilar() {

        String[][] kullaniciList={{"Selman","12345"},
                        {"Mehmet","34567"},
                        {"Sevilay","67890"},
                        {"Enver","56789"},
                        {"Ahmet Emre","54321"}};

        return kullaniciList;
    }



    @Test(dataProvider = "kullanicilar")
    public void negatifLoginTest(String username,String password){
        QdPage qdPage=new QdPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        qdPage.ilkLoginLinki.click();
        qdPage.emailKutusu.sendKeys(username);
        qdPage.passwordKutusu.sendKeys(password);

        qdPage.loginButonu.click();

        Assert.assertTrue(qdPage.emailKutusu.isEnabled());


        Driver.closeDriver();



    }




}
