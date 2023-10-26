package com.arong.oj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.arong.oj.common.DeleteDto;
import com.arong.oj.entity.domain.Comment;
import com.arong.oj.entity.request.comment.CommentAddDto;
import com.arong.oj.entity.request.comment.CommentEditDto;
import com.arong.oj.entity.request.comment.CommentQueryDto;
import com.arong.oj.entity.response.CommentResponse;
import com.arong.oj.entity.response.CommentResponse;
import com.arong.oj.error.BusinessException;
import com.arong.oj.util.PageUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.Comment;
import com.arong.oj.service.CommentService;
import com.arong.oj.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.arong.oj.common.Code.SQL_ERROR;

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
        Comment comment = BeanUtil.copyProperties(commentAddDto, Comment.class);
        boolean save = save(comment);
        if(!save) {
            throw new BusinessException(SQL_ERROR);
        }
        return comment.getId();
    }

    @Override
    public boolean deleteComment(DeleteDto deleteDto) {
        return removeById(deleteDto.getId());
    }

    @Override
    public Long editComment(CommentEditDto commentEditDto) {
        Comment comment = BeanUtil.copyProperties(commentEditDto, Comment.class);
        boolean b = updateById(comment);
        if(!b) {
            throw new BusinessException(SQL_ERROR);
        }
        return comment.getId();
    }

    @Override
    public Page<CommentResponse> getCommentList(CommentQueryDto commentQueryDto) {
        QueryWrapper<Comment> commentQueryWrapper = new QueryWrapper<>();
        commentQueryWrapper.lambda()
                .eq(commentQueryDto.getId() != null && commentQueryDto.getId() > 0, Comment::getId, commentQueryDto.getId())
                .eq(commentQueryDto.getUserId() != null && commentQueryDto.getUserId() > 0, Comment::getUserId, commentQueryDto.getUserId())
                .like(commentQueryDto.getContent() != null && commentQueryDto.getContent().equals(""), Comment::getContent, commentQueryDto.getContent())
                .eq(commentQueryDto.getParentCommentId() != null, Comment::getParentCommentId, commentQueryDto.getParentCommentId());

        List<Comment> list = list(commentQueryWrapper);
        List<CommentResponse> collect = list.stream().map(comment -> BeanUtil.copyProperties(comment, CommentResponse.class)).collect(Collectors.toList());
        Page<CommentResponse> pageList = PageUtil.getPageList(collect, commentQueryDto.getCurrentPage(), commentQueryDto.getPageSize());
        return pageList;
    }

    @Override
    public CommentResponse getComment(Long commentId) {
        QueryWrapper<Comment> commentQueryWrapper = new QueryWrapper<>();
        commentQueryWrapper.lambda()
                .eq(commentId != null && commentId > 0, Comment::getId, commentId);
        Comment one = getOne(commentQueryWrapper);
        CommentResponse commentResponse = BeanUtil.copyProperties(one, CommentResponse.class);
        return commentResponse;
    }
}




