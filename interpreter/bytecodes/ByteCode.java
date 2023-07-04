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
            case "POP" -> new PopCode(args);
            case "FALSEBRANCH" -> new FalseBranchCode(args);
            case "GOTO" -> new GotoCode(args);
            case "STORE" -> new StoreCode(args);
            case "LOAD" -> new LoadCode(args);
            case "ARGS" -> new ArgsCode(args);
            case "CALL" -> new CallCode(args);
            case "RETURN" -> new ReturnCode(args);
            case "BOP" -> new BopCode(args);
            case "READ" -> new ReadCode(args);
            case "WRITE" -> new WriteCode(args);
            case "LABEL" -> new LabelCode(args);
            case "DUMP" -> new DumpCode(args);

            default -> throw new IllegalArgumentException();
        };

//        return newCode;
    }

    void execute(VirtualMachine vm);


}
