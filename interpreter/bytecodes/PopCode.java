package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class PopCode implements ByteCode, Dumpable{
    int toPop; // amount of values to be popped from the RunTimeStack WITHIN a frame

    public PopCode(String[] args) {
        this.toPop = Integer.parseInt(args[1]);
    }

    @Override
    public void execute(VirtualMachine vm) {
        if (vm.isWithinFrame(toPop)) {
            for (int i = 0; i <= toPop; i++) {
                vm.popRunTimeStack();
            }
        }
    }

    @Override
    public String toString() {
        return "POP " + toPop;
    }
}
