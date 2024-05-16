package hellocucumber;
import graphql.Assert;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepDefinitions {
    private final static String CHROME_DRIVER_PATH = "C:\\Users\\Shir\\Desktop\\sqe-system-testing-main\\Selenium\\chromedriver.exe";
    private ChromeDriver driver;
    private WebDriverWait wait;


    //postComment
    @Given("The student is on home page")
    public void openStudentHomePage()
    {
        //open moodle
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().window().maximize();
        driver.get("http://localhost/");
    }

    @When("Student logs in with {string} and {string}")
    public void studentIsLoggedInWithUsernamePassword(String student_username, String student_password)
    {
        //find login button element
        driver.findElement(By.xpath("/html/body/div[2]/nav/div[2]/div/div/span/a")).click();

        //fill in username and password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]"))).sendKeys(student_username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]"))).sendKeys(student_password);

        //login
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/section/div/div/div/div/form[1]/div[3]/button")).click();

    }

    @And("User posts a comment consists of {string} and {string} on forum")
    public void postCommentOnForum(String subject, String message)
    {
        //find courses button element
        driver.findElement(By.xpath("/html/body/div[2]/nav/div[1]/nav/ul/li[3]/a")).click();

        //find Software Quality Course button and click it
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/section/div/aside/section/div/div/div[1]/div[2]/div/div/div[1]/div/div/div/div[1]/div/div/a/span[3]/span[2]")));
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/section/div/aside/section/div/div/div[1]/div[2]/div/div/div[1]/div/div/div/div[1]/div/div/a/span[3]/span[2]")).click();
        try
        {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //find Forum button and click it
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[4]/div/div[3]/div/section/div/div/div/ul/li[1]/div[2]/ul/li[2]/div/div[2]/div/div/div/div/a")));
        driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div[3]/div/section/div/div/div/ul/li[1]/div[2]/ul/li[2]/div/div[2]/div/div/div/div/a")).click();
        try
        {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //find Add discussion button and click it
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[2]/div/section/div[2]/div[1]/div/div[2]/a")).click();
        try
        {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //post new comment
        //fill in Subject and Message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_subject\"]"))).sendKeys(subject);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[4]/div/div[2]/div/section/div[2]/div[2]/div[2]/form/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[3]")));
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[2]/div/section/div[2]/div[2]/div[2]/form/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[3]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[4]/div/div[2]/div/section/div[2]/div[2]/div[2]/form/div[3]/div[2]/div[1]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[2]")));
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[2]/div/section/div[2]/div[2]/div[2]/form/div[3]/div[2]/div[1]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[2]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div")));
        driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div")).click();

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

        //click "Post to forum" button
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[2]/div/section/div[2]/div[2]/div[2]/form/div[4]/div[2]/fieldset/div/div[1]/span/input")).click();
        try
        {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Then("The comment will post successfully")
    public void assureDiscussionPageIsOpen()
    {
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[2]/div/section/span[1]/div"));
        try
        {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    //delete forum
    @Given("The teacher is on home page")
    public void openTeacherHomePage() {
        //open moodle
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.get("http://localhost/");
        driver.manage().window().maximize();
    }

    @When("Teacher logs in with {string} and {string}")
    public void teacherIsLoggedInWithUsernamePassword(String teacher_username, String teacher_password)
    {
        //find login button element
        driver.findElement(By.xpath("//*[@id=\"usernavigation\"]/div/div/span/a")).click();

        //fill in username and password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]"))).sendKeys(teacher_username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]"))).sendKeys(teacher_password);

        //login
        driver.findElement(By.xpath("//*[@id=\"loginbtn\"]")).click();
        try
        {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("Teacher is on Edit Mode")
    public void changeToEditMode()
    {
        //find Edit Mode radio button
        driver.findElement(By.xpath("/html/body/div[2]/nav/div[2]/form/div/div/input")).click();
        try
        {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/nav/div[1]/nav/ul/li[4]/a")));
    }

    @And("Teacher is deleting forum")
    public void deleteForum() {
        //includes clicking on menu, choosing Delete and then clicking Delete button again on the popped window
        //find courses button element
        driver.findElement(By.xpath("/html/body/div[4]/nav/div[1]/nav/ul/li[3]/a")).click();

        //find Software Quality Course button and click it
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div[2]/div/section/div/aside/section/div/div[2]/div[1]/div[2]/div/div/div[1]/div/div/div/div[1]/div/div/a/span[3]/span[2]")));
        driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[2]/div/section/div/aside/section/div/div[2]/div[1]/div[2]/div/div/div[1]/div/div/div/div[1]/div/div/a/span[3]/span[2]")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //find three dots button and click it
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[5]/div/div[3]/div/section/div/div/div/ul/li[1]/div[2]/ul/li[2]/div[2]/div[2]/div[3]/div/div/div/div/a/i")));
        driver.findElement(By.xpath("/html/body/div[4]/div[5]/div/div[3]/div/section/div/div/div/ul/li[1]/div[2]/ul/li[2]/div[2]/div[2]/div[3]/div/div/div/div/a/i")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //press delete button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[5]/div/div[3]/div/section/div/div/div/ul/li[1]/div[2]/ul/li[2]/div[2]/div[2]/div[3]/div/div/div/div/div/a[7]/span")));
        driver.findElement(By.xpath("/html/body/div[4]/div[5]/div/div[3]/div/section/div/div/div/ul/li[1]/div[2]/ul/li[2]/div[2]/div[2]/div[3]/div/div/div/div/div/a[7]/span")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //pop up window and confirm delete
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div[2]/div/div/div[3]/button[2]")));
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div/div[3]/button[2]")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("Forum is deleted")
    public void deleteForumSuccessfully() {

        By componentLocator = By.id("yui_3_18_1_1_1709826964411_210");

        // Find all elements matching the specified locator
        List<WebElement> componentElements = driver.findElements(componentLocator);

        // Assert that the list is empty, indicating that the Moodle component is not present
        Assert.assertTrue(componentElements.isEmpty());

    }
}