package com.arong.oj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.arong.oj.common.DeleteDto;
import com.arong.oj.entity.domain.Solution;
import com.arong.oj.entity.request.solution.SolutionAddDto;
import com.arong.oj.entity.request.solution.SolutionEditDto;
import com.arong.oj.entity.request.solution.SolutionQueryDto;
import com.arong.oj.entity.response.SolutionResponse;
import com.arong.oj.entity.response.SolutionResponse;
import com.arong.oj.error.BusinessException;
import com.arong.oj.service.SolutionService;
import com.arong.oj.util.PageUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.Solution;
import com.arong.oj.mapper.SolutionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.arong.oj.common.Code.SQL_ERROR;

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
        Solution solution = BeanUtil.copyProperties(solutionAddDto, Solution.class);
        boolean save = save(solution);
        if(!save) {
            throw new BusinessException(SQL_ERROR);
        }
        return solution.getId();
    }

    @Override
    public boolean deleteSolution(DeleteDto deleteDto) {
        return removeById(deleteDto.getId());
    }

    @Override
    public Long editSolution(SolutionEditDto solutionEditDto) {
        Solution solution = BeanUtil.copyProperties(solutionEditDto, Solution.class);
        boolean b = updateById(solution);
        if(!b) {
            throw new BusinessException(SQL_ERROR);
        }
        return solution.getId();
    }

    @Override
    public Page<SolutionResponse> getSolutionList(SolutionQueryDto solutionQueryDto) {
        QueryWrapper<Solution> solutionQueryWrapper = new QueryWrapper<>();
        solutionQueryWrapper.lambda()
                .eq(solutionQueryDto.getId() != null && solutionQueryDto.getId() > 0, Solution::getId, solutionQueryDto.getId())
                .eq(solutionQueryDto.getUserId() != null && solutionQueryDto.getUserId() > 0, Solution::getUserId, solutionQueryDto.getUserId())
                .eq(solutionQueryDto.getTitle() != null && solutionQueryDto.getTitle().equals(""), Solution::getTitle, solutionQueryDto.getTitle());
        List<Solution> list = list(solutionQueryWrapper);
        List<SolutionResponse> collect = list.stream().map(solution -> BeanUtil.copyProperties(solution, SolutionResponse.class)).collect(Collectors.toList());
        Page<SolutionResponse> pageList = PageUtil.getPageList(collect, solutionQueryDto.getCurrentPage(), solutionQueryDto.getPageSize());
        return pageList;
    }

    @Override
    public SolutionResponse getSolution(Long solutionId) {
        QueryWrapper<Solution> solutionQueryWrapper = new QueryWrapper<>();
        solutionQueryWrapper.lambda()
                .eq(solutionId != null && solutionId > 0, Solution::getId, solutionId);
        Solution one = getOne(solutionQueryWrapper);
        SolutionResponse solutionResponse = BeanUtil.copyProperties(one, SolutionResponse.class);
        return solutionResponse;
    }
}




