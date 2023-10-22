package com.arong.oj.service.impl;

import com.arong.oj.entity.request.userNote.UserNoteAddDto;
import com.arong.oj.entity.request.userNote.UserNoteEditDto;
import com.arong.oj.entity.request.userNote.UserNoteQueryDto;
import com.arong.oj.entity.response.UserNoteResponse;
import com.arong.oj.service.UserNoteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.UserNote;
import com.arong.oj.mapper.UserNoteMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public boolean deleteUserNote(Long userNoteId) {
        return false;
    }

    @Override
    public Long editUserNote(UserNoteEditDto userNoteEditDto) {
        return null;
    }

    @Override
    public List<UserNoteResponse> getUserNoteList(UserNoteQueryDto userNoteQueryDto) {
        return null;
    }

    @Override
    public UserNoteResponse getUserNote(Long userNoteId) {
        return null;
    }
}




