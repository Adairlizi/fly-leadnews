package com.fly.apis.article;

import com.fly.model.article.pojos.ApAuthor;
import com.fly.model.common.dtos.ResponseResult;

public interface AuthorControllerApi {

    /**
     * 根据用户id查询作者
     * @param id
     * @return
     */
    public ApAuthor findByUserId(Integer id);

    /**
     * 保存作者
     * @param apAuthor
     * @return
     */
    public ResponseResult save(ApAuthor apAuthor);
}
