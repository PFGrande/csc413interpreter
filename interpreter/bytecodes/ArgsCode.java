package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class ArgsCode implements ByteCode {
    private int argsAmount;

    public ArgsCode(String[] args) {
        this.argsAmount = Integer.parseInt(args[1]);
    }

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println(vm.getRunTimeStackSize());
        System.out.println(argsAmount);
        vm.newFrame(vm.getRunTimeStackSize()-argsAmount);
    }

    @Override
    public String toString() {
        return "ARGS " + argsAmount;
    }
}
