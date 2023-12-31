package interpreter.virtualmachine;

import java.util.*;

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
        int endFrame = 0;
        int beginningFrame = 0;
        if (copyPointers.peek() != 0) {
            endFrame = runTimeStack.size()-1;
            beginningFrame = copyPointers.peek();
        }
        runTimeSubLists.add(runTimeStack.subList(beginningFrame, endFrame));

        // adds top frame to the subList

        // adds remaining frames to the list
        for (int i = 0; i < copyPointers.size(); i++) {
            endFrame = copyPointers.pop();
            if (!copyPointers.empty()) {
                beginningFrame = copyPointers.peek();
                runTimeSubLists.add(runTimeStack.subList(beginningFrame, endFrame));
            }


        }


//        while(copyPointers.size() >= 1) { // pop and peek before reaching final element in stack
//            System.out.println(copyPointers.peek());
//            System.out.println(endFrame);
//            System.out.println(beginningFrame);
//            System.out.println("size: " + copyPointers.size());
//
//            System.out.println(copyPointers);
//
//            runTimeSubLists.add(runTimeStack.subList(beginningFrame, endFrame));
//
//            if (copyPointers.size() != 1) {
//                endFrame = copyPointers.pop();
//                beginningFrame = copyPointers.peek();
//            }
//
//        }

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

    public int getRunTimeStackSize() {
        return runTimeStack.size();
    }

    public int peekFrame() {
        return framePointer.peek();
    }
//    public static void main(String[] args) {
//        System.out.println("--- TEST DUMP: ---");
//        RunTimeStack rts = new RunTimeStack();
//        rts.push(1);
//        rts.push(2);
//        rts.push(3);
//        rts.newFrameAt(0);
//        rts.push(4);
//        rts.push(5);
//        rts.push(6);
//        rts.newFrameAt(0);
//        rts.push(7);
//        rts.push(8);
//        System.out.println(rts.dump());
//
//
//    }

    public void printStack() { // for debugging
        System.out.println(runTimeStack);
    }

    public void printFrameStack() { // for debugging
        System.out.println(framePointer);
    }
}
