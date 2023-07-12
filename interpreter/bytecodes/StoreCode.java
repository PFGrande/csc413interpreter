package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;
// behavior: pops value from top of rts, places it within an index inside the current frame
// offset: index from start of new frame
public class StoreCode implements ByteCode { // explained @ 56:25
    private int storeAtOffset;
    private String id;

    public StoreCode(String[] args) {
        this.storeAtOffset = Integer.parseInt(args[1]);
        if (args.length == 3) {
            this.id = args[2];
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        if (vm.isWithinFrame(this.storeAtOffset) && (vm.getFrameSize() - 1) > this.storeAtOffset) {
            vm.store(this.storeAtOffset); // rts store method pops the top of the stack for the value
        }
    }

    @Override
    public String toString() {
        String base = "STORE " + this.storeAtOffset;
        if (this.id != null) {
            base += " " + id;
        }

        return base;
    }
}
