package ru.stqa.pft.addressbook.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    WebDriver driver;
    boolean acceptNextAlert = true;
    StringBuffer verificationErrors = new StringBuffer();

    @Test
    public void testContactCreationLite() throws Exception {
        gotoAddNewPage();
        fillContactFormLite(new ContactData("Vasy", "Pupkin", "Lupkin", "VPL", "89000000000", "test1@test.test"));
        submitContactCreation();
        returnToHomePage();
    }

    private void submitContactCreation() {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]")).click();
    }

    private void fillContactFormLite(ContactData contactData) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
        driver.findElement(By.name("middlename")).click();
        driver.findElement(By.name("middlename")).clear();
        driver.findElement(By.name("middlename")).sendKeys(contactData.getMiddlename());
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
        driver.findElement(By.name("nickname")).click();
        driver.findElement(By.name("nickname")).clear();
        driver.findElement(By.name("nickname")).sendKeys(contactData.getNickname());
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(contactData.getEmail());
    }

    private void returnToHomePage() {
        driver.findElement(By.linkText("home")).click();
    }

    private void gotoAddNewPage() {
        driver.findElement(By.linkText("add new")).click();
    }
}