package com.fly.model.wemedia.vo;


import com.fly.model.wemedia.pojos.WmNews;
import lombok.Data;

@Data
public class WmNewsVo extends WmNews {

    /**
     * 文章作者名称
     */
    private String authorName;
}
