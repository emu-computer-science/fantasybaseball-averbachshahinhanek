package testing;
import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;

import javax.script.ScriptException;


////AVG, OBP, AB, SLG, SB.

public class aladdintesting {
    public static void main(String[] args) throws ScriptException, UnparsableExpressionException, UnknownFunctionException {
        String sTest = "SLG + SB - 2";
        evalfun(sTest);

    }

    public static void evalfun(String sTest) throws UnparsableExpressionException, UnknownFunctionException {

        Calculable calc = new ExpressionBuilder(sTest)
                .withVariableNames("AVG", "OBP", "AB", "SLG", "SB")
                .build();
        calc.setVariable("AVG",25); //<-- Here is where we would call the function to get the player AVG
        calc.setVariable("OBP",22);
        calc.setVariable("AB",2);
        calc.setVariable("SLG",2);
        calc.setVariable("SB",2);

        //assertEquals(0, calc.calculate(), 0.0);

        System.out.println(calc.calculate());
    }
    }