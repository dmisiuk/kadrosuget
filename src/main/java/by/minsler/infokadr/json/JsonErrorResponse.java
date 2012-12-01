package by.minsler.infokadr.json;

/**
 * User: dzmitry.misiuk
 * Date: 12/1/12
 * Time: 11:09 AM
 */
public class JsonErrorResponse {

    private static String jsonrpc = "2.0";

    private JsonError error;

    private static String id = null;

    public JsonErrorResponse() {

    }

    public JsonErrorResponse(JsonError error) {
        this.error = error;
    }

    public static String getJsonrpc() {
        return jsonrpc;
    }

    public static void setJsonrpc(String jsonrpc) {
        JsonErrorResponse.jsonrpc = jsonrpc;
    }

    public JsonError getError() {
        return error;
    }

    public void setError(JsonError error) {
        this.error = error;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        JsonErrorResponse.id = id;
    }
}
