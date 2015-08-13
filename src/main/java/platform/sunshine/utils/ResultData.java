package platform.sunshine.utils;

/**
 * Created by sunshine on 15/7/27.
 */
public class ResultData {
    private ResposeCode resposeCode;
    private Object data;
    private String description;

    public ResultData() {
        resposeCode = ResposeCode.RESPONSE_OK;
    }

    public ResposeCode getResposeCode() {
        return resposeCode;
    }

    public void setResposeCode(ResposeCode resposeCode) {
        this.resposeCode = resposeCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
