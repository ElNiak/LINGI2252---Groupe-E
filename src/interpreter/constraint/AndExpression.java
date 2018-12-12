package interpreter.constraint;

import java.util.List;

public class AndExpression extends Expression_constraint {
    private List<Expression_constraint> constraint;

    public AndExpression(List<Expression_constraint> constraint){
        this.constraint = constraint;
    }

    public boolean interpret() {
        return calculus(constraint);
    }

    public boolean calculus(List<Expression_constraint> expression_constraints){
        boolean res = true;
        for (Expression_constraint expression: expression_constraints) {
            res = res && expression.inter;
        }
        return res;
    }
}
