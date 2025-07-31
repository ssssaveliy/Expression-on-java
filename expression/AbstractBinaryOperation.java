package expression;
import java.util.Map;

abstract class AbstractBinaryOperation implements Expression, TripleExpression, LongMapExpression {
    protected final Expression left, right;

    protected AbstractBinaryOperation(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    protected abstract int apply(long left, long right);

    @Override
    public long evaluate(long x) {
        return apply(left.evaluate(x), right.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return apply(((TripleExpression) left).evaluate(x, y, z), ((TripleExpression) right).evaluate(x, y, z));
    }

    @Override
    public long evaluateL(Map<String, Long> variables) {
        return applyLong(
                ((LongMapExpression) left).evaluateL(variables),
                ((LongMapExpression) right).evaluateL(variables)
        );
    }

    protected long applyLong(long left, long right) {
        return apply((int) left, (int) right); // По умолчанию переиспользуем int-операцию
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        AbstractBinary other = (AbstractBinary) obj;
        return left.equals(other.left) && right.equals(other.right);
    }

    @Override
    public String toString() {
        return "(" + left + " " + getSymbol() + " " + right + ")";
    }

    @Override
    public String toMiniString() {
        return left.toMiniString() + " " + getSymbol() + " " + right.toMiniString();
    }

    protected abstract String getSymbol();
}
