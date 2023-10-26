package com.arong.oj.service;

import com.arong.oj.common.DeleteDto;
import com.arong.oj.entity.domain.Comment;
import com.arong.oj.entity.request.comment.CommentAddDto;
import com.arong.oj.entity.request.comment.CommentEditDto;
import com.arong.oj.entity.request.comment.CommentQueryDto;
import com.arong.oj.entity.response.CommentResponse;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author centos7
* @description 针对表【comment(评论表)】的数据库操作Service
* @createDate 2023-10-22 18:57:46
*/
public interface CommentService extends IService<Comment> {
    /**
     * 评论发布
     * @param commentAddDto 评论发布请求类
     * @return 评论id
     */
    public Long publishComment(CommentAddDto commentAddDto);

    /**
     * 删除评论
     * @param commentId 评论id
     * @return 是否删除成功
     */
    public boolean deleteComment(DeleteDto deleteDto);

    /**
     * 评论编辑
     * @param commentEditDto 评论编辑请求类
     * @return 评论id
     */
    public Long editComment(CommentEditDto commentEditDto);

    /**
     * 查询评论列表
     * @param commentQueryDto 评论列表请求类
     * @return 评论列表
     */
    public Page<CommentResponse> getCommentList(CommentQueryDto commentQueryDto);

    /**
     * 查询单个评论
     * @param commentId 评论id
     * @return 评论内容
     */
    public CommentResponse getComment(Long commentId);
}
