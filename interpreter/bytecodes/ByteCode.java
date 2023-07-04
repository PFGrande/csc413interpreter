package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public interface ByteCode {
    static ByteCode getNewInstance(String type, String[] args) {
        // option shift enter, for new class

        /*ByteCode newCode*/
        return switch (type) {
            case "LIT" -> new LitCode(args);
                //public class litcode implements bytecode
            case "HALT" -> new HaltCode(args);
            default -> throw new IllegalArgumentException();
        };

//        return newCode;
    }

    void execute(VirtualMachine vm);


}

// pop bytecode should not lead to crash if given a larger number than contained in the stack