package org.kurtosysAssessment.pages;

import com.google.common.io.Files;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.List;

public class WhitePaperPage extends BasePage {

    WebElement ucitsLink = driver.findElement(By.linkText("UCITS White Paper"));
    WebElement firstNameField = driver.findElement(By.name("firstName"));
    WebElement lastNameField = driver.findElement(By.name("lastName"));
    WebElement companyField = driver.findElement(By.name("company"));
    WebElement industryField = driver.findElement(By.name("industry"));

    WebElement sendButton = driver.findElement(By.xpath("//button[text()='Send me a copy']"));

    List<WebElement> errorMessages = driver.findElements(By.className("error-message"));

    public WhitePaperPage(WebDriver driver) {
        super(driver);
    }

    public void clickUCITSWhitePaper() {
        ucitsLink.click();
    }

    public void populateFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void populateLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void populateCompanyName(String companyName) {
        companyField.sendKeys(companyName);
    }

    public void populateIndustryField(String industry) {
        industryField.sendKeys(industry);
    }

    public void clickSendButton() {
        sendButton.click();
    }



    public List<WebElement> takeSScreenShot() {

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(((File) screenshot).toPath().toFile(), (OutputStream) Paths.get("error_screenshot.png"));
            System.out.println("Screenshot saved as: error_screenshot.png");
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
        if (errorMessages.isEmpty()) {
            System.out.println("No error messages found.");
        } else {
            for (WebElement msg : errorMessages) {
                System.out.println("Error Message: " + msg.getText());
            }
        }
        return errorMessages;
    }
}
