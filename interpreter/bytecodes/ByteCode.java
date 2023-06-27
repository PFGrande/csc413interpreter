package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public interface ByteCode {
    static ByteCode getNewInstance(String type, String[] args) {
        // option shift enter, for new class
        switch (type) {
            case "LIT" -> new LitCode(args);
                //public class litcode implements bytecode
            case "HALT" -> new HaltCode(args);
            default -> throw new IllegalArgumentException();
        }
    }

    void execute(VirtualMachine vm);


}
