package tests;

import com.github.javafaker.Faker;
import org.kurtosysAssessment.pages.HomePage;
import org.kurtosysAssessment.pages.WhitePaperPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyInsightPageTitleTest extends BaseTest {
 HomePage homePage = new HomePage(browserDriver.getDriver());
 WhitePaperPage whitePaperPage  = new WhitePaperPage(browserDriver.getDriver());

Faker faker = new Faker();
    @Test
    public void getTitleForInsightsPage(){

        homePage.clickInsightsLinkText();
        homePage.selectWhitePaperLinkText();
        homePage.getTitlePage();

        Assert.assertTrue(homePage.getTitlePage());

        browserDriver.scrollToElementView();
        whitePaperPage.clickUCITSWhitePaper();
        whitePaperPage.populateFirstName(faker.funnyName().name());
        whitePaperPage.populateLastName(faker.funnyName().name());
        whitePaperPage.populateCompanyName(faker.company().name());
        whitePaperPage.populateIndustryField(faker.company().name());
        whitePaperPage.clickSendButton();


    }
}

