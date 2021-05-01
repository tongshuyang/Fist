package cn.litman.fist.mapper;

import cn.litman.fist.entity.Case;

public interface CaseMapper {
    int insert(Case record);

    int insertSelective(Case record);
}