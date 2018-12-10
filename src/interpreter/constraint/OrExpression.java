package interpreter.constraint;

import java.util.List;

public class OrExpression implements Expression_constraint {
    private List<Expression_constraint> constraint;

    public OrExpression(List<Expression_constraint> constraint){
        this.constraint = constraint;
    }

    @Override
    public void interpret(String context) {

    }
}
