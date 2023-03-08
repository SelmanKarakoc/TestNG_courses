package day12_xmlFiles;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_RaporluPozitifLoginTesti extends TestBaseRapor {
    @Test
    public void pozitifLoginTesti(){
        extentTest=extentReports.createTest("Pozitif login test","geçerli bilgilerle giris yapılabilmeli");
        // qd anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        extentTest.info("anasayfaya gidildi");
        //cookies i kabul edin
        QdPage qdPage=new QdPage();
        qdPage.cookiesKabul.click();

        // login linkine tiklayin
        qdPage.ilkLoginLinki.click();
        extentTest.info("ilk login e tıklandı");


        // gecersiz kullanici adi ve password ile giris yapin
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        extentTest.info("geçerli email ve password yazıldı");
        qdPage.loginButonu.click();


        // basarili bir sekilde giris yapildigini test edin
        Assert.assertTrue(qdPage.basariliGirisElementi.isDisplayed());
        extentTest.pass("başarılı şekilde giriş yapıldı test edildi");








    }
}
