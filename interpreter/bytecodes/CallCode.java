package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class CallCode implements ByteCode, Dumpable {
    private String label;

    public CallCode(String[] args) {
        this.label = args[1];
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushReturnAddress();
        vm.jump(vm.getLabelAddress(label));

    }

    @Override
    public String toString() {
        return "CALL " + this.label; // TODO: arguments should be visible when dumping, ex: id- f<<2>> args-f(#,#)
    }
}
