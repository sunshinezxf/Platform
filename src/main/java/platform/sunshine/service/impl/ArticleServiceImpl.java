package platform.sunshine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import platform.sunshine.dao.ArticleDao;
import platform.sunshine.model.Article;
import platform.sunshine.service.ArticleService;
import platform.sunshine.utils.ResultData;

/**
 * Created by sunshine on 15/7/27.
 */
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Override
    public ResultData createArticle(Article article) {
        ResultData result = new ResultData();
        result = articleDao.save(article);
        return result;
    }
}
