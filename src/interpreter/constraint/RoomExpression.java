package interpreter.constraint;

public class RoomExpression implements Expression_constraint {
    private boolean inter;
    private String data;

    public RoomExpression(boolean inter, String data){
        this.inter = inter;
        this.data = data;
    }

    @Override
    public void interpret(String context) {

    }
}
