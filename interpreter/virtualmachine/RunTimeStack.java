package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class RunTimeStack {

    private List<Integer> runTimeStack; // stores local variables, arguments, and temporary storage
    // list because all variables must be accessible
    private Stack<Integer> framePointer; // stores index at the beginning of frames

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial frame pointer value, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public String dump() {
        return null; //placeholder
    }

    public int peek() { // return top of runtime stack
        return runTimeStack.get(runTimeStack.size() - 1); // last (top) element in list
    }

    public int push(int i) {
        runTimeStack.add(i); // adds element to end of list
        return i;
    }

    public int pop() {
        int poppedValue = runTimeStack.get(runTimeStack.size() - 1);
        runTimeStack.remove(runTimeStack.size() - 1);
        return poppedValue;

//        if (!runTimeStack.isEmpty()) { must assume program is correct
//
//        }
    }

    public int store ( int offsetFromFramePointer ) { // stores value popped in runTimeStack
        int toBeStored = pop();
        runTimeStack.set(offsetFromFramePointer, toBeStored);
        return toBeStored;
    }
}
