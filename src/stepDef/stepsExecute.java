package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import businesscomponents.*;

public class stepsExecute {
	
	Login_Reservation login = new Login_Reservation();
	
	
	@Given("^User launch the browser$")
	public void User_is_on_Home_Page() throws Throwable {
		login.launchBrowser();
	}

	@When("^User Navigate to Home Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
	    
		login.launchUrl();
	}
	
	@When("^Select origin and arrival places$")
	public void select_source_and_destination_from_excel() throws Throwable {
	    
		login.chooseLocations();
	}
	
	@Then("^choose the cheapest and fastest flight and close the browser$")
	public void select_the_cheapest_and_fastest_flight_and_close_the_browser() throws Throwable {
	    
		login.bookFlightTicket();
	}
}
