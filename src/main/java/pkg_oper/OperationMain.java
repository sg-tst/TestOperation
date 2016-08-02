package pkg_oper;

import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;


public class OperationMain {
    public static void main(String[] args) {
        System.out.println("Start app ...");
    }

    public OperationMain(){
    }

    @Step
    public void OperationAdditionTest(int oper1, int oper2, int expResult) {
        int trueResult = oper1 + oper2;
        Assert.assertEquals(expResult, trueResult);
    }

    @Step
    public void OperationSubtractionTest(int oper1, int oper2, int expResult) {
        int trueResult = oper1 - oper2;
        Assert.assertEquals(expResult, trueResult);
    }

    @Step
    public void OperationMultiplicationTest(int oper1, int oper2, int expResult) {
        int trueResult = oper1 * oper2;
        Assert.assertEquals(expResult, trueResult);
    }

    @Step
    public void OperationDivisionTest(int oper1, int oper2, int expResult) {
        try{
            int trueResult = oper1 / oper2;
            Assert.assertEquals(expResult, trueResult);
        } catch (ArithmeticException e){
            Assert.assertFalse("Operation error " + e,true);
        }
    }

    @Step
    public void OperationError(String oper1, String oper2, String operat, String res) {
        Assert.assertFalse("Operation (" + operat +") is not processed.",true);
    }

}
