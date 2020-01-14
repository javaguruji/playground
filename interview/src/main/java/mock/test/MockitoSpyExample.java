package mock.test;

import org.mockito.InOrder;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author badrikant.soni
 */
public class MockitoSpyExample {

    private Employee spyEmp;
    private Employee emp;
    private static final String FIRST_NAME = "Joe";
    private static final String LAST_NAME = "M";
    private static final int AGE = 35;

    @BeforeMethod
    public void buildSpy(){

        emp = new Employee(FIRST_NAME, LAST_NAME, AGE);
        spyEmp = Mockito.spy(emp);

    }

    @Test
    public void verifySpyEffectOnRealObjects(){
        spyEmp.setAge(20);
        System.out.println(emp.getAge());
        System.out.println(spyEmp.getAge());
        Assert.assertNotEquals(spyEmp.getAge(), emp.getAge());
    }

    @Test
    public void verifyEmployeeDetails(){
        System.out.println("Full name:" + spyEmp.getFullName());
        System.out.println("Age:" + spyEmp.getAge());

        InOrder inOrder = inOrder(spyEmp);
        inOrder.verify(spyEmp).getFirstName();
        inOrder.verify(spyEmp).getLastName();
        verify(spyEmp).getAge();
        assertEquals(spyEmp.getFirstName(), FIRST_NAME);
        assertEquals(spyEmp.getLastName(), LAST_NAME);
        assertEquals(spyEmp.getFullName(), FIRST_NAME + " " + LAST_NAME);
        assertEquals(spyEmp.getAge(), AGE);
        verify(spyEmp, times(2)).getFullName();
    }

    @Test
    public void spyEmployeeName() {
        final String I_AM = "I am";
        final String THE_SPY = "the Spy";
        System.out.println("Train employee to return " + I_AM + " when emp.getFirstName() is called");
        when(spyEmp.getFirstName()).thenReturn(I_AM);
        System.out.println("Full Name: " + spyEmp.getFullName());
        assertEquals(I_AM + " M", spyEmp.getFullName());

        System.out.println("Train employee to return " + THE_SPY + " when emp.getLastName() is called");
        when(spyEmp.getLastName()).thenReturn(THE_SPY);
        System.out.println("Full Name: " + spyEmp.getFullName());
        assertEquals(I_AM + " " + THE_SPY, spyEmp.getFullName());
    }
}
