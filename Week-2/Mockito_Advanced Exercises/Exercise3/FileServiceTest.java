import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileServiceTest {

    @Test
    public void testServiceWithMockFileIO() {
        // Step 1: Create mocks
        FileReader mockFileReader = mock(FileReader.class);
        FileWriter mockFileWriter = mock(FileWriter.class);

        // Step 2: Stub the read method
        when(mockFileReader.read()).thenReturn("Mock File Content");

        // Step 3: Create service and test
        FileService fileService = new FileService(mockFileReader, mockFileWriter);
        String result = fileService.processFile();

        // Step 4: Verify the result
        assertEquals("Processed: Mock File Content", result);

        // Step 5: Verify that write was called correctly
        verify(mockFileWriter).write("Processed: Mock File Content");
    }
}

