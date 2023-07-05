package interpreter.virtualmachine;

import interpreter.bytecodes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Program {

    private List<ByteCode> program;
    private HashMap<String, Integer> labelAddresses = new HashMap<String, Integer>();// hashmap stores the labels and their addresses

    /**
     * Instantiates a program object using an
     * ArrayList
     */
    public Program() {

    }

    /**
     * Gets the size of the current program.
     * @return size of program
     */
    public int getSize() {
        return program.size();
    }

    /**
     * Grabs an instance of a bytecode at an index.
     * @param programCounter index of bytecode to get.
     * @return a bytecode.
     */
    public ByteCode getCode(int programCounter) {
        return program.get(programCounter);
    }

    /**
     * Adds a bytecode instance to the Program List.
     * @param c bytecode to be added
     */
    public void addByteCode(ByteCode c) {
        program.add(c); // adds bytecode to arraylist
    }

    /**
     * Makes multiple passes through the program ArrayList resolving
     * addrss for Goto,Call and FalseBranch bytecodes. These bytecodes
     * can only jump to Label codes that have a matching label value.
     * HINT: make note of what type of data-structure ByteCodes are stored in.
     * **** METHOD SIGNATURE CANNOT BE CAHNGED *****
     */
    public void resolveAddress() {
        String label;
        int labelAddress;
        for(ByteCode code : program) {


            if (code instanceof LabelCode) {
                label = ((LabelCode) code).getLabel();
                labelAddress = program.indexOf(code);

                labelAddresses.put(label, labelAddress);
            }

        }
    }
}