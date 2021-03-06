package platform.sunshine.dao;

import platform.sunshine.model.Article;
import platform.sunshine.utils.ResultData;

/**
 * Created by sunshine on 15/7/27.
 */
public interface ArticleDao {
    public ResultData insertArticle(Article article);

    public ResultData queryArticle(Article article);
}
