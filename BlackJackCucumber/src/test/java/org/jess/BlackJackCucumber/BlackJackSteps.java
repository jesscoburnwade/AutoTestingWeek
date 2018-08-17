package org.jess.BlackJackCucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BlackJackSteps {
	
	int a;
    int b;
	private BlackJack blackJack;
	
	@Given("^an integer a and an integer b$")
	public void an_integer_a_and_an_integer_b() throws Throwable {
		   a = 5;
		   b = 9;
		   this.a_is_less_than_b_and_b_is_less_than_Twenty_One();
	    throw new PendingException();
	}

	@When("^a is less than b and b is less than Twenty-One$")
	public void a_is_less_than_b_and_b_is_less_than_Twenty_One() throws Throwable {
	    if (a < b && b < 21) {
	    	this.b_is_returned();
	    } else if (a > b && a < 21) {
	    	this.a_is_returned();
	    }
	    throw new PendingException();
	}

	@Then("^b is returned$")
	public void b_is_returned() throws Throwable {
	    System.out.println("b wins = " + b);
	}

	@Given("^an integer a and an integer b which is above Twenty-One$")
	public void an_integer_a_and_an_integer_b_which_is_above_Twenty_One() throws Throwable {
	    a = 23;
	    a = 54;
	    this.an_integer_a_and_b_is_above_Twenty_One();
	    throw new PendingException();
	}

	@When("^an integer a and b is above Twenty-One$")
	public void an_integer_a_and_b_is_above_Twenty_One() throws Throwable {
	    System.out.println("no one wins");
	    throw new PendingException();
	}

	@Then("^a is returned$")
	public void a_is_returned() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^a is greater than b and a is less than Twenty-One$")
	public void a_is_greater_than_b_and_a_is_less_than_Twenty_One() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^a is higher than b and less than Twenty-One and b is above Twenty-One$")
	public void a_is_higher_than_b_and_less_than_Twenty_One_and_b_is_above_Twenty_One() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^an integer a and an integer b which are both under Twenty-One$")
	public void an_integer_a_and_an_integer_b_which_are_both_under_Twenty_One() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^an integer a and b both under Twenty-One$")
	public void an_integer_a_and_b_both_under_Twenty_One() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the identical value of a and b is returned$")
	public void the_identical_value_of_a_and_b_is_returned() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^an integer a and an integer b which are both over Twenty-One$")
	public void an_integer_a_and_an_integer_b_which_are_both_over_Twenty_One() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^an integer a and b both over Twenty-One$")
	public void an_integer_a_and_b_both_over_Twenty_One() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^then Zero is returned$")
	public void then_Zero_is_returned() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}