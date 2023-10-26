package com.arong.oj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.arong.oj.common.DeleteDto;
import com.arong.oj.entity.request.userQuestion.UserQuestionAddDto;
import com.arong.oj.entity.request.userQuestion.UserQuestionEditDto;
import com.arong.oj.entity.request.userQuestion.UserQuestionQueryDto;
import com.arong.oj.entity.response.UserQuestionResponse;
import com.arong.oj.service.UserQuestionService;
import com.arong.oj.util.PageUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.UserQuestion;
import com.arong.oj.mapper.UserQuestionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author centos7
* @description 针对表【user_question】的数据库操作Service实现
* @createDate 2023-10-21 15:54:46
*/
@Service
public class UserQuestionServiceImpl extends ServiceImpl<UserQuestionMapper, UserQuestion>
    implements UserQuestionService {

    @Override
    public boolean publishUserQuestion(UserQuestionAddDto userQuestionAddDto) {
        UserQuestion userQuestion = BeanUtil.copyProperties(userQuestionAddDto, UserQuestion.class);
        return this.save(userQuestion);
    }

    @Override
    public boolean deleteUserQuestion(DeleteDto deleteDto) {
        return this.removeById(deleteDto.getId());
    }

    @Override
    public boolean editUserQuestion(UserQuestionEditDto userQuestionEditDto) {
        UserQuestion userQuestion = BeanUtil.copyProperties(userQuestionEditDto, UserQuestion.class);
        return this.updateById(userQuestion);
    }

    @Override
    public Page<UserQuestionResponse> getUserQuestionList(UserQuestionQueryDto userQuestionQueryDto) {
        QueryWrapper<UserQuestion> userQuestionQueryWrapper = new QueryWrapper<>();
        userQuestionQueryWrapper.lambda()
                .eq(userQuestionQueryDto.getUserId() != null && userQuestionQueryDto.getUserId() > 0, UserQuestion::getUserId, userQuestionQueryDto.getUserId())
                .eq(userQuestionQueryDto.getQuestionId() != null && userQuestionQueryDto.getQuestionId() > 0, UserQuestion::getQuestionId, userQuestionQueryDto.getQuestionId());
        List<UserQuestion> list = this.list(userQuestionQueryWrapper);
        List<UserQuestionResponse> collect = list.stream().map(userQuestion -> BeanUtil.copyProperties(userQuestion, UserQuestionResponse.class)).collect(Collectors.toList());
        Page<UserQuestionResponse> pageList = PageUtil.getPageList(collect, userQuestionQueryDto.getCurrentPage(), userQuestionQueryDto.getPageSize());
        return pageList;
    }

    @Override
    public UserQuestionResponse getUserQuestion(Long userQuestionId) {
        QueryWrapper<UserQuestion> userQuestionQueryWrapper = new QueryWrapper<>();
        userQuestionQueryWrapper.lambda().eq(UserQuestion::getId, userQuestionId);
        UserQuestion userQuestion = getOne(userQuestionQueryWrapper);
        return BeanUtil.copyProperties(userQuestion, UserQuestionResponse.class);
    }
}




