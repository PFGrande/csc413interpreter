package interpreter.virtualmachine;

import interpreter.bytecodes.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;
    private boolean        dumpStatus;

    public VirtualMachine(Program program) {
        this.program = program;
        this.runTimeStack = new RunTimeStack();
        this.returnAddress = new Stack<>();
        this.programCounter = 0;
    }

    public void push(int valueToPush){
        this.runTimeStack.push(valueToPush);
    }

    public void store(int valueToStore) {this.runTimeStack.store(valueToStore);}

    public void load(int offsetFromFramePointer) {
        this.runTimeStack.load(offsetFromFramePointer);
    }

    public void newFrame(int address) {
        this.runTimeStack.newFrameAt(address);
    }

    public void pushReturnAddress() {
        returnAddress.push(programCounter);
    }

    public void returnToAddress() {
        programCounter = returnAddress.pop();
    }

    public void updateDumpStatus(boolean status) {
        dumpStatus = status;
    }

    public void executeProgram() {
        isRunning = true;

        while (isRunning && programCounter < program.getSize()) { // size + 1 because file starts at 1
            ByteCode code = program.getCode(programCounter);
            System.out.println(code); // debugging HALT code prints all he bytecordes being executed
            code.execute(this);
            programCounter++;
            //System.out.println("counter: " + programCounter); // for debug
            //runTimeStack.printStack(); // debug
            //runTimeStack.printFrameStack();
//            if (dumpStatus) {
//                runTimeStack.dump();
//            }

        }
        //System.out.println(runTimeStack.getRunTimeStackSize()); //debug pop, pop does nothing if value exceeds frame
    }

    public void updateRunStatus(boolean newStatus) {
        isRunning = newStatus;
    }

    // checks if the requested values are accessible from the current frame
    public boolean isWithinFrame(int numberOfRequestedValues) {
        // size of stack - the beginning address of the current frame = the size of the current frame
        // requestedValues are within frame if the current frame contains more or less than the amount requested
        //System.out.println(numberOfRequestedValues);
        //System.out.println(runTimeStack.getRunTimeStackSize() - runTimeStack.peekFrame()); //debugging pop,

        return numberOfRequestedValues <= runTimeStack.getRunTimeStackSize() - runTimeStack.peekFrame();
    }

    public int getRunTimeStackSize() {
        return  runTimeStack.getRunTimeStackSize();
    }

    public int getFrameSize() {
        return runTimeStack.getRunTimeStackSize() - runTimeStack.peekFrame();
    }

    public int popRunTimeStack() {
        return runTimeStack.pop();
    }

    public int getLabelAddress(String label) {
        return program.getLabelAddress(label);
    }

    public void jump(int address) { // moves the program's cursor
        programCounter = address-1; // removes the incrementation from the loop before executing
    }
}

