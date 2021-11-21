package com.lmc.service;

import com.lmc.NotFoundException;
import com.lmc.dao.BlogMapper;
import com.lmc.pojo.Blog;
import com.lmc.pojo.Tag;
import com.lmc.utils.MarkdownUtils;
import com.lmc.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public List<QueryBlog> getAllQueryBlog() {
        return blogMapper.getAllQueryBlog();
    }

    @Transactional
    @Override
    public int addBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        //将标签的数据存到t_blogs_tag
        List<Tag> tags =blog.getTags();
        BlogAndTag blogAndTag = null;
        for (Tag tag : tags) {
            blogAndTag = new BlogAndTag(tag.getId(), blog.getId());
            blogMapper.saveBlogAndTag(blogAndTag);
        }
        return blogMapper.addBlog(blog);
    }

    @Override
    public List<QueryBlog> searchByTitleOrTypeOrRecommend(SearchBlog searchBlog) {
        return blogMapper.searchByTitleOrTypeOrRecommend(searchBlog);
    }

    @Transactional
    @Override
    public void transformRecommend(SearchBlog searchBlog) {
        if (!"".equals(searchBlog.getRecommend()) && null != searchBlog.getRecommend()){
            searchBlog.setRecommend2(1);
        }
    }


    @Transactional
    @Override
    public int deleteBlogById(Long id) {
        blogMapper.deleteBlogById(id);
        blogMapper.deleteBlogAndTypeById(id);
        return 1;
    }

    @Override
    public ShowBlog getShowBlogById(Long id) {
        return blogMapper.getShowBlogById(id);
    }

    @Transactional
    @Override
    public int updateShowBlog(ShowBlog showBlog) {
        showBlog.setUpdateTime(new Date());
        return blogMapper.updateShowBlog(showBlog);
    }

    @Override
    public List<firstPageBlog> getAllFirstPageBlog() {
        return blogMapper.getAllFirstPageBlog();
    }

    @Override
    public List<RecommendBlog> getRecommendBlog() {
        return blogMapper.getRecommendBlog();
    }

    @Override
    public List<firstPageBlog> getAllBlogByTypeId(Long typeId) {
        return blogMapper.getAllBlogByTypeId(typeId);
    }

    @Override
    public List<firstPageBlog> getAllBlogByTagId(Long tagId) {
        return blogMapper.getAllBlogByTagId(tagId);
    }

    @Override
    public DetailedBlog getDetailedBlog(Long id) {
        DetailedBlog detailedBlog = blogMapper.getDetailedBlog(id);
        if (detailedBlog == null){
            throw new NotFoundException("该博客不存在!!");
        }
        String content = detailedBlog.getContent();
        detailedBlog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        return detailedBlog;
    }

    @Override
    public List<firstPageBlog> getSearchBlog(String query) {
        return blogMapper.getSearchBlog(query);
    }
}
