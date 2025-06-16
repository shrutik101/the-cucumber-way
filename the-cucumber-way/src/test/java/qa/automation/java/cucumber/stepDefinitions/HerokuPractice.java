package qa.automation.java.cucumber.stepDefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HerokuPractice {

    public static void main(String[] args){
        HerokuPractice practice = new HerokuPractice();

        // Chrome driver setup
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Invoke the method for performing operations
//        practice.rightClick(driver);

//        practice.dragAndDrop(driver);]

//        practice.dropDown(driver);

//        practice.dynamicContent(driver);

//        practice.dynamicControl(driver);

//        practice.modelWindow(driver);

//        practice.downloadFile(driver);

//            practice.uploadFile(driver);
//            practice.guru99(driver);
//            practice.getValue(driver);
            practice.guru99DeleteCustomer(driver);
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            // Quit browser
            driver.quit();
        }
    }

    public void guru99(WebDriver driver) throws IOException {
        driver.get("https://demo.guru99.com/test/web-table-element.php");
        String dateAndTime = driver.findElement(By.xpath("//span[contains(text(),'Last updated:')]")).getText();
        String[] comp = dateAndTime.split(" ");
        Integer date = Integer.parseInt(comp[2]);
        String month = comp[3].replace(",","");
        System.out.println("Date: "+date+"\n"+"Month: "+month);
        String value = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[7]/td[4]")).getText();
        System.out.println(value);
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File image = screenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File("C:\\Users\\admin\\Desktop\\screenshot.png");
        FileUtils.copyFile(image,destination);
    }

    public void guru99DeleteCustomer(WebDriver driver) throws InterruptedException {
        driver.get("https://demo.guru99.com/test/delete_customer.php");
        driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }

    public void getValue(WebDriver driver) throws InterruptedException {
        driver.get("https://demo.guru99.com/test/web-table-element.php");
        Integer numberOfCompaniesDisplayed = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr")).size();
        for(int i=1; i<=numberOfCompaniesDisplayed; i++){
            String companyName = driver.findElement(By.xpath("(//a[@href='http://demo.guru99.com/'])["+i+"]")).getText();
            if("Corporation Bank".equalsIgnoreCase(companyName)){
                String value = driver.findElement(By.xpath("((//a[@href='http://demo.guru99.com/'])["+i+"]/parent::td/following-sibling::td)[3]")).getText();
                System.out.println("value for "+companyName+" is: "+value);
                Thread.sleep(5000);
            }
        }
    }






    public void rightClick(WebDriver driver) {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement box = driver.findElement(By.cssSelector("#hot-spot"));
        new Actions(driver).contextClick(box).perform();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    private void dragAndDrop(WebDriver driver) throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement a = driver.findElement(By.cssSelector("#column-a"));
        WebElement b = driver.findElement(By.cssSelector("#column-b"));

        new Actions(driver).dragAndDrop(a, b).perform();
        Thread.sleep(2000);

        new Actions(driver).dragAndDrop(b, a).perform();
        Thread.sleep(2000);
    }

    private void dropDown(WebDriver driver) {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropDown = driver.findElement(By.cssSelector("#dropdown"));
        Select select = new Select(dropDown);

        List<WebElement> options = select.getOptions();

        for(WebElement option : options){
            System.out.println(option.getText());
            if(option.isEnabled()){
                option.click();
                System.out.println(option.isSelected());
            }
        }

        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
    }

    private void dynamicContent(WebDriver driver) {
        driver.get("https://the-internet.herokuapp.com/dynamic_content");
        List<WebElement> contentDiv = driver.findElements(By.xpath("//div[@id='content' and @class='large-10 columns large-centered']//child::div[@class='row']"));
        System.out.println("List count: "+contentDiv.size());

        List<WebElement> texts = driver.findElements(By.xpath("//div[@id='content' and @class='large-10 columns large-centered']//child::div[@class='row']//child::div[2]"));
        int slNo = 1;
        for(WebElement text : texts){
            System.out.println(slNo++ +". "+text.getText());
        }
    }

    private void dynamicControl(WebDriver driver) {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//form[@id='input-example']//child::button[@autocomplete='off']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#message")));
    }

    private void modelWindow(WebDriver driver) throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/entry_ad");

        Thread.sleep(2000);

        driver.switchTo().activeElement();

        System.out.println(driver.findElement(By.xpath("//div[@class='modal-title']//h3")).getText());
    }

    private void downloadFile(WebDriver driver) throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[@href='download/file-upload.txt']")).click();
        Thread.sleep(2000);
    }

    // To be fixed
    private void uploadFile(WebDriver driver) throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        Thread.sleep(2000);

        WebElement uploadElement = driver.findElement(By.xpath("//input[@id='file-upload']"));

        uploadElement.sendKeys();

        // Send the file path to the file input element
        uploadElement.sendKeys("C:\\Users\\admin\\Downloads\\simple.txt");

        driver.findElement(By.xpath("//input[@class='button']")).click();

        Thread.sleep(1000);
    }

    private void dropDown1(WebDriver driver) {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropDown = driver.findElement(By.cssSelector("#dropdown"));
        Select select = new Select(dropDown);

        List<WebElement> options = select.getOptions();
        for(WebElement option: options){
            if(option.isSelected()){
                System.out.println(option);
            }
        }

    }
}
