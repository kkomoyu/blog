package com.lwm.project.blog.category.service.impl;

import com.lwm.common.constant.CategoryConstants;
import com.lwm.common.utils.security.ShiroUtils;
import com.lwm.project.blog.category.domain.Category;
import com.lwm.project.blog.category.mapper.CategoryMapper;
import com.lwm.project.blog.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: guya
 * @Date: 2020/3/20 23:30
 * @Description:
 */
@Service
public class CategoryImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> selectCategoryList(Category category) {
        return categoryMapper.selectCategoryList(category);
    }

    @Override
    public int insertCategory(Category category) {
        category.setCreateBy(ShiroUtils.getLoginName());
        return categoryMapper.insertCategory(category);
    }

    @Override
    public Category selectCategoryById(Integer categoryId) {
        return categoryMapper.selectCategoryById(categoryId);
    }

    @Override
    public int updateCategory(Category category) {
        category.setUpdateBy(ShiroUtils.getLoginName());
        return categoryMapper.updateCategory(category);
    }

    @Override
    public int deleteCategoryByIds(Integer[] ids) {
        return categoryMapper.deleteCategoryByIds(ids);
    }

    @Override
    public int updateCategorySupportById(Integer categoryId, String support) {
        return categoryMapper.updateCategorySupportById(categoryId, support);
    }

    @Override
    public String checkCategoryTitleUnique(String title) {
        Category category = categoryMapper.selectCategoryByCategoryTitle(title);
        return category == null ? CategoryConstants.CATEGORY_TITLE_UNIQUE : CategoryConstants.CATEGORY_TITLE_NOT_UNIQUE;
    }

    @Override
    public List<Category> selectSupportCategoryList() {
        return categoryMapper.selectSupportCategoryList();
    }
}