package platform.sunshine.form;

import javax.validation.constraints.Size;

/**
 * Created by sunshine on 15/7/24.
 */
public class ArticleForm {
    @Size(min = 1, max = 64, message = "输入标题长度在1到64个字符")
    private String title;

    private String author;

    @Size(min = 1, message = "输入导读不得为空白")
    private String guidance;

    @Size(min = 1, message = "输入文章内容不得为空白")
    private String content;

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
}
