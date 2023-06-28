package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class LitCode implements ByteCode { // LIT has the easiest dump
    private String id;
    private int valueToPush;
    // not storing args because it is a waste of memory D:<
    public LitCode(String[] args) { // places literal integer in run time stack
        this.valueToPush = Integer.parseInt(args[1]);
        if(args.length == 3) {
            this.id = args[2];
        }
        // where to push to the stack

    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.push(valueToPush);
    }

    @Override
    public String toString() {
        String base = "LIT " + this.valueToPush;
        if (this.id != null) {
            base += " " + this.id + "\t int " + this.id;
        }
        return base;


//        if (this.id == null) { // java doesn't convert null to false
//            return false;
//        }

//        return
    }

}
