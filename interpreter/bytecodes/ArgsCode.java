package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class ArgsCode implements ByteCode, Dumpable {
    private int argsAmount;

    public ArgsCode(String[] args) {
        this.argsAmount = Integer.parseInt(args[1]);
    }

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println(vm.getRunTimeStackSize());
        System.out.println(this.argsAmount);
        vm.newFrame(vm.getRunTimeStackSize()-this.argsAmount);
    }

    @Override
    public String toString() {
        return "ARGS " + this.argsAmount;
    }
}
