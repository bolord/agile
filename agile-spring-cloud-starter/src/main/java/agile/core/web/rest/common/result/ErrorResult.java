package agile.core.web.rest.common.result;

public class ErrorResult extends Result {

    private boolean error = true;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

}
