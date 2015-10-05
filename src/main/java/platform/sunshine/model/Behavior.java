package platform.sunshine.model;

import java.sql.Timestamp;

/**
 * Created by sunshine on 15/10/5.
 */
public class Behavior {
    private String behaviourId;
    private String articleId;
    private String wechat;
    private String operation;
    private String status;
    private Timestamp createAt;

    public Behav

    public String getBehaviourId() {
        return behaviourId;
    }

    public void setBehaviourId(String behaviourId) {
        this.behaviourId = behaviourId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
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

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }
}
