package interpreter.constraint;

import java.util.List;

public abstract class Expression_constraint {
    protected boolean inter = false;
    protected String data = null;

    public boolean interpret(String context){
        return true;
    }
}
