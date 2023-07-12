package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class DumpCode implements ByteCode {
    String state;
    public DumpCode(String[] args) {
        this.state = args[1];
    }

    @Override
    public void execute(VirtualMachine vm) {
        if (this.state.equals("ON")) {
            vm.updateDumpStatus(true);
        } else if (this.state.equals("OFF")) {
            vm.updateDumpStatus(false);
        }

    }
}
