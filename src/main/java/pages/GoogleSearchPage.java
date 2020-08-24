package pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class GoogleSearchPage extends BaseClass{
	
	@FindBy(name="q")
	public WebElement txtSearch;
	
	@FindBy(xpath = "/html/body/div/div[2]/form/div[2]/div[1]/div[3]/center/input[1]")
	public WebElement btnSearch;
	
	@FindBy(id="hplogo")
	public WebElement imgLogo;
	
	@FindBy(className="DKV0Md")
	public List<WebElement> lstResults;
	
	@FindBy(className="sbct")
	public List<WebElement> lstSuggestions;
	

	public GoogleSearchPage() {
		PageFactory.initElements(getDriver(),  this);
	}
	
	public void typeSearch(String strSearch) {
		txtSearch.sendKeys(strSearch);
	}
	
	public void clickLogo() {
		imgLogo.click();
	}
	
	public void clickOnBtnSearch() {
		btnSearch.click();
	}
	
	public void clickOnLink(String strLink) {
		for(int i=0; i<lstResults.size(); i++) {
			if(lstResults.get(i).getText().equals(strLink)) {
				lstResults.get(i).click();
			}
		}
    }
	
	public void clickOnSuggestionsList() throws InterruptedException {
		Thread.sleep(3000);
		lstSuggestions.get(0).click();
    }
	
	public void clickOnFirstLink() {
		lstResults.get(0).click();
    }
	
	public void validateTitlePage(String strExpected) {
		String actual = getDriver().getTitle();
		assertEquals(actual, strExpected);
	}

	public void validateNotEqualsTitlePage(String strExpected) {
		String actual = getDriver().getTitle();
		assertNotEquals(actual, strExpected);
	}

}
