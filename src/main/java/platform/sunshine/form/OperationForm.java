package platform.sunshine.form;

/**
 * Created by sunshine on 15/10/5.
 */
public class OperationForm {
    private String articleId;
    private String wgateid;
    private String operation;
    private String status;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getWgateid() {
        return wgateid;
    }

    public void setWgateid(String wgateid) {
        this.wgateid = wgateid;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
