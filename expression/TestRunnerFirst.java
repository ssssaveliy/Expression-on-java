package expression;

public class TestRunnerFirst {
    public static void main(String[] args) {
        testExamples();
        testExampless();
        runAllTests();
    }

    public static void testExamples() {
        Variable x = new Variable("x");
        Const c1 = new Const(1);
        Const c2 = new Const(2);

        assert new Add(c1, c2).evaluate(0) == 3 : "Test failed: (1 + 2)";
        assert new Subtract(c2, c1).evaluate(0) == 1 : "Test failed: (2 - 1)";
        assert new Multiply(c1, c2).evaluate(0) == 2 : "Test failed: (1 * 2)";
        assert new Divide(c2, c1).evaluate(0) == 2 : "Test failed: (2 / 1)";
        assert new Add(x, c2).evaluate(5) == 7 : "Test failed: (x + 2)";
        assert new Subtract(x, c1).evaluate(5) == 4 : "Test failed: (x - 1)";

    }

    public static void testExampless() {
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Const c1 = new Const(1);
        Const c2 = new Const(2);
        Const c10 = new Const(10);

        // Простые операции
        assert new Add(c1, c2).evaluate(0) == 3 : "Test failed: (1 + 2)";
        assert new Subtract(c2, c1).evaluate(0) == 1 : "Test failed: (2 - 1)";
        assert new Multiply(c1, c2).evaluate(0) == 2 : "Test failed: (1 * 2)";
        assert new Divide(c2, c1).evaluate(0) == 2 : "Test failed: (2 / 1)";

        // Тесты с переменными
        assert new Add(x, c2).evaluate(5) == 7 : "Test failed: (x + 2)";
        assert new Subtract(x, c1).evaluate(5) == 4 : "Test failed: (x - 1)";

        // Дополнительные тесты
        assert new Multiply(c10, x).evaluate(5) == 50 : "Test failed: (10 * x)";
        assert new Divide(c10, x).evaluate(2) == 5 : "Test failed: (10 / x)";

        // Более сложные тесты
        assert new Add(new Add(c1, c2), c10).evaluate(0) == 13 : "Test failed: (1 + 2 + 10)";
        assert new Subtract(new Multiply(c2, c10), c1).evaluate(0) == 19 : "Test failed: (2 * 10 - 1)";
        assert new Divide(new Multiply(c2, x), new Subtract(c10, x)).evaluate(3) == 6 : "Test failed: (2 * x / (10 - x))";
    }


    public static void runAllTests() {
        Variable vx = new Variable("x");
        Const c1 = new Const(1);
        Const c2 = new Const(2);

        // Тесты из EXAMPLE
        assert new Subtract(new Multiply(new Const(2), vx), new Const(3)).evaluate(5) == 7 : "Test failed: Example";
        assert new Multiply(new Const(2), vx).equals(new Multiply(new Const(2), vx)) : "Test failed: Example equals 1";
        assert !new Multiply(new Const(2), vx).equals(new Multiply(vx, new Const(2))) : "Test failed: Example equals 2";

        // Базовые тесты (basic)
        assert new Add(c2, c1).evaluate(0) == 3 : "Test failed: (2 + 1)";
        assert new Subtract(vx, c1).evaluate(5) == 4 : "Test failed: (x - 1)";
        assert new Multiply(c1, c2).evaluate(0) == 2 : "Test failed: (1 * 2)";
        assert new Divide(vx, c1).evaluate(5) == 5 : "Test failed: (x / 1)";
        assert new Add(c1, new Add(c2, c1)).evaluate(0) == 4 : "Test failed: (1 + (2 + 1))";
        assert new Subtract(vx, new Subtract(vx, c1)).evaluate(5) == 1 : "Test failed: (x - (x - 1))";

        // Пример для других выражений
        assert new Add(new Multiply(c1, c2), vx).evaluate(5) == 7 : "Test failed: ((1 * 2) + x)";
        assert new Multiply(vx, new Divide(c2, new Subtract(vx, c1))).evaluate(3) == 3 : "Test failed: (x * (2 / (x - 1)))";
        assert new Divide(vx, new Add(c1, new Add(c2, c1))).evaluate(12) == 2 : "Test failed: (x / (1 + (2 + 1)))";

        // Другие тесты из advanced
        assert new Add(new Multiply(c1, c2), vx).evaluate(5) == 7 : "Test failed: ((1 * 2) + x)";
        assert new Multiply(vx, new Divide(c2, new Subtract(vx, c1))).evaluate(5) == 10 : "Test failed: (x * (2 / (x - 1)))";
        assert new Divide(vx, new Add(c1, new Add(c2, c1))).evaluate(6) == 1 : "Test failed: (x / (1 + (2 + 1)))";
        assert new Subtract(vx, new Subtract(vx, c1)).evaluate(5) == 1 : "Test failed: (x - (x - 1))";
        assert new Multiply(new Const(3), new Divide(c2, new Subtract(vx, c1))).evaluate(10) == 30 : "Test failed: ((3 * (2 / (x - 1))))";

        // Дополнительные тесты (из advanced)
        assert new Add(c2, c1).evaluate(0) == 3 : "Test failed: (2 + 1)";
        assert new Subtract(vx, c1).evaluate(5) == 4 : "Test failed: (x - 1)";
        assert new Multiply(c1, c2).evaluate(0) == 2 : "Test failed: (1 * 2)";
        assert new Divide(vx, c1).evaluate(5) == 5 : "Test failed: (x / 1)";
        assert new Add(c1, new Add(c2, c1)).evaluate(0) == 4 : "Test failed: (1 + (2 + 1))";
        assert new Subtract(vx, new Subtract(vx, c1)).evaluate(5) == 1 : "Test failed: (x - (x - 1))";
        assert new Multiply(c1, new Divide(c2, new Subtract(vx, c1))).evaluate(10) == 30 : "Test failed: ((3 * (2 / (x - 1))))";

        // Тесты из экстра (advanced)
        assert new Add(new Multiply(c1, c2), vx).evaluate(5) == 7 : "Test failed: ((1 * 2) + x)";
        assert new Multiply(vx, new Divide(c2, new Subtract(vx, c1))).evaluate(3) == 3 : "Test failed: (x * (2 / (x - 1)))";
        assert new Divide(vx, new Add(c1, new Add(c2, c1))).evaluate(12) == 2 : "Test failed: (x / (1 + (2 + 1)))";
        assert new Multiply(vx, new Divide(new Const(10), new Subtract(vx, new Const(1)))).evaluate(10) == 10 : "Test failed: (x * (10 / (x - 1)))";

        assert new Divide(c1, new Const(0)).evaluate(0) == Integer.MAX_VALUE : "Test failed: (1 / 0)";  // Возвращаем максимально возможное значение

        assert new Add(new Const(-1), new Const(1)).evaluate(0) == 0 : "Test failed: (-1 + 1)";
        assert new Subtract(new Const(1), new Const(-1)).evaluate(0) == 2 : "Test failed: (1 - (-1))";

        assert new Multiply(new Const(1000000), new Const(1000000)).evaluate(0) == 1000000000000L : "Test failed: (1000000 * 1000000)";

        assert new Add(new Multiply(new Const(2), new Variable("x")), new Const(3)).evaluate(5) == 13 : "Test failed: ((2 * x) + 3)";
        assert new Subtract(new Multiply(new Const(2), new Variable("x")), new Divide(new Const(10), new Variable("x"))).evaluate(5) == 6 : "Test failed: ((2 * x) - (10 / x))";

        System.out.println("Basic examples tests passed!");
    }
}
