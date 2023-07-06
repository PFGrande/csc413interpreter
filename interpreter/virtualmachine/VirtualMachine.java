package interpreter.virtualmachine;

import interpreter.bytecodes.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;

    public VirtualMachine(Program program) {
        this.program = program;
        this.runTimeStack = new RunTimeStack();
        this.returnAddress = new Stack<>();
        this.programCounter = 0;
    }

    public void push(int valueToPush){
        this.runTimeStack.push(valueToPush);
    }

    public void executeProgram() {
        isRunning = true;

        while (isRunning && programCounter < program.getSize()) { // size + 1 because file starts at 1
            ByteCode code = program.getCode(programCounter);
            System.out.println(code); // debugging HALT code
            code.execute(this);
            programCounter++;
        }
        System.out.println(runTimeStack.getRunTimeStackSize()); //debug pop, pop does nothing if value exceeds frame
    }

    public void updateRunStatus(boolean newStatus) {
        isRunning = newStatus;
    }

    // checks if the requested values are accessible from the current frame
    public boolean isWithinFrame(int numberOfRequestedValues) {
        // size of stack - the beginning address of the current frame = the size of the current frame
        // requestedValues are within frame if the current frame contains more or less than the amount requested
        System.out.println(runTimeStack.getRunTimeStackSize() - runTimeStack.peekFrame()); //debugging pop,

        return numberOfRequestedValues <= runTimeStack.getRunTimeStackSize() - runTimeStack.peekFrame();
    }

    public void popRunTimeStack() {
        runTimeStack.pop();
    }

}

