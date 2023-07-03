package interpreter.loaders;

import interpreter.bytecodes.ByteCode;
import interpreter.virtualmachine.Program;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public final class ByteCodeLoader {
    private String codSourceFileName;
    
    /**
     * Constructs ByteCodeLoader object given a COD source code
     * file name
     * @param fileName name of .cod File to load.
     */
    public ByteCodeLoader(String fileName){
        this.codSourceFileName = fileName;
    }
    
    /**
     * Loads a program from a .cod file.
     * @return a constructed Program Object.
     * @throws InvalidProgramException thrown when 
     * loadCodes fails.
     */
    public Program loadCodes() throws InvalidProgramException {
        Program program; // check if correct
        try (BufferedReader reader = new BufferedReader(new FileReader(this.codSourceFileName))){
            // reader: read's chars
            // buffer reader: read lines, determine if there's more lines to read, more functionality


            String line;
            String[] items;
            String byteCodeName;
            ByteCode bc;
            program = new Program(); // check if correct

            // remove spaces
            for (line = reader.readLine(); reader.ready(); line = reader.readLine()) { // reader.ready() alternative to line != null
                items = line.split("\\s+");
                System.out.println(Arrays.toString(items));
//                byteCodeName = items[0];
//                bc = ByteCode.getNewInstance(byteCodeName, items);
//                program.addByteCode(bc);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        BufferedReader
//        try {
//            FileReader reader = new FileReader(this.codeSourceFileName); //placeholder
//            reader.readLine();
//            reader.close();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            reader.close();
//        }
        return program; // check if we should return program
       //return null;
    }
}
