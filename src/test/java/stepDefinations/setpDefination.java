package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class setpDefination {


    @Given("Admin is on Net Banking Landing Page")
    public void admin_is_on_net_banking_landing_page() {
        System.out.println("This is under :: User is on Net Banking Landing Page :: ");

    }

    @When("^User login into application with (.+) and Password (.+)$")
    public void user_login_into_application_with_and_password(String username, String password) {
        System.out.println("User Name: " + username);
        System.out.println("Password: " + password);
    }

    @Then("Home Page is displayed")
    public void home_page_is_displayed() {
        System.out.println("This is under :: Home Page is populated :: ");
    }

    @Then("Cards are displayed")
    public void cards_are_displayed() {
        System.out.println("This is under :: Cards displayed are \"true\" :: ");
    }


    @Given("User is on NetBanking landing page")
    public void user_is_on_net_banking_landing_page() {
        System.out.println("This is under :: User is on NetBanking landing page :: ");
    }


    @Given("User is on Practice landing page")
    public void user_is_on_practice_landing_page() {
        System.out.println("This is under :: User is on Practice landing page :: ");
    }


    @When("User Signup into application")
    public void user_signup_into_application(List<String> data) {
        System.out.println("==============");
        System.out.println(data.get(0));
        System.out.println(data.get(1));
        System.out.println(data.get(2));
        System.out.println(data.get(3));
        System.out.println("==============");
    }


    @Given("setup the entries in database")
    public void setup_the_entries_in_database() {
        System.out.println("*****************************************");
        System.out.println("This is under :: setup the entries in database :: ");
    }

    @When("launch the browser from config variables")
    public void launch_the_browser_from_config_variables() {
        System.out.println("This is under :: launch the browser from config variables :: ");
    }

    @When("hit the home page url of banking site")
    public void hit_the_home_page_url_of_banking_site() {
        System.out.println("This is under :: hit the home page url of banking site :: ");
        System.out.println("*****************************************");
    }


}
