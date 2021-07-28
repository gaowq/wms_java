package com.example.wms_java.mapper;

import com.example.wms_java.model.Classify;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassifyMapper {
    List<Classify> selectList();

    int insertClassify(Classify classify);

    int updateClassify(Classify classify);

    int deleteClassifyById(int id);
}
