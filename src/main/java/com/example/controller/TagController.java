package com.example.controller;

import com.example.pojo.Tag;
import com.example.service.TagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @ Author     ：zhu
 * @ Date       ：Created in 20:31 2021/5/23
 * @ Description：标签控制器
 */
@Controller
public class TagController {

    @Autowired
    private TagService tagService;

    /*
     //当前页
    private int pageNum;
    //每页的数量
    private int pageSize;
    //当前页的数量
    private int size;
    //由于startRow和endRow不常用，这里说个具体的用法
    //可以在页面中"显示startRow到endRow 共size条数据"
    //当前页面第一个元素在数据库中的行号
    private int startRow;
    //当前页面最后一个元素在数据库中的行号
    private int endRow;
    //总记录数
    private long total;
    //总页数
    private int pages;
    //结果集
    private List<T> list;
    //前一页
    private int prePage;
    //下一页
    private int nextPage;
    //是否为第一页
    private boolean isFirstPage;
    //是否为最后一页
    private boolean isLastPage;
    //是否有前一页
    private boolean hasPreviousPage;
    //是否有下一页
    private boolean hasNextPage;
    //导航页码数
    private int navigatePages;
    //所有导航页号
    private int[] navigatepageNums;
    //导航条上的第一页
    private int navigateFirstPage;
    //导航条上的最后一页
    private int navigateLastPage;
     */

    /**
     * 分页
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping(value = "/admin/tags")
    public String tagList(Model model, @RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum){
        //查询5条记录
        // 在查询之前调用，传入pageNum默认值是1，pageSize是5，意思是从第1页开始，每页显示5条记录。
        PageHelper.startPage(pageNum,5);
        //封装查询的数据List查询
        List<Tag> allTag = tagService.getAllTag();
        //使用PageInfo包装查询后的结果，只需要将PageInfo交给页面就行。
        PageInfo<Tag> pageInfo = new PageInfo<>(allTag);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/adtag";
    }

    /**
     * 跳转到新增页面
     * @param model
     * @return
     */
    @GetMapping(value = "/tags/input")
    public String addTag(Model model){
        model.addAttribute("tag",new Tag());
        return "admin/taginput";
    }

    /**
     * 增加标签
     * @param tag
     * @param result
     * @param attributes
     * @return
     */
    @PostMapping(value = "/admin/tags")
    public String addTags(Tag tag,
                          BindingResult result,
                          RedirectAttributes attributes){
        if (result.hasErrors()){
            return "admin/taginput";
        }
        if (tagService.getTagByName(tag.getName()) != null){
            attributes.addFlashAttribute("msg","标签名称已存在！请重新输入！");
            return "redirect:/tags/input";
        }
        int i = tagService.insert(tag);
        if (i != 0){
            attributes.addFlashAttribute("message","标签添加成功！");
        } else {
            attributes.addFlashAttribute("message","标签添加失败！");
        }
        return "redirect:/admin/tags";
    }

    /**
     * 查询修改标签记录
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "/admin/tags/{id}/input")
    public String editTag(@PathVariable Long id, Model model){
        model.addAttribute("tag",tagService.selectByPrimaryKey(id));
        return "admin/taginput";
    }

    @PostMapping(value = "/admin/tags/{id}")
    public String editTags(@PathVariable Long id,
                           Tag tag,
                           BindingResult result,
                           RedirectAttributes attributes){

        if (result.hasErrors()){
            return "admin/taginput";
        }
        if (tagService.getTagByName(tag.getName()) != null){
            attributes.addFlashAttribute("msg","标签名称已存在！请重新输入！");
            return "redirect:/tags/input";
        }
        int i = tagService.updateTag(tag);
        if (i != 0){
            attributes.addFlashAttribute("message","标签修改成功！");
        } else {
            attributes.addFlashAttribute("message","标签修改失败！");
        }
        return "redirect:/admin/tags";
    }

    @GetMapping(value = "/admin/tags/{id}/delete")
    public String deleteTag(@PathVariable Long id,
                            RedirectAttributes attributes){
        int i = tagService.deleteByPrimaryKey(id);
        if (i != 0){
            attributes.addFlashAttribute("message","标签删除成功！");
        }else {
            attributes.addFlashAttribute("message","标签删除失败！");
        }
        return "redirect:/admin/tags";
    }
}
