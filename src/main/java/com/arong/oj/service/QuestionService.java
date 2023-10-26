package com.arong.oj.service;

import com.arong.oj.common.DeleteDto;
import com.arong.oj.entity.domain.Question;
import com.arong.oj.entity.request.question.QuestionAddDto;
import com.arong.oj.entity.request.question.QuestionEditDto;
import com.arong.oj.entity.request.question.QuestionQueryDto;
import com.arong.oj.entity.response.question.QuestionDetailResponse;
import com.arong.oj.entity.response.question.QuestionResponse;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

/**
* @author centos7
* @description 针对表【question】的数据库操作Service
* @createDate 2023-10-21 15:54:27
*/
public interface QuestionService extends IService<Question> {

    /**
     * 题目新增
     * @param questionAddDto 题目新增请求类
     * @return
     */
    public Long addQuestion(QuestionAddDto questionAddDto);

    /**
     * 编辑题目
     * @param questionEditDto 题目编辑请求类
     * @return
     */
    public Long editQuestion(QuestionEditDto questionEditDto);

    /**
     * 删除题目
     * @param deleteDto 删除题目请求类
     * @return
     */
    public boolean deleteQuestion(DeleteDto deleteDto);

    /**
     * 查询题目列表
     * @param questionQueryDto 题目查询请求类
     * @return
     */
    public Page<QuestionResponse> getQuestionList(QuestionQueryDto questionQueryDto);

    /**
     * 题目查询
     * @param questionId 题目id
     * @return
     */
    public QuestionDetailResponse getQuestionDetail(Long questionId);

    /**
     * 做题（目前不知道怎么办，等一下再来）
     */
    public void execute();
}
