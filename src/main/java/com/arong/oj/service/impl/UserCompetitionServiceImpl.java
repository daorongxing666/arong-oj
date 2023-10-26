package com.arong.oj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.arong.oj.common.Code;
import com.arong.oj.common.DeleteDto;
import com.arong.oj.entity.request.userCompetition.UserCompetitionAddDto;
import com.arong.oj.entity.request.userCompetition.UserCompetitionEditDto;
import com.arong.oj.entity.request.userCompetition.UserCompetitionQueryDto;
import com.arong.oj.entity.response.UserCompetitionResponse;
import com.arong.oj.error.BusinessException;
import com.arong.oj.util.PageUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.UserCompetition;
import com.arong.oj.service.UserCompetitionService;
import com.arong.oj.mapper.UserCompetitionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author centos7
* @description 针对表【user_competition】的数据库操作Service实现
* @createDate 2023-10-22 10:35:12
*/
@Service
public class UserCompetitionServiceImpl extends ServiceImpl<UserCompetitionMapper, UserCompetition>
    implements UserCompetitionService{

    @Override
    public Long publishUserCompetition(UserCompetitionAddDto userCompetitionAddDto) {
        UserCompetition userCompetition = BeanUtil.copyProperties(userCompetitionAddDto, UserCompetition.class);
        boolean save = save(userCompetition);
        if(!save) {
            throw new BusinessException(Code.SQL_ERROR);
        }
        return userCompetition.getId();
    }

    @Override
    public boolean deleteUserCompetition(DeleteDto deleteDto) {
        return removeById(deleteDto.getId());
    }

    @Override
    public Long editUserCompetition(UserCompetitionEditDto userCompetitionEditDto) {
        UserCompetition userCompetition = BeanUtil.copyProperties(userCompetitionEditDto, UserCompetition.class);
        boolean b = updateById(userCompetition);
        if(!b) {
            throw new BusinessException(Code.SQL_ERROR);
        }
        return userCompetition.getId();
    }

    @Override
    public Page<UserCompetitionResponse> getUserCompetitionList(UserCompetitionQueryDto userCompetitionQueryDto) {
        QueryWrapper<UserCompetition> userCompetitionQueryWrapper = new QueryWrapper<>();
        userCompetitionQueryWrapper.lambda()
                .eq(userCompetitionQueryDto.getId() != null && userCompetitionQueryDto.getId() > 0, UserCompetition::getId, userCompetitionQueryDto.getId())
                .eq(userCompetitionQueryDto.getUserId() != null && userCompetitionQueryDto.getUserId() > 0, UserCompetition::getUserId, userCompetitionQueryDto.getUserId())
                .eq(userCompetitionQueryDto.getCompetitionId() != null && userCompetitionQueryDto.getCompetitionId() > 0, UserCompetition::getCompetitionId, userCompetitionQueryDto.getCompetitionId());
        List<UserCompetition> list = list(userCompetitionQueryWrapper);
        List<UserCompetitionResponse> collect = list.stream().map(userCompetition -> BeanUtil.copyProperties(userCompetition, UserCompetitionResponse.class)).collect(Collectors.toList());
        return PageUtil.getPageList(collect, userCompetitionQueryDto.getCurrentPage(), userCompetitionQueryDto.getPageSize());
    }

    @Override
    public UserCompetitionResponse getUserCompetition(Long userCompetitionId) {
        QueryWrapper<UserCompetition> userCompetitionQueryWrapper = new QueryWrapper<>();
        userCompetitionQueryWrapper.lambda()
                .eq(userCompetitionId != null && userCompetitionId > 0, UserCompetition::getId, userCompetitionId);
        UserCompetition one = getOne(userCompetitionQueryWrapper);
        return BeanUtil.copyProperties(one, UserCompetitionResponse.class);
    }
}




