package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class LabelCode implements ByteCode, Dumpable {
    private String label;

    public LabelCode(String[] args) {
        this.label = args[1];
    }

    @Override
    public void execute(VirtualMachine vm) {

    }

    @Override
    public String toString() {
        return "LABEL " + this.label;
    }

    public String getLabel() {
        return label;
    }
}
