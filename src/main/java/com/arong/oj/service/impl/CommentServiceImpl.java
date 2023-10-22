package com.arong.oj.service.impl;

import com.arong.oj.entity.request.comment.CommentAddDto;
import com.arong.oj.entity.request.comment.CommentEditDto;
import com.arong.oj.entity.request.comment.CommentQueryDto;
import com.arong.oj.entity.response.CommentResponse;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.Comment;
import com.arong.oj.service.CommentService;
import com.arong.oj.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author centos7
* @description 针对表【comment(评论表)】的数据库操作Service实现
* @createDate 2023-10-22 18:57:46
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

    @Override
    public Long publishComment(CommentAddDto commentAddDto) {
        return null;
    }

    @Override
    public boolean deleteComment(Long commentId) {
        return false;
    }

    @Override
    public Long editComment(CommentEditDto commentEditDto) {
        return null;
    }

    @Override
    public List<CommentResponse> getCommentList(CommentQueryDto commentQueryDto) {
        return null;
    }

    @Override
    public CommentResponse getComment(Long commentId) {
        return null;
    }
}




