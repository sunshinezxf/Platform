package platform.sunshine.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import platform.sunshine.dao.ArticleDao;
import platform.sunshine.model.Article;
import platform.sunshine.utils.BaseDao;
import platform.sunshine.utils.ResponseCode;
import platform.sunshine.utils.ResultData;

/**
 * Created by sunshine on 15/7/27.
 */
public class ArticleDaoImpl extends BaseDao implements ArticleDao {
    private Logger logger = LoggerFactory.getLogger(ArticleDaoImpl.class);

    @Override
    public ResultData insertArticle(Article article) {
        ResultData result = new ResultData();
        try {
            int row = sqlSession.insert("insertArticle", article);
            if (row > 0) {

            } else {
                result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        } finally {
            return result;
        }
    }
}
