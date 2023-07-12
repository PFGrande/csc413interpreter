package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class CallCode implements ByteCode, Dumpable {
    private String label;
    public CallCode(String[] args) {
    }

    @Override
    public void execute(VirtualMachine vm) {
    }

//    @Override
//    public String toString() {
//
//    }
}
