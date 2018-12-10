package interpreter.constraint;

public class SofwareExpression implements Expression_constraint {
    private boolean inter;
    private String data;

    public SofwareExpression(boolean inter, String data){
        this.inter = inter;
        this.data = data;
    }

    @Override
    public void interpret(String context) {

    }
}
