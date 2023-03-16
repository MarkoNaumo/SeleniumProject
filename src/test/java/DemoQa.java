import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class DemoQa {

    @Test
    public void iframe(){
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://demoqa.com/frames");
        WebElement iframe = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(iframe);
        var text = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(text);
        driver.switchTo().defaultContent();
        WebElement main = driver.findElement(By.className("main-header"));

        System.out.println(main.getText());
        driver.quit();
    }

    @Test
    public void tabs(){
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://demoqa.com/browser-windows");
        WebElement tabButton = driver.findElement(By.id("tabButton"));
        tabButton.click();

        String win= driver.getWindowHandle();

        ArrayList<String> tab = new ArrayList<>();
        for (String curWin:tab){

            driver.switchTo().window(curWin);
            var text = driver.findElement(By.id("sampleHeading")).getText();
            System.out.println(text);
        }
        driver.switchTo().window(win);

        driver.quit();
    }

    @Test
    public void form(){
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://demoqa.com/automation-practice-form");
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Marko");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Naumovic");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("marko@email.com");

        WebElement gender = driver.findElement(By.id("gender-radio-1"));
        Actions actions = new Actions(driver);
        actions.moveToElement(gender).click().perform();

        WebElement userNumber = driver.findElement(By.id("userNumber"));
        userNumber.sendKeys("06512456464");

        driver.findElement(By.id("dateOfBirthInput")).click();
        Select monthSelect = new Select(driver.findElement(By.className("react-datepicker__month-select")));
        monthSelect.selectByValue("5");
        Select yearSelect= new Select(driver.findElement(By.className("react-datepicker__year-select")));
        yearSelect.selectByValue("2000");
        driver.findElement(By.className("react-datepicker__day--011")).click();

        WebElement hobbies = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",hobbies);
        hobbies.click();

        WebElement upload = driver.findElement(By.id("uploadPicture"));
        upload.sendKeys("C:\\Users\\QA36\\IdeaProjects\\SeleniumProject\\src\\test\\java\\tree-736885_960_720.jpg");

        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);

        WebElement submit = driver.findElement(By.id("submit"));
        actions.moveToElement(submit).build().perform();

        driver.quit();
    }
}
