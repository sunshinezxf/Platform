package platform.sunshine.model;

import platform.sunshine.utils.Encryption;

import java.sql.Timestamp;

/**
 * Created by sunshine on 15/9/20.
 */
public class Deal {
    private String dealId;
    private Reader reader;
    private Article article;
    private int dealPayment;
    private boolean dealStatus;
    private Timestamp createAt;
    private String clientIp;

    public Deal() {
        reader = new Reader();
        article = new Article();
        this.createAt = new Timestamp(System.currentTimeMillis());
    }

    public Deal(String readerWechat, String articleId) {
        this();
        this.reader.setReaderWechat(readerWechat);
        this.article.setArticleId(articleId);
        this.dealId = Encryption.md5(readerWechat + articleId + createAt);
    }

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getDealPayment() {
        return dealPayment;
    }

    public void setDealPayment(int dealPayment) {
        this.dealPayment = dealPayment;
    }

    public boolean isDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(boolean dealStatus) {
        this.dealStatus = dealStatus;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }
}
