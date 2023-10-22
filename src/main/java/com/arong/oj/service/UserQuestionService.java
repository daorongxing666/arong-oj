package com.arong.oj.service;

import com.arong.oj.entity.domain.UserQuestion;
import com.arong.oj.entity.request.userQuestion.UserQuestionAddDto;
import com.arong.oj.entity.request.userQuestion.UserQuestionEditDto;
import com.arong.oj.entity.request.userQuestion.UserQuestionQueryDto;
import com.arong.oj.entity.response.UserQuestionResponse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author centos7
* @description 针对表【user_question】的数据库操作Service
* @createDate 2023-10-21 15:54:46
*/
public interface UserQuestionService extends IService<UserQuestion> {
    /**
     * 用户答题发布
     * @param userQuestionAddDto 用户答题发布请求类
     * @return 用户答题id
     */
    public Long publishUserQuestion(UserQuestionAddDto userQuestionAddDto);

    /**
     * 删除用户答题
     * @param userQuestionId 用户答题id
     * @return 是否删除成功
     */
    public boolean deleteUserQuestion(Long userQuestionId);

    /**
     * 用户答题编辑
     * @param userQuestionEditDto 用户答题编辑请求类
     * @return 用户答题id
     */
    public Long editUserQuestion(UserQuestionEditDto userQuestionEditDto);

    /**
     * 查询用户答题列表
     * @param userQuestionQueryDto 用户答题列表请求类
     * @return 用户答题列表
     */
    public List<UserQuestionResponse> getUserQuestionList(UserQuestionQueryDto userQuestionQueryDto);

    /**
     * 查询单个用户答题
     * @param userQuestionId 用户答题id
     * @return 用户答题内容
     */
    public UserQuestionResponse getUserQuestion(Long userQuestionId);
}
