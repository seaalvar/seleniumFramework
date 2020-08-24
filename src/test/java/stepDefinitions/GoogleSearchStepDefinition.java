package stepDefinitions;

import java.io.IOException;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GoogleSearchPage;
import utils.TestUtils;


public class GoogleSearchStepDefinition extends BaseClass{

	GoogleSearchPage googleSearchPage;
	TestUtils testUtils;
	
	@Before
    public void setUp() throws IOException
    {
		initialization();
		googleSearchPage = new GoogleSearchPage();
		testUtils = new TestUtils();
    }
	
	@Given("The user goes to page {string}")
	public void the_user_goes_to_page(String strUrl) {
		getLogger().info("********* Opening URL ************");
		getDriver().get(strUrl);
		getDriver().manage().window().maximize();
	}

	@When("The user types {string} into the search field")
	public void the_user_types_into_the_search_field(String strSearch) {
		googleSearchPage.typeSearch(strSearch);
	}

	@When("The user clicks on the google search button")
	public void the_user_clicks_on_the_google_search_button() {
		googleSearchPage.clickLogo();
		googleSearchPage.clickOnBtnSearch();
	}

	@When("The user clicks on {string} link")
	public void the_user_clicks_on_link(String strLink) {
		googleSearchPage.clickOnLink(strLink);
	}

	@Then("The user should see {string} page")
	public void the_user_should_see_page(String strExpected) throws IOException {
		googleSearchPage.validateTitlePage(strExpected);
		testUtils.takeScreenshotAtEndOfTest();
	}

	@When("The user clicks on the first result link")
	public void the_user_clicks_on_the_first_result_link() {
		googleSearchPage.clickOnFirstLink();
	}

	@Then("The user should not see {string} page")
	public void the_user_should_not_see_page(String strExpected) throws IOException {
		googleSearchPage.validateNotEqualsTitlePage(strExpected);
		testUtils.takeScreenshotAtEndOfTest();
	}

	@When("The user clicks on the first suggestion in the list")
	public void the_user_clicks_on_the_first_suggestion_in_the_list() throws InterruptedException {
		googleSearchPage.clickOnSuggestionsList();
	}
	
	@After
	public void close()
    {
		getDriver().quit();
    }
	

}
