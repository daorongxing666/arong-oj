package com.arong.oj.service;

import com.arong.oj.common.DeleteDto;
import com.arong.oj.entity.domain.Solution;
import com.arong.oj.entity.request.solution.SolutionAddDto;
import com.arong.oj.entity.request.solution.SolutionEditDto;
import com.arong.oj.entity.request.solution.SolutionQueryDto;
import com.arong.oj.entity.response.SolutionResponse;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author centos7
* @description 针对表【solution】的数据库操作Service
* @createDate 2023-10-21 15:54:35
*/
public interface SolutionService extends IService<Solution> {
    /**
     * 题解发布
     * @param solutionAddDto 题解发布请求类
     * @return 题解id
     */
    public Long publishSolution(SolutionAddDto solutionAddDto);

    /**
     * 删除题解
     * @param solutionId 题解id
     * @return 是否删除成功
     */
    public boolean deleteSolution(DeleteDto deleteDto);

    /**
     * 题解编辑
     * @param solutionEditDto 题解编辑请求类
     * @return 题解id
     */
    public Long editSolution(SolutionEditDto solutionEditDto);

    /**
     * 查询题解列表
     * @param solutionQueryDto 题解列表请求类
     * @return 题解列表
     */
    public Page<SolutionResponse> getSolutionList(SolutionQueryDto solutionQueryDto);

    /**
     * 查询单个题解
     * @param solutionId 题解id
     * @return 题解内容
     */
    public SolutionResponse getSolution(Long solutionId);
}
