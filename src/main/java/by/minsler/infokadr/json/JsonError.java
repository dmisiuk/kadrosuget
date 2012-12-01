package by.minsler.infokadr.json;

/**
 * User: dzmitry.misiuk
 * Date: 12/1/12
 * Time: 11:09 AM
 */
public class JsonError {

    private int code;

    private String messsage;

    public JsonError() {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }
}
