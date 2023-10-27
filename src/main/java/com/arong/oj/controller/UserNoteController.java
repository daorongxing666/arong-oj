package com.arong.oj.controller;

import com.arong.oj.common.DeleteDto;
import com.arong.oj.common.Result;
import com.arong.oj.entity.request.userNote.UserNoteAddDto;
import com.arong.oj.entity.request.userNote.UserNoteEditDto;
import com.arong.oj.entity.request.userNote.UserNoteQueryDto;
import com.arong.oj.entity.response.UserNoteResponse;
import com.arong.oj.service.UserNoteService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@Slf4j
@RestController()
@RequestMapping(value = "/userNote")
public class UserNoteController {
    
    @Resource
    UserNoteService userNoteService;

    /**
     * 获取个人笔记列表
     * @param userNoteQueryDto
     * @return
     * @throws IOException
     */
    @PostMapping("/list")
    public Result<Page<UserNoteResponse>> getUserNoteList(@RequestBody UserNoteQueryDto userNoteQueryDto) {
        Page<UserNoteResponse> userNoteList = userNoteService.getUserNoteList(userNoteQueryDto);
        return Result.succeed(userNoteList);
    }

    /**
     * 新增个人笔记
     * @param userNoteAddDto
     * @return
     */
    @PostMapping("/add")
    public Result<UserNoteResponse> addUserNote(@RequestBody UserNoteAddDto userNoteAddDto) {
        Long userNoteId = userNoteService.publishUserNote(userNoteAddDto);
        UserNoteResponse userNoteDetail = userNoteService.getUserNote(userNoteId);
        return Result.succeed(userNoteDetail);
    }

    /**
     * 获取单道个人笔记详情
     * @param userNoteId
     * @return
     */
    @GetMapping("/detail/{userNoteId}")
    public Result<UserNoteResponse> getUserNoteDetail(@PathVariable Long userNoteId) {
        UserNoteResponse userNoteDetail = userNoteService.getUserNote(userNoteId);
        return Result.succeed(userNoteDetail);
    }

    /**
     * 编辑个人笔记
     * @param userNoteEditDto
     * @return
     */
    @PostMapping("/edit")
    public Result<Boolean> editUserNote(@RequestBody UserNoteEditDto userNoteEditDto) {
        Long userNoteId = userNoteService.editUserNote(userNoteEditDto);
        return Result.succeed(userNoteId != null);
    }

    /**
     * 删除个人笔记
     * @param deleteDto
     * @return
     */
    @PostMapping("/remove")
    public Result<Boolean> removeUserNote(@RequestBody DeleteDto deleteDto) {
        Boolean b = userNoteService.deleteUserNote(deleteDto);
        return Result.succeed(b);
    }
}
