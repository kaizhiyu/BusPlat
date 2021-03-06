package com.zhiyin.dbs.module.community.service;

import com.github.pagehelper.PageInfo;
import com.zhiyin.dbs.module.common.service.IBaseService;
import com.zhiyin.dbs.module.community.entity.TopicInfo;
import com.zhiyin.dbs.module.community.entity.TopicThumb;

import java.util.List;

/**
 * Created by hg on 2016/7/11.
 */
public interface ITopicThumbService extends IBaseService<TopicThumb> {

    //TODO 并发更新有问题，需要采用redis
    Integer updateThumb(Long topicId, Long userId);

    TopicThumb selectByTopicUser(Long topicId, Long userId);

    Boolean selectIsThumb(Long topicId, Long userId);

    public PageInfo<TopicThumb> selectThumbers(Long topicId, PageInfo pageInfo);
//    public List<Long> selectLatestThumbers(Long topicId);

}
