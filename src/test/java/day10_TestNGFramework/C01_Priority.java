package day10_TestNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_Priority {
     /*
        TestNG test method'larini calistirirken standart olarak harf siralamasina bakar
        Ancak TestNG siralamayi bizim kontrol etmemize olanak tanir

        istedigimiz test method'una istedigimiz onceligi priority ile tanimlayabiliriz
        Selenium test method'larini priority'si kucukten buyuge olacak sekilde calistirir

        priority degeri ayni olan test method'lari harf sirasina gore calisir

        priority degeri yazilmazsa default olarak priority=0 kabul edilir
     */

    @Test(priority = 20)
    public void youtubeTesti() {
        // youtube ana sayfaya gidip, youtube gittigimizi test edelim
        Driver.getDriver().get("https://www.youtube.com");

        //url youtube içeriyor mu
        String expectedIcerik="youtube";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.closeDriver();
    }

    @Test(priority = 50)
    public void amazonTesti(){
        // Amazon ana sayfaya gidip, amazona gittigimizi test edelim
        Driver.getDriver().get("https://www.amazon.com");

        //url amazon içeriyor mu
        String expectedIcerik="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.closeDriver();
    }

    @Test(priority = 30)
    public void wiseTesti(){
        // wisequarter ana sayfaya gidip, wisequarter'a gittigimizi test edelim
        Driver.getDriver().get("https://www.wisequarter.com");

        //url wisequarter içeriyor mu
        String expectedIcerik="wisequarter";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.closeDriver();

    }




}
