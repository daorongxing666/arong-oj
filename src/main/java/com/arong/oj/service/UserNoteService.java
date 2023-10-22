package com.arong.oj.service;

import com.arong.oj.entity.domain.UserNote;
import com.arong.oj.entity.request.userNote.UserNoteAddDto;
import com.arong.oj.entity.request.userNote.UserNoteEditDto;
import com.arong.oj.entity.request.userNote.UserNoteQueryDto;
import com.arong.oj.entity.response.UserNoteResponse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author centos7
* @description 针对表【user_note】的数据库操作Service
* @createDate 2023-10-21 15:54:42
*/
public interface UserNoteService extends IService<UserNote> {
    /**
     * 用户笔记发布
     * @param userNoteAddDto 用户笔记发布请求类
     * @return 用户笔记id
     */
    public Long publishUserNote(UserNoteAddDto userNoteAddDto);

    /**
     * 删除用户笔记
     * @param userNoteId 用户笔记id
     * @return 是否删除成功
     */
    public boolean deleteUserNote(Long userNoteId);

    /**
     * 用户笔记编辑
     * @param userNoteEditDto 用户笔记编辑请求类
     * @return 用户笔记id
     */
    public Long editUserNote(UserNoteEditDto userNoteEditDto);

    /**
     * 查询用户笔记列表
     * @param userNoteQueryDto 用户笔记列表请求类
     * @return 用户笔记列表
     */
    public List<UserNoteResponse> getUserNoteList(UserNoteQueryDto userNoteQueryDto);

    /**
     * 查询单个用户笔记
     * @param userNoteId 用户笔记id
     * @return 用户笔记内容
     */
    public UserNoteResponse getUserNote(Long userNoteId);
}
