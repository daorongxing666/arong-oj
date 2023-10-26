package com.arong.oj.service;

import com.arong.oj.common.DeleteDto;
import com.arong.oj.entity.domain.CompetitionQuestion;
import com.arong.oj.entity.request.competitionQuestion.CompetitionQuestionAddDto;
import com.arong.oj.entity.request.competitionQuestion.CompetitionQuestionEditDto;
import com.arong.oj.entity.request.competitionQuestion.CompetitionQuestionQueryDto;
import com.arong.oj.entity.response.CompetitionQuestionResponse;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author centos7
* @description 针对表【competition_question】的数据库操作Service
* @createDate 2023-10-22 10:35:09
*/
public interface CompetitionQuestionService extends IService<CompetitionQuestion> {
    /**
     * 竞赛题目发布
     * @param competitionQuestionAddDto 竞赛题目发布请求类
     * @return 竞赛题目id
     */
    public Long publishCompetitionQuestion(CompetitionQuestionAddDto competitionQuestionAddDto);

    /**
     * 删除竞赛题目
     * @param competitionQuestionId 竞赛题目id
     * @return 是否删除成功
     */
    public boolean deleteCompetitionQuestion(DeleteDto deleteDto);

    /**
     * 竞赛题目编辑
     * @param competitionQuestionEditDto 竞赛题目编辑请求类
     * @return 竞赛题目id
     */
    public Long editCompetitionQuestion(CompetitionQuestionEditDto competitionQuestionEditDto);

    /**
     * 查询竞赛题目列表
     * @param competitionQuestionQueryDto 竞赛题目列表请求类
     * @return 竞赛题目列表
     */
    public Page<CompetitionQuestionResponse> getCompetitionQuestionList(CompetitionQuestionQueryDto competitionQuestionQueryDto);

    /**
     * 查询单个竞赛题目
     * @param competitionQuestionId 竞赛题目id
     * @return 竞赛题目内容
     */
    public CompetitionQuestionResponse getCompetitionQuestion(Long competitionQuestionId);
}
