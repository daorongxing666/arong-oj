package com.arong.oj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.UserCompetitionDescription;
import com.arong.oj.service.UserCompetitionDescriptionService;
import com.arong.oj.mapper.UserCompetitionDescriptionMapper;
import org.springframework.stereotype.Service;

/**
* @author centos7
* @description 针对表【user_competition_description】的数据库操作Service实现
* @createDate 2023-10-22 10:35:15
*/
@Service
public class UserCompetitionDescriptionServiceImpl extends ServiceImpl<UserCompetitionDescriptionMapper, UserCompetitionDescription>
    implements UserCompetitionDescriptionService{

    @Override
    public void description() {

    }

    @Override
    public void notice() {

    }
}




