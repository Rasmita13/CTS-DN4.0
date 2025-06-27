
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ 
    EvenCheckerTest.class, 
    CalculatorTestWithSetup.class 
})
public class AllTests {
    // This class remains empty. It's used only as a holder for the above annotations.
}
