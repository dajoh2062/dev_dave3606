package a_exam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


class FileReader {
    private FileInputStream fileDescriptor;

    public FileReader(String filePath) throws FileNotFoundException{
        fileDescriptor = new FileInputStream(filePath);
    }

    public String readAll() throws IOException{
        byte[] bytes = fileDescriptor.readAllBytes();
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public void finish() throws IOException{
        fileDescriptor.close();
    }
} 


class AutoCloseableFileReader implements AutoCloseable {
    private final FileReader fileReader;

    public AutoCloseableFileReader(FileReader fileReader){
        this.fileReader = fileReader;
    }

    @Override
    public void close() throws IOException{
        fileReader.finish();
    }
}

class AutoCloseableFileReaderV2 implements AutoCloseable {
    private final FileReader fileReader;

    public AutoCloseableFileReaderV2(FileReader fileReader){
        this.fileReader = fileReader;
    }

    public AutoCloseableFileReaderV2(String filePath)throws IOException{
        this(new FileReader(filePath));

    }
    
    public String readAll() throws IOException{
        return fileReader.readAll();
    }



    @Override
    public void close() throws IOException{
        fileReader.finish();
    }
}

public class AdapterPattern {
    public static void main(String[] args) {

        // V1
        try {
            FileReader reader = new FileReader("test.txt");
            try (AutoCloseableFileReader acfr = new AutoCloseableFileReader(reader)) {
                String content = reader.readAll();
                System.out.println(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // V2
        try (AutoCloseableFileReaderV2 reader = new AutoCloseableFileReaderV2("test.txt")) {
            String content = reader.readAll();
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
}
