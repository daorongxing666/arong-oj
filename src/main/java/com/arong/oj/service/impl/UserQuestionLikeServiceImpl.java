package com.arong.oj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.arong.oj.common.DeleteDto;
import com.arong.oj.entity.request.userQuestionLike.UserQuestionLikeAddDto;
import com.arong.oj.entity.request.userQuestionLike.UserQuestionLikeQueryDto;
import com.arong.oj.entity.response.UserQuestionLikeResponse;
import com.arong.oj.entity.response.UserQuestionResponse;
import com.arong.oj.service.UserQuestionLikeService;
import com.arong.oj.util.PageUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.UserQuestionLike;
import com.arong.oj.mapper.UserQuestionLikeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author centos7
* @description 针对表【user_question_like】的数据库操作Service实现
* @createDate 2023-10-21 15:54:49
*/
@Service
public class UserQuestionLikeServiceImpl extends ServiceImpl<UserQuestionLikeMapper, UserQuestionLike>
    implements UserQuestionLikeService {

    @Override
    public Long addUserQuestionLike(UserQuestionLikeAddDto userQuestionLikeAddDto) {
        UserQuestionLike userQuestionLike = BeanUtil.copyProperties(userQuestionLikeAddDto, UserQuestionLike.class);
        boolean save = save(userQuestionLike);
        return userQuestionLike.getId();
    }

    @Override
    public boolean deleteUserQuestionLike(DeleteDto deleteDto) {
        return this.removeById(deleteDto.getId());
    }

    @Override
    public Page<UserQuestionLikeResponse> getUserQuestionLikeList(UserQuestionLikeQueryDto userQuestionLikeQueryDto) {
        QueryWrapper<UserQuestionLike> userQuestionLikeQueryWrapper = new QueryWrapper<>();
        userQuestionLikeQueryWrapper.lambda()
                .eq(userQuestionLikeQueryDto.getUserId() != null && userQuestionLikeQueryDto.getUserId() > 0, UserQuestionLike::getUserId, userQuestionLikeQueryDto.getUserId())
                .eq(userQuestionLikeQueryDto.getQuestionId() != null && userQuestionLikeQueryDto.getQuestionId() > 0, UserQuestionLike::getQuestionId, userQuestionLikeQueryDto.getQuestionId());
        List<UserQuestionLike> list = this.list(userQuestionLikeQueryWrapper);
        List<UserQuestionLikeResponse> collect = list.stream().map(userQuestionLike -> BeanUtil.copyProperties(userQuestionLike, UserQuestionLikeResponse.class)).collect(Collectors.toList());
        Page<UserQuestionLikeResponse> pageList = PageUtil.getPageList(collect, userQuestionLikeQueryDto.getCurrentPage(), userQuestionLikeQueryDto.getPageSize());
        return pageList;
    }
}




