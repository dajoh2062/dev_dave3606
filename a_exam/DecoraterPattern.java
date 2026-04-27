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

class FileReaderLoggingDecorator{
    private final String filePath;
    private final FileReader fileReader;

    public FileReaderLoggingDecorator(String filePath) throws FileNotFoundException {
        System.out.println("New fileReader created");
        this.filePath = filePath;
        this.fileReader = new FileReader(filePath);
    }

    public String readAll() throws IOException{
        String result = fileReader.readAll();
        System.out.println("Read" + filePath);
        return result;
    }

    public void finish() throws IOException {
        fileReader.finish();
        System.out.println("Closed " + filePath);
    }


}

class AutoCloseableLoggingDecorator implements AutoCloseable {
    private final AutoCloseable decorated;

    public AutoCloseableLoggingDecorator(AutoCloseable decorated) {
        this.decorated = decorated;
    }

    @Override
    public void close() throws Exception {
        decorated.close();
        System.out.println("Closed the resource");
    }
}


public class DecoraterPattern {
    
}
