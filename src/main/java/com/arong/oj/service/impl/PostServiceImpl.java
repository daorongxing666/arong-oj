package com.arong.oj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.arong.oj.common.DeleteDto;
import com.arong.oj.entity.domain.Post;
import com.arong.oj.entity.request.post.PostEditDto;
import com.arong.oj.entity.request.post.PostPublishDto;
import com.arong.oj.entity.request.post.PostQueryDto;
import com.arong.oj.entity.response.PostResponse;
import com.arong.oj.entity.response.PostResponse;
import com.arong.oj.error.BusinessException;
import com.arong.oj.service.PostService;
import com.arong.oj.util.PageUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.Post;
import com.arong.oj.mapper.PostMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.arong.oj.common.Code.SQL_ERROR;

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
        Post post = BeanUtil.copyProperties(postPublishDto, Post.class);
        boolean save = save(post);
        if(!save) {
            throw new BusinessException(SQL_ERROR);
        }
        return post.getId();
    }

    @Override
    public boolean deletePost(DeleteDto deleteDto) {
        return removeById(deleteDto.getId());
    }

    @Override
    public Long editPost(PostEditDto postEditDto) {
        Post post = BeanUtil.copyProperties(postEditDto, Post.class);
        boolean b = updateById(post);
        if(!b) {
            throw new BusinessException(SQL_ERROR);
        }
        return post.getId();
    }

    @Override
    public Page<PostResponse> getPostList(PostQueryDto postQueryDto) {
        QueryWrapper<Post> postQueryWrapper = new QueryWrapper<>();
        postQueryWrapper.lambda()
                .eq(postQueryDto.getId() != null && postQueryDto.getId() > 0, Post::getId, postQueryDto.getId())
                .eq(postQueryDto.getUserId() != null && postQueryDto.getUserId() > 0, Post::getUserId, postQueryDto.getUserId())
                .like(postQueryDto.getTitle() != null && postQueryDto.getTitle().equals(""), Post::getTitle, postQueryDto.getTitle())
                .like(postQueryDto.getContent() != null && postQueryDto.getContent().equals(""), Post::getContent, postQueryDto.getContent())
;
        List<Post> list = list(postQueryWrapper);
        List<PostResponse> collect = list.stream().map(post -> BeanUtil.copyProperties(post, PostResponse.class)).collect(Collectors.toList());
        Page<PostResponse> pageList = PageUtil.getPageList(collect, postQueryDto.getCurrentPage(), postQueryDto.getPageSize());
        return pageList;
    }

    @Override
    public PostResponse getPost(Long postId) {
        QueryWrapper<Post> postQueryWrapper = new QueryWrapper<>();
        postQueryWrapper.lambda()
                .eq(postId != null && postId > 0, Post::getId, postId);
        Post one = getOne(postQueryWrapper);
        PostResponse postResponse = BeanUtil.copyProperties(one, PostResponse.class);
        return postResponse;
    }
}




