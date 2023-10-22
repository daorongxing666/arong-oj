package com.arong.oj.service.impl;

import com.arong.oj.entity.request.post.PostEditDto;
import com.arong.oj.entity.request.post.PostPublishDto;
import com.arong.oj.entity.request.post.PostQueryDto;
import com.arong.oj.entity.response.PostResponse;
import com.arong.oj.service.PostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.Post;
import com.arong.oj.mapper.PostMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author centos7
* @description 针对表【post】的数据库操作Service实现
* @createDate 2023-10-21 15:54:22
*/
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post>
    implements PostService {

    @Override
    public Long publishPost(PostPublishDto postPublishDto) {
        return null;
    }

    @Override
    public boolean deletePost(Long postId) {
        return false;
    }

    @Override
    public Long editPost(PostEditDto postEditDto) {
        return null;
    }

    @Override
    public List<PostResponse> getPostList(PostQueryDto postQueryDto) {
        return null;
    }

    @Override
    public PostResponse getPost(Long postId) {
        return null;
    }
}




