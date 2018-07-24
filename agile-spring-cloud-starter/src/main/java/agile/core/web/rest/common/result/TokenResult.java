package agile.core.web.rest.common.result;

public class TokenResult extends Result {

    private String token;

    private Long expires;

    public TokenResult() {
        super();
    }

    public TokenResult(boolean success) {
        super(success);
    }

    public TokenResult(boolean success, String message) {
        super(success, message);
    }

    public TokenResult(boolean success, String token, Long expires) {
        super(success);
        this.setToken(token);
        this.setExpires(expires);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getExpires() {
        return expires;
    }

    public void setExpires(Long expires) {
        this.expires = expires;
    }

    @Override
    public String toString() {
        return "TokenResult [token=" + token + ", expires=" + expires + "]";
    }

}
