package com.personal.dao.mapper;

import com.personal.dao.model.HkAppUserConfig;

public interface HkAppUserConfigMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(HkAppUserConfig record);

    int insertSelective(HkAppUserConfig record);

    HkAppUserConfig selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(HkAppUserConfig record);

    int updateByPrimaryKey(HkAppUserConfig record);
}