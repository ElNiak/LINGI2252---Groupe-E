package interpreter.constraint;

import java.util.List;

public class OrExpression extends Expression_constraint {
    private List<Expression_constraint> constraint;

    public OrExpression(List<Expression_constraint> constraint){
        this.constraint = constraint;
    }

    @Override
    public boolean interpret(String context) {
        return calculus(constraint);
    }

    public boolean calculus(List<Expression_constraint> expression_constraints){
        boolean res = true;
        for (Expression_constraint expression: expression_constraints) {
            res = res || expression.inter;
        }
        return res;
    }
}
