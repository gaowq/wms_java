package com.example.wms_java.service;

import com.example.wms_java.model.Classify;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IClassifyService {

    int insertClassify(Classify classify);

    int updateClassify(Classify classify);

    List<Classify> selectList();

    int deleteClassifyById(int id);
}
