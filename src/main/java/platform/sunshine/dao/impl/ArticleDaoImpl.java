package platform.sunshine.dao.impl;

import platform.sunshine.dao.ArticleDao;
import platform.sunshine.model.Article;
import platform.sunshine.utils.BaseDao;
import platform.sunshine.utils.ResultData;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunshine on 15/7/27.
 */
public class ArticleDaoImpl extends BaseDao implements ArticleDao {
    @Override
    public ResultData save(Article article) {
        ResultData result = new ResultData();
        Map<String, Object> params = new HashMap<String, Object>();
        int row = sqlSession.insert("", params);
        return result;
    }
}
