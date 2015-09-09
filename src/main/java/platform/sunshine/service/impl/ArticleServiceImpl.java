package platform.sunshine.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import platform.sunshine.dao.ArticleDao;
import platform.sunshine.model.Article;
import platform.sunshine.service.ArticleService;
import platform.sunshine.utils.ResponseCode;
import platform.sunshine.utils.ResultData;

/**
 * Created by sunshine on 15/7/27.
 */
public class ArticleServiceImpl implements ArticleService {
    private Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Autowired
    private ArticleDao articleDao;

    @Override
    public ResultData createArticle(Article article) {
        ResultData result = new ResultData();
        ResultData data = articleDao.insertArticle(article);
        if (data.getResponseCode() == ResponseCode.RESPONSE_OK) {

        }
        return result;
    }
}
