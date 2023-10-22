package com.arong.oj.service.impl;

import com.arong.oj.entity.request.userQuestion.UserQuestionAddDto;
import com.arong.oj.entity.request.userQuestion.UserQuestionEditDto;
import com.arong.oj.entity.request.userQuestion.UserQuestionQueryDto;
import com.arong.oj.entity.response.UserQuestionResponse;
import com.arong.oj.service.UserQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.UserQuestion;
import com.arong.oj.mapper.UserQuestionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author centos7
* @description 针对表【user_question】的数据库操作Service实现
* @createDate 2023-10-21 15:54:46
*/
@Service
public class UserQuestionServiceImpl extends ServiceImpl<UserQuestionMapper, UserQuestion>
    implements UserQuestionService {

    @Override
    public Long publishUserQuestion(UserQuestionAddDto userQuestionAddDto) {
        return null;
    }

    @Override
    public boolean deleteUserQuestion(Long userQuestionId) {
        return false;
    }

    @Override
    public Long editUserQuestion(UserQuestionEditDto userQuestionEditDto) {
        return null;
    }

    @Override
    public List<UserQuestionResponse> getUserQuestionList(UserQuestionQueryDto userQuestionQueryDto) {
        return null;
    }

    @Override
    public UserQuestionResponse getUserQuestion(Long userQuestionId) {
        return null;
    }
}




