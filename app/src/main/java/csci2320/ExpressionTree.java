package csci2320;

import java.util.function.BiFunction;

public class ExpressionTree {
    private final Node root;

    public ExpressionTree(String expr) {
        root = parse(expr);
    }

    public double eval() {
        return root.eval();
    }

    private Node parse(String fullExpr) {
        String expr = fullExpr.trim();
        int parensCount = 0;
        int opLoc = -1;
        for(int i = expr.length()-1; i > 0; --i) {
            char c = expr.charAt(i);
            if (c == ')' ) parensCount++;
            else if (c == '(') parensCount--;
            if (parensCount == 0 && (c=='+' || c == '-')) {
                opLoc = i;
                i = -1;
            } else if (parensCount == 0 && opLoc == -1 && (c == '*' || c == '/')) {
                opLoc = i;
            }
            // ()
            // + -
            // x /
        }
        return null;
    }

    private static interface Node {
        double eval();
    }


    private static record NumberNode(double value) implements Node {
        public double eval() {
            return value;
        }
    }

    private static record BinaryOpNode(BiFunction<Double, Double, Double> op, Node left, Node right) implements Node {
        public double eval() {
            return op.apply(left.eval(), right.eval());
        }
    } 
}
