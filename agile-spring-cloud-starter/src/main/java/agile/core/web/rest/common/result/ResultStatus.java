package agile.core.web.rest.common.result;

public enum ResultStatus {

    FORBIDDEN("100403", "禁止访问"),

    INVALID_TOKEN("100901", "访问令牌已过期");

    private final String code;

    private final String message;

    ResultStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
