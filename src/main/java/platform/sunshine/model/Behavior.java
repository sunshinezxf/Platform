package platform.sunshine.model;

import platform.sunshine.form.OperationForm;
import platform.sunshine.utils.Encryption;

import java.sql.Timestamp;

/**
 * Created by sunshine on 15/10/5.
 */
public class Behavior {
    private String behaviourId;
    private String articleId;
    private String wechat;
    private String clientIp;
    private String operation;
    private String status;
    private Timestamp createAt;

    public Behavior() {
        this.createAt = new Timestamp(System.currentTimeMillis());
    }

    public Behavior(OperationForm form, String clientIp) {
        this();
        this.articleId = form.getArticleId();
        this.wechat = form.getWgateid();
        this.clientIp = clientIp;
        this.operation = form.getOperation();
        this.status = form.getStatus();
        this.behaviourId = Encryption.md5(wechat + articleId + createAt);
    }

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

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
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
