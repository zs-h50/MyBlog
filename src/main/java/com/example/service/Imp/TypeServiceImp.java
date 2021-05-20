package com.example.service.Imp;

import com.example.mapper.TypeMapper;
import com.example.pojo.Type;
import com.example.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ Author     ：zhu
 * @ Date       ：Created in 18:17 2021/5/18
 * @ Description：
 */
@Service
@Transactional
public class TypeServiceImp implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    /**
     * 分页
     * @return
     */
    @Override
    public List<Type> getAllType() {
        return typeMapper.getAllType();
    }

    /**
     * 增加分类
     * @param record
     * @return
     */
    @Override
    public int insert(Type record) {
        return typeMapper.insert(record);
    }
}
