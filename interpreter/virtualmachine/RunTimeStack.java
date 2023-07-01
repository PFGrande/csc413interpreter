package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class RunTimeStack { // encountered error due to apple silicon 

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
        Stack<Integer> copyPointers = framePointer;
        List<List<Integer>> runTimeSubLists = new ArrayList<>();


        int endFrame = runTimeStack.size()-1;
        int beginningFrame = copyPointers.peek();

        do { // pop and peek before reaching final element in stack
            runTimeSubLists.add(runTimeStack.subList(beginningFrame, endFrame));
            endFrame = copyPointers.pop();
            beginningFrame = copyPointers.peek();
            System.out.println(beginningFrame);
        } while(copyPointers.size() >= 0);

        String outputFrames = "";

        for (int i = runTimeSubLists.size()-1; i >= 0; i--) {
            outputFrames = outputFrames + runTimeSubLists.get(i).toString();
        }

        return outputFrames; //placeholder
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

    // offset = # of slots above current frame marker
    // frame markers = points to first index on new frame, does NOT take up a slot on the run time stack

    public int store(int offsetFromFramePointer) { // stores value popped in runTimeStack
        int toBeStored = pop();
        runTimeStack.set(offsetFromFramePointer + framePointer.peek(), toBeStored); // current frame + offset = position in current frame
        return toBeStored;
    }

    public int load(int offsetFromFramePointer) {
        return push(runTimeStack.get(offsetFromFramePointer + framePointer.peek())); // offset from the frame pointer
    }

    // offsetFromTopOfRunStack = slots down from the top of the run time stack, determines what values are part of a frame.
    // From my understanding: the runTimeStack has values and the framePointerStack keeps track of the index new frames start
    // because new values are inserted at the end of the runTimeStack, the offsetFromTopOfRunStack determines which new values
    // are part of a new frame
    public void newFrameAt(int offsetFromTopOfRunStack) {
        framePointer.push((runTimeStack.size()-1) - offsetFromTopOfRunStack);
    }

    public void popFrame () {
        framePointer.pop();
    }

    public static void main(String[] args) {
        RunTimeStack rts = new RunTimeStack();
        rts.push(1);
        rts.push(2);
        rts.push(3);
        rts.newFrameAt(0);
        rts.push(4);
        rts.push(5);
        rts.push(6);
        rts.newFrameAt(0);
        rts.push(7);
        rts.push(8);
        System.out.println(rts.dump());


    }


}
