package aircanada.automation.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import aircanada.automation.hooks.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Flights {
    WebDriver driver = Hooks.getDriver();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("I open the Air Canada flights search page")
    public void i_open_the_air_canada_flights_search_page(){
        driver.get("https://www.aircanada.com/home/ca/en/aco/flights");
        WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='dynamic-name']")));
    }

    @Then("The page title should contain {string}")
    public void the_page_title_should_contain(String str){
        Assert.assertTrue(driver.getTitle().contains(str));
    }

    @When("I enter the departure city {string} and destination city {string}")
    public void i_enter_the_departure_city_and_destination_city(String source, String destination) throws InterruptedException {
        // Not selecting source as its Toronto by default
//        driver.findElement(By.xpath("//p[@class='dynamic-name']")).click();
//        driver.findElement(By.id("flightsOriginLocation")).sendKeys(source);
//
        // For finding all elements in the dropdown
//        List<WebElement> webElements = driver.findElements(By.cssSelector(".location-airport-name"));
//        for(WebElement element : webElements){
//            System.out.println(element.getText());
//        }
//
//        // Since the YYZ is first option clicking on it directly
//        driver.findElement(By.xpath("//li[@id='flightsOriginLocationSearchResult1']")).click();

        driver.findElement(By.id("flightsOriginDestinationbkmgLocationContainer")).click();
        driver.findElement(By.id("flightsOriginDestination")).sendKeys(destination);

        // Was not needed since send keys selected the destination needed
//        WebElement destinationOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("flightsOriginDestinationSearchResult0")));
//        destinationOption.click();
//        driver.findElement(By.id("flightsOriginDestinationSearchResult0")).click();
    }
    @When("I select the departure date as {string} and return date as {string}")
    public void i_select_the_departure_date_and_return_date(String fromDate, String toDate) throws InterruptedException {
        driver.findElement(By.id("bkmg-desktop_travelDates-formfield-1")).sendKeys(fromDate);
        driver.findElement(By.id("bkmg-desktop_travelDates-formfield-2")).sendKeys(toDate);
    }

    @When("I click the {string} button")
    public void i_click_the_button(String buttonName) throws InterruptedException {
        driver.findElement(By.id("bkmg-desktop_findButton")).click();

        WebElement resultsPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()=' Departing flight ']")));
        System.out.println(resultsPage.getText());
    }

    @Then("I should see a list of available flights from {string} to {string} for the selected dates")
    public void i_should_see_a_list_of_available_flights_from_to_for_the_selected_dates(String from, String to){
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='flight-count ng-star-inserted']")).getText().contains("flights"));
    }

}
