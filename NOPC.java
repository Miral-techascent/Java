import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class NOPC {

    WebDriver driver;
    public static void SelectFromDropdown(WebElement element,String value){
        Select select = new Select(element);
        select.selectByValue(value);

    }
    @Test(priority = 1)
    void openbrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test(priority = 2)
    void product(){
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/h2/a")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/h2/a")).click();
        driver.findElement(By.id("product_enteredQuantity_3")).clear();
        driver.findElement(By.id("product_enteredQuantity_3")).sendKeys("1");
        driver.findElement(By.id("add-to-cart-button-3")).click();
        driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]")).click();
    }

    @Test(priority = 3)
    void cart(){
        driver.findElement(By.className("qty-input")).clear();
        driver.findElement(By.className("qty-input")).sendKeys("3");
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")).click();
    }

    @Test(priority = 4)
    void billing(){
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Miral");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Patel");
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("patelmv.16993@gmail.com");
        driver.findElement(By.id("BillingNewAddress_Company")).sendKeys("Unify");

        WebElement Country = driver.findElement(By.id("BillingNewAddress_CountryId"));
        SelectFromDropdown(Country, "233");

        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Bath");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Flat 2,1 Lymore Avenue");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("BA21BA");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("07521298184");
        driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]")).click();
    }

    @Test(priority = 5)
    void shoppingmethod(){
         driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[3]/div[2]/form/div[2]/button")).click();
   }
   
    @Test(priority = 6)
    void card(){

        driver.findElement(By.id("CardholderName")).sendKeys("MVP");
        driver.findElement(By.id("CardNumber")).sendKeys("1234567891011121");

        WebElement Expire_Month = driver.findElement(By.id("ExpireMonth"));
        SelectFromDropdown(Expire_Month,"03");

        WebElement Expire_Year = driver.findElement(By.id("ExpireYear"));
        SelectFromDropdown(Expire_Year,"2025");

        driver.findElement(By.id("CardCode")).sendKeys("123");
        driver.findElement(By.id("//*[@id=\"payment-info-buttons-container\"]/button")).click();
   }
}
