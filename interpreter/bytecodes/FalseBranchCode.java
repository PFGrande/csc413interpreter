package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class FalseBranchCode implements ByteCode, Dumpable {
    private String label;
    public FalseBranchCode(String[] args) {
        this.label = args[1];

    }

    @Override
    public void execute(VirtualMachine vm) {
        if (vm.popRunTimeStack() == 0) {
            //vm.getLabelAddress(this.label);
            vm.jump(vm.getLabelAddress(this.label));
        }
    }

    @Override
    public String toString() {
        return "FALSEBRANCH: " + label;
    }
}
