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

    /**
     * 查询分类名称
     * @param name
     * @return
     */
    @Override
    public Type getTypeByName(String name) {
        return typeMapper.getTypeByName(name);
    }

    /**
     * 根据id查询分类
     * @param id
     * @return
     */
    @Override
    public Type selectByPrimaryKey(Long id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改分类名称
     * @param type
     * @return
     */
    @Override
    public int updateByType(Type type) {
        return typeMapper.updateByPrimaryKeySelective(type);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        return typeMapper.deleteByPrimaryKey(id);
    }
}
