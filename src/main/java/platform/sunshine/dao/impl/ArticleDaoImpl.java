package platform.sunshine.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    @Override
    public ResultData insertArticle(Article article) {
        ResultData result = new ResultData();
        try {
            sqlSession.insert("article.insertArticle", article);
        } catch (Exception e) {
            logger.debug(e.getMessage());
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        } finally {
            return result;
        }
    }

    @Override
    public ResultData queryArticle(Article article) {
        ResultData result = new ResultData();
        try {
            Article vo = sqlSession.selectOne("article.queryArticle", article);
            if (vo == null) {
                result.setResponseCode(ResponseCode.RESPONSE_NULL);
            } else {
                result.setData(vo);
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
