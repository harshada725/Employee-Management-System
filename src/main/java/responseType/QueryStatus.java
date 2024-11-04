package responseType;

public class QueryStatus {
    private Boolean status;

    public QueryStatus()
    {

    }
    public QueryStatus(Boolean status) {
        this.status = status;
    }

    public boolean isStatus()
    {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
