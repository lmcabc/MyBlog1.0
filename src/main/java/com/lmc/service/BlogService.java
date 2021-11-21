package com.lmc.service;

import com.lmc.pojo.Blog;
import com.lmc.vo.*;

import java.util.List;

public interface BlogService {

    //查询所有的QueryBlog
    List<QueryBlog> getAllQueryBlog();

    //保存blog
    int addBlog(Blog blog);

    //三条件搜索
    List<QueryBlog> searchByTitleOrTypeOrRecommend(SearchBlog searchBlog);

    void transformRecommend(SearchBlog searchBlog);

    //删除blog,by id
    int deleteBlogById(Long id);

    //根据id查询编辑所需blog
    ShowBlog getShowBlogById(Long id);

    //修改blog
    int updateShowBlog(ShowBlog showBlog);

    //查询所有的firstPageBlog
    List<firstPageBlog> getAllFirstPageBlog();

    //获取所有推荐的blog
    List<RecommendBlog> getRecommendBlog();

    //根据type的id查询blog
    List<firstPageBlog> getAllBlogByTypeId(Long typeId);

    //根据tag的id查询blog
    List<firstPageBlog> getAllBlogByTagId(Long tagId);

    //根据id获取详情blog
    DetailedBlog getDetailedBlog(Long id);

    //搜索
    List<firstPageBlog> getSearchBlog(String query);
}
