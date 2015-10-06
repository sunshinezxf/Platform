package platform.sunshine.form;

import platform.sunshine.model.Article;
import platform.sunshine.model.Reader;
import platform.sunshine.utils.CommonValue;

/**
 * Created by sunshine on 15/10/6.
 */
public class ChargeForm {
    private String orderNo;
    private Article article;
    private Reader reader;
    private String channel;
    private int amount;
    private String currency;
    private String subject;
    private String ip;
    private String url;

    public ChargeForm() {
        currency = CommonValue.DEAL_CURRENCY;
    }

    public ChargeForm(String orderNo, Article article, Reader reader, String channel, int amount, String ip, String url) {
        this();
        this.orderNo = orderNo;
        this.article = article;
        this.reader = reader;
        this.channel = channel;
        this.amount = amount;
        this.ip = ip;
        this.url = url;
        this.subject = CommonValue.DEAL_SUBJECT;
    }


    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
