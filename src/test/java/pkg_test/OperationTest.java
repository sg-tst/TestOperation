package pkg_test;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import pkg_oper.OperationMain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


@RunWith(value = Parameterized.class)
public class OperationTest {
    private String operand1;
    private String operand2;
    private String operation;
    private String result;

    private OperationMain steps;

    public OperationTest(String oper1, String oper2, String operat, String res) {
        this.operand1 = oper1;
        this.operand2 = oper2;
        this.operation = operat;
        this.result = res;
    }

    @Parameters
    public static ArrayList<String[]> fileRows() {
        ArrayList<String[]> fileRows = new ArrayList<String[]>();
        String dataFile = "src/main/resources/file.csv";
        BufferedReader br = null;
        String lineFile = " ";
        String cvsSplit = ";";
        try {
            br = new BufferedReader(new FileReader(dataFile));
            while ((lineFile = br.readLine()) != null) {
                fileRows.add(lineFile.split(cvsSplit));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return fileRows;
    }

    @Before
    public void setup() {
        steps = new OperationMain();
    }

    @Test
    public void testSelector() throws Exception {
        try {
            if (operation.equals("+")) {
                steps.OperationAdditionTest(Integer.parseInt(operand1), Integer.parseInt(operand2), Integer.parseInt(result));
            } else if (operation.equals("-")){
                steps.OperationSubtractionTest(Integer.parseInt(operand1), Integer.parseInt(operand2), Integer.parseInt(result));
            } else if (operation.equals("*")){
                steps.OperationMultiplicationTest(Integer.parseInt(operand1), Integer.parseInt(operand2), Integer.parseInt(result));
            } else if (operation.equals("/")){
                steps.OperationDivisionTest(Integer.parseInt(operand1), Integer.parseInt(operand2), Integer.parseInt(result));
            } else {
                steps.OperationError(operand1, operand2, operation, result);
            }
        } catch (Exception e){
            Assert.assertFalse("Error test select! " + e,true);
        }

    }

}