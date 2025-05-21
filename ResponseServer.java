public class ResponseServer{
    private String response;

    public ResponseServer() {
    }

    public ResponseServer(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "ResponseServer [response=" + response + "]";
    }
} 