package com.arong.oj.service.impl;

import com.arong.oj.entity.request.userCompetition.UserCompetitionAddDto;
import com.arong.oj.entity.request.userCompetition.UserCompetitionEditDto;
import com.arong.oj.entity.request.userCompetition.UserCompetitionQueryDto;
import com.arong.oj.entity.response.UserCompetitionResponse;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.UserCompetition;
import com.arong.oj.service.UserCompetitionService;
import com.arong.oj.mapper.UserCompetitionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public boolean deleteUserCompetition(Long userCompetitionId) {
        return false;
    }

    @Override
    public Long editUserCompetition(UserCompetitionEditDto userCompetitionEditDto) {
        return null;
    }

    @Override
    public List<UserCompetitionResponse> getUserCompetitionList(UserCompetitionQueryDto userCompetitionQueryDto) {
        return null;
    }

    @Override
    public UserCompetitionResponse getUserCompetition(Long userCompetitionId) {
        return null;
    }
}




