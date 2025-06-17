package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks {

    @Before("@NetBanking")
    public void netBankingSetup() {
        System.out.println("===============Under Before hooks===================");
        System.out.println("Setup the entries in NetBanking DataBase");
        System.out.println("===========END Before hooks=======================");
    }


    @After
    public void tearDown() {
        System.out.println("Clear the entries");
    }


    @Before("@Mortgage")
    public void mortgageSetup() {
        System.out.println("===============Under Before hooks===================");
        System.out.println(" Setup the entries in Mortgage DataBase");
        System.out.println("===============Under Before hooks===================");
    }

    @After
    public void tearDown2() {
        System.out.println("Setup the entries in NetBanking DataBase");
    }


}
