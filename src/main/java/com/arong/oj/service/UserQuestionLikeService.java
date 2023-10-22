package com.arong.oj.service;

import com.arong.oj.entity.domain.UserQuestionLike;
import com.arong.oj.entity.request.userQuestionLike.UserQuestionLikeAddDto;
import com.arong.oj.entity.request.userQuestionLike.UserQuestionLikeQueryDto;
import com.arong.oj.entity.response.UserQuestionLikeResponse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author centos7
* @description 针对表【user_question_like】的数据库操作Service
* @createDate 2023-10-21 15:54:49
*/
public interface UserQuestionLikeService extends IService<UserQuestionLike> {
    /**
     * 用户题目收藏发布
     * @param userQuestionLikeAddDto 用户题目收藏发布请求类
     * @return 用户题目收藏id
     */
    public Long publishUserQuestionLike(UserQuestionLikeAddDto userQuestionLikeAddDto);

    /**
     * 删除用户题目收藏
     * @param userQuestionLikeId 用户题目收藏id
     * @return 是否删除成功
     */
    public boolean deleteUserQuestionLike(Long userQuestionLikeId);
    
    /**
     * 查询用户题目收藏列表
     * @param userQuestionLikeQueryDto 用户题目收藏列表请求类
     * @return 用户题目收藏列表
     */
    public List<UserQuestionLikeResponse> getUserQuestionLikeList(UserQuestionLikeQueryDto userQuestionLikeQueryDto);
    
}
