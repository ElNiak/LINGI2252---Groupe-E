package interpreter.constraint;

public class SensorExpression implements Expression_constraint {
    private boolean inter;
    private String data;

    public SensorExpression(boolean inter, String data){
        this.inter = inter;
        this.data = data;
    }

    @Override
    public void interpret(String context) {

    }
}
