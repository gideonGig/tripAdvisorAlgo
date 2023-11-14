package mastercard;

import java.util.ArrayList;
import java.util.List;

public class Basics {
    public Object check(int x) {
        int y = 50;
        return x == y;
    }

    public void testObjecEquality() {
        Integer value1 = Integer.valueOf(5);
        Integer value2 = value1;
        Integer value3 = value2;
        value3 = 7;

        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3);

        if (value1.equals(value2)) {
            System.out.println("Looking out my window");
        }

        if (value1 == value2) {
            System.out.println("In October's golden light,");
        }

        if (value1 == value3) {
            System.out.println("I see a beauty unsurpassed,");
        }

        if (value2.equals(value3)) {
            System.out.println("Wind their way up through the hills.");
        }

        if (value3 == Integer.valueOf(7)){
            System.out.println("Forewarn of winter chills,");
        }

        if (value3.equals(Integer.valueOf(7))) {
            System.out.println("A truly lovely sight.");
        }
    }

    public float calculateValue(String op, float value1, float value2) {
        float result = 0;
        switch (op) {
            case "*":
                result = value1 * value2;
                break;
            case "/":
                result = value1 / value2;
                break;
            case "+":
                result = value1 + value2;
                break;
            case "-":
                result = value1 - value2;
                break;
            default:
                result = value1 + value2;
            break;
        }
        System.out.println(result);
        return result;
    }

    public void testGenerics() {
        List bestDesserts = new ArrayList();
        bestDesserts.add("dessert");
        bestDesserts.add(20);

        for (Object obj : bestDesserts) {
            System.out.println(obj);
        }

        System.out.println(bestDesserts);
    }
}
