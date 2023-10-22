package com.arong.oj.service.impl;

import com.arong.oj.entity.request.solution.SolutionAddDto;
import com.arong.oj.entity.request.solution.SolutionEditDto;
import com.arong.oj.entity.request.solution.SolutionQueryDto;
import com.arong.oj.entity.response.SolutionResponse;
import com.arong.oj.service.SolutionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.Solution;
import com.arong.oj.mapper.SolutionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author centos7
* @description 针对表【solution】的数据库操作Service实现
* @createDate 2023-10-21 15:54:35
*/
@Service
public class SolutionServiceImpl extends ServiceImpl<SolutionMapper, Solution>
    implements SolutionService {

    @Override
    public Long publishSolution(SolutionAddDto solutionAddDto) {
        return null;
    }

    @Override
    public boolean deleteSolution(Long solutionId) {
        return false;
    }

    @Override
    public Long editSolution(SolutionEditDto solutionEditDto) {
        return null;
    }

    @Override
    public List<SolutionResponse> getSolutionList(SolutionQueryDto solutionQueryDto) {
        return null;
    }

    @Override
    public SolutionResponse getSolution(Long solutionId) {
        return null;
    }
}




