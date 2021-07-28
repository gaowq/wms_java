package com.example.wms_java.service.impl;

import com.example.wms_java.mapper.ClassifyMapper;
import com.example.wms_java.model.Classify;
import com.example.wms_java.service.IClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassifyService implements IClassifyService {
    @Autowired
    private ClassifyMapper classifyMapper;

    @Override
    public int insertClassify(Classify classify) {
        return classifyMapper.insertClassify(classify);
    }

    @Override
    public int updateClassify(Classify classify) {
        return classifyMapper.updateClassify(classify);
    }

    @Override
    public List<Classify> selectList() {
        return classifyMapper.selectList();
    }

    @Override
    public int deleteClassifyById(int id) {
        return classifyMapper.deleteClassifyById(id);
    }
}
