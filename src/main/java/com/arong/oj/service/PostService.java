package com.arong.oj.service;

import com.arong.oj.common.DeleteDto;
import com.arong.oj.entity.domain.Post;
import com.arong.oj.entity.request.post.PostEditDto;
import com.arong.oj.entity.request.post.PostPublishDto;
import com.arong.oj.entity.request.post.PostQueryDto;
import com.arong.oj.entity.response.PostResponse;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author centos7
* @description 针对表【post】的数据库操作Service
* @createDate 2023-10-21 15:54:22
*/
public interface PostService extends IService<Post> {

    /**
     * 帖子发布
     * @param postPublishDto 帖子发布请求类
     * @return 帖子id
     */
    public Long publishPost(PostPublishDto postPublishDto);

    /**
     * 删除帖子
     * @param postId 帖子id
     * @return 是否删除成功
     */
    public boolean deletePost(DeleteDto deleteDto);

    /**
     * 帖子编辑
     * @param postEditDto 帖子编辑请求类
     * @return 帖子id
     */
    public Long editPost(PostEditDto postEditDto);

    /**
     * 查询帖子列表
     * @param postQueryDto 帖子列表请求类
     * @return 帖子列表
     */
    public Page<PostResponse> getPostList(PostQueryDto postQueryDto);

    /**
     * 查询单个帖子
     * @param postId 帖子id
     * @return 帖子内容
     */
    public PostResponse getPost(Long postId);
}
