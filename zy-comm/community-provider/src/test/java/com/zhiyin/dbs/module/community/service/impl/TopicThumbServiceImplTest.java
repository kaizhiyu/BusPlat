package com.zhiyin.dbs.module.community.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.zhiyin.dbs.module.community.CommunityProviderApplication;
import com.zhiyin.dbs.module.community.entity.TopicThumb;
import com.zhiyin.dbs.module.community.service.ITopicInfoService;
import com.zhiyin.dbs.module.community.service.ITopicThumbService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wangqinghui on 2016/9/26.
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {CommunityProviderApplication.class})
@WebAppConfiguration
public class TopicThumbServiceImplTest  {

    @Resource
    ITopicInfoService topicInfoService ;
    @Resource
    ITopicThumbService topicThumbService ;

    @Test
    public void testSelectThumbers() throws Exception {

        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(1);
        pageInfo.setPageSize(10);
        PageInfo<TopicThumb> pageResult = topicThumbService.selectThumbers(52042922905600L, pageInfo);

        log.info(JSON.toJSONString(pageResult));
    }


}