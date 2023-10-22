package com.arong.oj.service;

import com.arong.oj.entity.domain.QuestionTag;
import com.arong.oj.entity.request.questionTag.QuestionTagAddDto;
import com.arong.oj.entity.request.questionTag.QuestionTagEditDto;
import com.arong.oj.entity.request.questionTag.QuestionTagQueryDto;
import com.arong.oj.entity.response.QuestionTagResponse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author centos7
* @description 针对表【question_tag】的数据库操作Service
* @createDate 2023-10-21 15:54:31
*/
public interface QuestionTagService extends IService<QuestionTag> {
    /**
     * 题目标签发布
     * @param questionTagAddDto 题目标签发布请求类
     * @return 题目标签id
     */
    public Long publishQuestionTag(QuestionTagAddDto questionTagAddDto);

    /**
     * 删除题目标签
     * @param questionTagId 题目标签id
     * @return 是否删除成功
     */
    public boolean deleteQuestionTag(Long questionTagId);

    /**
     * 题目标签编辑
     * @param questionTagEditDto 题目标签编辑请求类
     * @return 题目标签id
     */
    public Long editQuestionTag(QuestionTagEditDto questionTagEditDto);

    /**
     * 查询题目标签列表
     * @param questionTagQueryDto 题目标签列表请求类
     * @return 题目标签列表
     */
    public List<QuestionTagResponse> getQuestionTagList(QuestionTagQueryDto questionTagQueryDto);

    /**
     * 查询单个题目标签
     * @param questionTagId 题目标签id
     * @return 题目标签内容
     */
    public QuestionTagResponse getQuestionTag(Long questionTagId);
}
