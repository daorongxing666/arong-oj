package com.arong.oj.service;

import com.arong.oj.entity.domain.UserCompetitionDescription;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author centos7
* @description 针对表【user_competition_description】的数据库操作Service
* @createDate 2023-10-22 10:35:15
*/
public interface UserCompetitionDescriptionService extends IService<UserCompetitionDescription> {

    /**
     * 订阅竞赛
     */
    public void description();

    /**
     * 通知参加竞赛
     */
    public void notice();
}
