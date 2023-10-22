package com.arong.oj.service.impl;

import com.arong.oj.entity.request.userQuestionLike.UserQuestionLikeAddDto;
import com.arong.oj.entity.request.userQuestionLike.UserQuestionLikeQueryDto;
import com.arong.oj.entity.response.UserQuestionLikeResponse;
import com.arong.oj.service.UserQuestionLikeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.UserQuestionLike;
import com.arong.oj.mapper.UserQuestionLikeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author centos7
* @description 针对表【user_question_like】的数据库操作Service实现
* @createDate 2023-10-21 15:54:49
*/
@Service
public class UserQuestionLikeServiceImpl extends ServiceImpl<UserQuestionLikeMapper, UserQuestionLike>
    implements UserQuestionLikeService {

    @Override
    public Long publishUserQuestionLike(UserQuestionLikeAddDto userQuestionLikeAddDto) {
        return null;
    }

    @Override
    public boolean deleteUserQuestionLike(Long userQuestionLikeId) {
        return false;
    }

    @Override
    public List<UserQuestionLikeResponse> getUserQuestionLikeList(UserQuestionLikeQueryDto userQuestionLikeQueryDto) {
        return null;
    }
}




