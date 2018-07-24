package agile.common.result;

/**
 * RESTful API 统一数据响应基类
 *
 */
public class Result {

    private boolean success = false;

    private String code;

    private String message;

    private Object data;

    public Result() {
        super();
    }

    public Result(boolean success) {
        super();
        this.success = success;
    }

    public Result(boolean success, Object data) {
        super();
        this.success = success;
        this.data = data;
    }

    public Result(boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }

    public Result(boolean success, String code, String message) {
        super();
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
