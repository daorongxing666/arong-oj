package com.arong.oj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.arong.oj.common.DeleteDto;
import com.arong.oj.entity.request.userNote.UserNoteAddDto;
import com.arong.oj.entity.request.userNote.UserNoteEditDto;
import com.arong.oj.entity.request.userNote.UserNoteQueryDto;
import com.arong.oj.entity.response.UserNoteResponse;
import com.arong.oj.error.BusinessException;
import com.arong.oj.service.UserNoteService;
import com.arong.oj.util.PageUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.UserNote;
import com.arong.oj.mapper.UserNoteMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.arong.oj.common.Code.SQL_ERROR;

/**
* @author centos7
* @description 针对表【user_note】的数据库操作Service实现
* @createDate 2023-10-21 15:54:42
*/
@Service
public class UserNoteServiceImpl extends ServiceImpl<UserNoteMapper, UserNote>
    implements UserNoteService {

    @Override
    public Long publishUserNote(UserNoteAddDto userNoteAddDto) {
        UserNote userNote = BeanUtil.copyProperties(userNoteAddDto, UserNote.class);
        boolean save = save(userNote);
        if(!save) {
            throw new BusinessException(SQL_ERROR);
        }
        return userNote.getId();
    }

    @Override
    public boolean deleteUserNote(DeleteDto deleteDto) {
        return removeById(deleteDto.getId());
    }

    @Override
    public Long editUserNote(UserNoteEditDto userNoteEditDto) {
        UserNote userNote = BeanUtil.copyProperties(userNoteEditDto, UserNote.class);
        boolean b = updateById(userNote);
        if(!b) {
            throw new BusinessException(SQL_ERROR);
        }
        return userNote.getId();
    }

    @Override
    public Page<UserNoteResponse> getUserNoteList(UserNoteQueryDto userNoteQueryDto) {
        QueryWrapper<UserNote> userNoteQueryWrapper = new QueryWrapper<>();
        userNoteQueryWrapper.lambda()
                .eq(userNoteQueryDto.getId() != null && userNoteQueryDto.getId() > 0, UserNote::getId, userNoteQueryDto.getId())
                .eq(userNoteQueryDto.getUserId() != null && userNoteQueryDto.getUserId() > 0, UserNote::getUserId, userNoteQueryDto.getUserId())
                .like(userNoteQueryDto.getTitle() != null && userNoteQueryDto.getTitle().equals(""), UserNote::getTitle, userNoteQueryDto.getTitle())
                .eq(userNoteQueryDto.getCollect() != null, UserNote::getCollect, userNoteQueryDto.getCollect());

        List<UserNote> list = list(userNoteQueryWrapper);
        List<UserNoteResponse> collect = list.stream().map(userNote -> BeanUtil.copyProperties(userNote, UserNoteResponse.class)).collect(Collectors.toList());
        Page<UserNoteResponse> pageList = PageUtil.getPageList(collect, userNoteQueryDto.getCurrentPage(), userNoteQueryDto.getPageSize());
        return pageList;
    }

    @Override
    public UserNoteResponse getUserNote(Long userNoteId) {
        QueryWrapper<UserNote> userNoteQueryWrapper = new QueryWrapper<>();
        userNoteQueryWrapper.lambda()
                .eq(userNoteId != null && userNoteId > 0, UserNote::getId, userNoteId);
        UserNote one = getOne(userNoteQueryWrapper);
        UserNoteResponse userNoteResponse = BeanUtil.copyProperties(one, UserNoteResponse.class);
        return userNoteResponse;
    }
}




