package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class LitCode implements ByteCode { // LIT has the easiest dump
    private String id; // variable name
    private int valueToPush; // value assigned to the id

    // value can be pushed to run time stack without an identifier/variable name

    // not storing args because it is a waste of memory D:<
    public LitCode(String[] args) { // places literal integer in run time stack
        // args[0] = ByteCode type name
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
            base += " " + this.id + "\tint " + this.id;
        }
        return base;
    }

//    public static void main(String args[]) {
//        String[] x = {"LIT", "1", "variableName"};
//        LitCode c = new LitCode(x);
//        System.out.println(c);
//
//        x = new String[] {"LIT", "1"};
//        c = new LitCode(x);
//        System.out.println(c);
//    }
    
    /*
    expected output:
    LIT 1 variableName	int variableName
    LIT 1
     */
}
