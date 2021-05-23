package com.example.service.Imp;

import com.example.mapper.TagMapper;
import com.example.pojo.Tag;
import com.example.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ Author     ：zhu
 * @ Date       ：Created in 20:33 2021/5/23
 * @ Description：标签业务接口实现
 */
@Service
@Transactional
public class TagServiceImp implements TagService {

    @Autowired
    private TagMapper tagMapper;

    /**
     * 查询所有标签
     * @return
     */
    @Override
    public List<Tag> getAllTag() {
        return tagMapper.getAllTag();
    }

    /**
     * 查询标签名称
     * @param name
     * @return
     */
    @Override
    public Tag getTagByName(String name) {
        return tagMapper.getTagByName(name);
    }

    /**
     *添加标签
     * @param tag
     * @return
     */
    @Override
    public int insert(Tag tag) {
        return tagMapper.insert(tag);
    }

    /**
     * 依据id查询标签记录
     * @param id
     * @return
     */
    @Override
    public Tag selectByPrimaryKey(Long id) {
        return tagMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateTag(Tag tag) {
        return tagMapper.updateByPrimaryKeySelective(tag);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return tagMapper.deleteByPrimaryKey(id);
    }
}
