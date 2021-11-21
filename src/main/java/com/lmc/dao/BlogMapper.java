package com.lmc.dao;

import com.lmc.pojo.Blog;
import com.lmc.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogMapper {

    //查询所有的QueryBlog
    List<QueryBlog> getAllQueryBlog();

    //保存blog
    int addBlog(Blog blog);

    //保存两表关系
    int saveBlogAndTag(BlogAndTag blogAndTag);

    //三条件搜索
    List<QueryBlog> searchByTitleOrTypeOrRecommend(SearchBlog searchBlog);

    //删除blog,by id
    int deleteBlogById(Long id);

    //删除blog和type的关系by blogid
    int deleteBlogAndTypeById(Long id);

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
