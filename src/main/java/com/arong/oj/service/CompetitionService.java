package com.arong.oj.service;

import com.arong.oj.entity.domain.Competition;
import com.arong.oj.entity.request.post.PostEditDto;
import com.arong.oj.entity.request.post.PostPublishDto;
import com.arong.oj.entity.request.post.PostQueryDto;
import com.arong.oj.entity.request.competition.CompetitionAddDto;
import com.arong.oj.entity.request.competition.CompetitionEditDto;
import com.arong.oj.entity.request.competition.CompetitionQueryDto;
import com.arong.oj.entity.response.PostResponse;
import com.arong.oj.entity.response.CompetitionResponse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author centos7
* @description 针对表【competition】的数据库操作Service
* @createDate 2023-10-22 10:35:05
*/
public interface CompetitionService extends IService<Competition> {

    /**
     * 竞赛发布
     * @param competitionAddDto 竞赛发布请求类
     * @return 竞赛id
     */
    public Long publishCompetition(CompetitionAddDto competitionAddDto);

    /**
     * 删除竞赛
     * @param competitionId 竞赛id
     * @return 是否删除成功
     */
    public boolean deleteCompetition(Long competitionId);

    /**
     * 竞赛编辑
     * @param competitionEditDto 竞赛编辑请求类
     * @return 竞赛id
     */
    public Long editCompetition(CompetitionEditDto competitionEditDto);

    /**
     * 查询竞赛列表
     * @param competitionQueryDto 竞赛列表请求类
     * @return 竞赛列表
     */
    public List<CompetitionResponse> getCompetitionList(CompetitionQueryDto competitionQueryDto);

    /**
     * 查询单个竞赛
     * @param competitionId 竞赛id
     * @return 竞赛内容
     */
    public CompetitionResponse getCompetition(Long competitionId);
}
