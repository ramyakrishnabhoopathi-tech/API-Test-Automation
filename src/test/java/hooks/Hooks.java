package hooks;

import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void beforeScenario(){

        System.out.println("===== API Execution Started =====");
    }
}