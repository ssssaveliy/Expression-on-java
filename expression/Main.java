package expression;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java Main <value_of_x>");
            return;
        }

        try {
            int x = Integer.parseInt(args[0]);
            Expression expression = new Add(
                    new Multiply(new Variable("x"), new Variable("x")),
                    new Add(
                            new Multiply(new Const(-2), new Variable("x")),
                            new Const(1)
                    )
            );

            System.out.println("Expression: " + expression.toString());
            System.out.println("Result: " + expression.evaluate(x));


        } catch (NumberFormatException e) {
            System.err.println("Invalid input: " + args[0]);
        }

        TripleExpression expr = new Subtract(
                new Add(
                        new Variable("x"),
                        new Variable("y")
                ),
                new Const(1)
        );

        System.out.println(expr.evaluate(2, 3, 5)); // 4
        System.out.println(expr.toString()); // ((x + y) - 1)
        System.out.println(expr.toMiniString()); // x + y - 1

        // Для произвольных переменных:
        Map<String, Long> variables = Map.of("xx", 3L, "yy", 2L);
        Expression expr2 = new Subtract(
                new Add(
                        new Variable("xx"),
                        new Variable("yy")
                ),
                new Const(1)
        );
        System.out.println(((LongMapExpression) expr2).evaluateL(variables)); // 4
        System.out.println(expr2.toString()); // ((xx + yy) - 1)

        
    }
}
