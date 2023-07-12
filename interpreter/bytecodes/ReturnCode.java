package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class ReturnCode implements ByteCode, Dumpable {
    String id;

    public ReturnCode(String[] args) {
        if (args.length > 1) {
            this.id = args[1]; // function id
        }
    }

    @Override
    public void execute(VirtualMachine vm) {

    }
}
