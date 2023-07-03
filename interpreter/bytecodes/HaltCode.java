package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class HaltCode implements ByteCode {
    public HaltCode(String[] args) { // arguments are ignored for HALT

    }

    @Override
    public void execute(VirtualMachine vm) {

    }
}
