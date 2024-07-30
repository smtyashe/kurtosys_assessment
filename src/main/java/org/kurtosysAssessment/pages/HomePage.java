package org.kurtosysAssessment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    WebElement insightsButton = driver.findElement(By.linkText("INSIGHTS"));

    WebElement whitePapersLink = driver.findElement(By.linkText("White Papers & eBooks"));


    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void clickInsightsLinkText(){

        insightsButton.click();
    }

    public void selectWhitePaperLinkText() {
        whitePapersLink.click();
    }

    public boolean getTitlePage(){
        boolean pageTitle = false;
        if (driver.getTitle().contains("White Papers")) {
            System.out.println("Title verified: White Papers");
        } else {
            System.out.println("Title does not match.");

        }
        return pageTitle;
    }

}
