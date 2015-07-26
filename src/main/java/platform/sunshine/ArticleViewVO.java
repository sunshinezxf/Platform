package platform.sunshine;

import platform.sunshine.model.Article;
import platform.sunshine.model.ArticlePaymentStatus;

/**
 * Created by sunshine on 15/7/26.
 */
public class ArticleViewVO {
    private ArticlePaymentStatus paymentStatus;
    private Article article;

    public ArticlePaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(ArticlePaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
