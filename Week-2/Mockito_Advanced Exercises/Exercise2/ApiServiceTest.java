import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ApiServiceTest {

    @Test
    public void testProcessApiData() {
      
        RestClient mockRestClient = mock(RestClient.class);

      
        when(mockRestClient.fetchDataFromApi()).thenReturn("Mock API Response");

     
        ApiService apiService = new ApiService(mockRestClient);
        String result = apiService.processApiData();

  
        assertEquals("Processed API: Mock API Response", result);
    }
}

