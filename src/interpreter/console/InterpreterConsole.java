package interpreter.console;

import other.House;

public class InterpreterConsole {
    public House house;

    public InterpreterConsole(House house){
        this.house = house;
    }

    public void interpret(String str) {
        Expression_console expression_console = null;
        if (str.contains("desactivationdevice")) {
            expression_console = new DesactivationDeviceExpression_console(str,house);
            expression_console.interpret();
        } else if (str.contains("desactivationsensor")) {
            expression_console = new DesactivationSensorExpression_console(str,house);
            expression_console.interpret();
        } else if (str.contains("desactivationroom")) {
            expression_console = new DesactivationRoom(str,house);
            expression_console.interpret();
        }else if (str.contains("activationdevice")) {
            expression_console = new ActivationDeviceExpression_console(str,house);
            expression_console.interpret();
        } else if (str.contains("activationsensor")) {
            expression_console = new ActivationSensorExpression_console(str,house);
            expression_console.interpret();
        } else if (str.contains("activationroom")) {
            expression_console = new ActivationRoom(str,house);
            expression_console.interpret();
        } else if (str.contains("hum")) {
            expression_console = new HumExpression_console(str,house);
            expression_console.interpret();
        } else if (str.contains("light")) {
            expression_console = new LightExpression_console(str,house);
            expression_console.interpret();
        } else if (str.contains("wind")) {
            expression_console = new WindExpression_console(str,house);
            expression_console.interpret();
        } else if (str.contains("db")) {
            expression_console = new DbExpression_console(str,house);
            expression_console.interpret();
        } else if (str.contains("move")) {
            expression_console = new MoveExpression_console(str,house);
            expression_console.interpret();
        } else if (str.contains("temp")) {
            expression_console = new TempExpression_console(str,house);
            expression_console.interpret();
        } else if (str.contains("exit")) {
            System.exit(0);
        } else {
            System.out.println("\nError, retry please.\n");
        }
    }
}

