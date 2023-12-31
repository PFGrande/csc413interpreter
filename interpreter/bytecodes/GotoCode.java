package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class GotoCode implements ByteCode, Dumpable {
    private String label; // label to jump to

    public GotoCode(String[] args) {
        this.label = args[1];
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.jump(vm.getLabelAddress(this.label));
    }

    @Override
    public String toString() {
        return "GOTO " + label;
    }
}
