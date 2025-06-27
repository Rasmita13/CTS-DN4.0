public class ApiService {
    private RestClient restClient;

    public ApiService(RestClient restClient) {
        this.restClient = restClient;
    }

    public String processApiData() {
        String data = restClient.fetchDataFromApi();
        return "Processed API: " + data;
    }
}

