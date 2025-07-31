package expression;

import java.util.Objects;

public class Const implements expression.CommonInterface {
    private long anInt;

    public Const(long x) {
        this.anInt = x;
    }

    public int getPriority() {
        return -1;
    }

    public long evaluate(int x) {
        return anInt;
    }

    public String toMiniString() {
        return this.toString();
    }

    public String toString() {
        return anInt+"";
    }

    @Override
    public boolean equals(Object exp) {
        return exp != null && this.getClass() == exp.getClass()
                && (Objects.equals(this.anInt, ((Const) exp).anInt));
    }

    @Override
    public int hashCode() {
        return Math.toIntExact(anInt);
    }

    public long evaluate(int x, int y, int z) {
        return anInt;
    }

    @Override
    public long evaluate(long x, long y, long z) {
        return 0;
    }
}