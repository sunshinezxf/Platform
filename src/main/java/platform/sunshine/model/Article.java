package platform.sunshine.model;

import platform.sunshine.form.ArticleForm;

import java.sql.Timestamp;

/**
 * Created by sunshine on 15/7/26.
 */
public class Article {
    private String articleId;
    private String title;
    private String author;
    private String guidance;
    private String content;
    private Timestamp createAt;

    public Article() {
        createAt = new Timestamp(System.currentTimeMillis());
    }

    public Article(String title, String author, String guidance, String content) {
        this();
        this.title = title;
        this.author = author;
        this.guidance = guidance.replaceAll("<img", "</p><p><img style=\"width: 100%\"").replaceAll("<p></p>", "");
        this.content = content.replaceAll("<img", "</p><p><img style=\"width: 100%\"").replaceAll("<p></p>", "");
    }

    public Article(ArticleForm form) {
        this(form.getTitle(), form.getAuthor(), form.getGuidance(), form.getContent());
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGuidance() {
        return guidance;
    }

    public void setGuidance(String guidance) {
        this.guidance = guidance;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }
}
