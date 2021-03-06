package com.zhiyin.dbs.module.community.mapper;

import com.zhiyin.dbs.module.common.mapper.BaseMapper;
import com.zhiyin.dbs.module.community.entity.TopicInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TopicInfoMapper  extends BaseMapper<TopicInfo> {

    // 查询并排序
    List<TopicInfo> selectByUserId(@Param("userId") Long userId);


    List<TopicInfo> selectByAddrId(@Param("addrId") Long addrId);

    List<TopicInfo> selectByAreaId(@Param("areaId") Long areaId);

    Integer updateIncBrowse(Long id);

    Integer updateIncComment(Long id);

}