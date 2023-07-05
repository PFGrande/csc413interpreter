package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class PopCode implements ByteCode, Dumpable{
    int toPop; // amt of values to be popped in a frame

    public PopCode(String[] args) {
    }

    @Override
    public void execute(VirtualMachine vm) {

    }
}
