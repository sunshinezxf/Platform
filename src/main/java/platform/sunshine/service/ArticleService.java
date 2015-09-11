package platform.sunshine.service;

import platform.sunshine.model.Article;
import platform.sunshine.utils.ResultData;

/**
 * Created by sunshine on 15/7/27.
 */
public interface ArticleService {
    public ResultData createArticle(Article article);

    public ResultData queryArticle(Article article);
}
