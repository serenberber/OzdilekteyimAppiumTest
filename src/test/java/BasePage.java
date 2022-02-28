import com.thoughtworks.gauge.Logger;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
//import org.apache.log4j.Logger;
//import org.apache.log4j.LogManager;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage extends BaseTest{
    //final static Logger  logger = Logger.getLogger(BasePage.class.getName());
    @Step("<wait> saniye kadar bekle")
    public void waitForSeconds(int wait) throws InterruptedException {
        Thread.sleep(wait*1000);
    }

    @Step("id<id> li elemente tıkla")
    public void clickByid(String id){
        appiumDriver.findElement(By.id(id)).click();
        System.out.println(id + "elementine tıklandı");
       // Logger.info("");
    }
    @Step("xpath'i <elxpath> e tıkla")
    public void clickByIndex(String elxpath){
        String text = appiumDriver.findElement(By.xpath(elxpath)).getText();
       // appiumDriver.findElement(By.cssSelector(elxpath)).click();
        appiumDriver.findElement(By.xpath(elxpath)).click();
    }
    @Step("ekranı kaydır")
    public void Scroll()  throws InterruptedException{
      /*  String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Pantolon\").instance(0))";

        appiumDriver.findElement(scrollElement).click();*/

            Dimension dimension = appiumDriver.manage().window().getSize();
            int start_x = (int) (dimension.width * 0.6);
            int start_y = (int) (dimension.height * 0.6);

            int end_x = (int) (dimension.width * 0.4);
            int end_y = (int) (dimension.height * 0.4);

            TouchAction touch = new TouchAction(appiumDriver);
            touch.press(PointOption.point(start_x, start_y))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(end_x, end_y)).release().perform();
    }
    @Step("iki kere scroll yap")
    public void Scrooll()  throws InterruptedException {

            Dimension dimension = appiumDriver.manage().window().getSize();
            int start_x = (int) (dimension.width * 0.9);
            int start_y = (int) (dimension.height * 0.9);

            int end_x = (int) (dimension.width * 0.1);
            int end_y = (int) (dimension.height * 0.1);

            TouchAction touch = new TouchAction(appiumDriver);
            touch.press(PointOption.point(start_x, start_y))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(end_x, end_y)).release().perform();


    }
    @Step("Random bir ürün seç")
    public void rand(){
        Random rnd= new Random();
        List<MobileElement> pd = appiumDriver.findElements(By.xpath("//*[@resource-id = 'com.ozdilek.ozdilekteyim:id/imageView']"));
        System.out.println("pd"  +pd);
        MobileElement element =  pd.get(rnd.nextInt(pd.size()));
        System.out.println("element"  +element);
        element.click();
    }
    @Step("ürün favorilere ekle")
    public void Favori(){
        System.out.println("Favorileme butonuna tıklandı");
        appiumDriver.findElement(By.xpath("//*[@resource-id='com.ozdilek.ozdilekteyim:id/imgFav']")).click();
    }
    @Step("kullanıcı girişi")
    public void Kullanicigirisi() throws InterruptedException {
        Thread.sleep(3000);
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/etEposta")).sendKeys("serenberber@gmail.com");
    }
    @Step("Sifre girişi")
    public void Sifregirisi() throws InterruptedException {
        Thread.sleep(3000);
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/etPassword")).sendKeys("1234");
    }
    @Step("geri butonuna bas")
    public void Geributonu(){
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/ivBack")).click();
    }
    @Step("Uygulamanın açıldığı kontrol edilir")
    public void Uygulamakontrol(){
        String uygulamakont = appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/textView")).getText();
        System.out.println(uygulamakont);
        Assertions.assertEquals("Mağazadan Alışveriş",uygulamakont );
        Logger.info("Uygulamanın açıldığı Kontrol edildi");
    }

    @Step("kategori kontrol")
    public void kategorikontrol(){
        String kategoritext=appiumDriver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc='Kategoriler']/android.widget.TextView")).getText();
        System.out.println(kategoritext);
        Assertions.assertEquals("Kategoriler",kategoritext);
        Logger.info("Kategoriler sayfasinin acildigi kontrol edilir.");

    }

}
