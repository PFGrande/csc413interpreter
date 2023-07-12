package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

// copy value from offset (within the current frame) and push it to the top of the runtimestack
public class LoadCode implements ByteCode, Dumpable{
    private int offset;
    private String id;

    public LoadCode(String[] args) {
        this.offset = Integer.parseInt(args[1]);

        if (args.length == 3) {
            id = args[2];
        }

    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.load(offset);
    }

    @Override
    public String toString() {
        String base = "LOAD " + this.offset;
        if (this.id != null) {
            base += " " + this.id;
        }
        return base;
    }
}
