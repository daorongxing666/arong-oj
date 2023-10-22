package com.arong.oj.service;

import com.arong.oj.entity.domain.UserCompetition;
import com.arong.oj.entity.request.userCompetition.UserCompetitionAddDto;
import com.arong.oj.entity.request.userCompetition.UserCompetitionEditDto;
import com.arong.oj.entity.request.userCompetition.UserCompetitionQueryDto;
import com.arong.oj.entity.response.UserCompetitionResponse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author centos7
* @description 针对表【user_competition】的数据库操作Service
* @createDate 2023-10-22 10:35:12
*/
public interface UserCompetitionService extends IService<UserCompetition> {
    /**
     * 用户竞赛发布
     * @param userCompetitionAddDto 用户竞赛发布请求类
     * @return 用户竞赛id
     */
    public Long publishUserCompetition(UserCompetitionAddDto userCompetitionAddDto);

    /**
     * 删除用户竞赛
     * @param userCompetitionId 用户竞赛id
     * @return 是否删除成功
     */
    public boolean deleteUserCompetition(Long userCompetitionId);

    /**
     * 用户竞赛编辑
     * @param userCompetitionEditDto 用户竞赛编辑请求类
     * @return 用户竞赛id
     */
    public Long editUserCompetition(UserCompetitionEditDto userCompetitionEditDto);

    /**
     * 查询用户竞赛列表
     * @param userCompetitionQueryDto 用户竞赛列表请求类
     * @return 用户竞赛列表
     */
    public List<UserCompetitionResponse> getUserCompetitionList(UserCompetitionQueryDto userCompetitionQueryDto);

    /**
     * 查询单个用户竞赛
     * @param userCompetitionId 用户竞赛id
     * @return 用户竞赛内容
     */
    public UserCompetitionResponse getUserCompetition(Long userCompetitionId);
}
