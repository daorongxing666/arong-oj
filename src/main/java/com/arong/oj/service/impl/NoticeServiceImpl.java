package com.arong.oj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.arong.oj.common.DeleteDto;
import com.arong.oj.entity.domain.Notice;
import com.arong.oj.entity.request.notice.NoticeAddDto;
import com.arong.oj.entity.request.notice.NoticeEditDto;
import com.arong.oj.entity.request.notice.NoticeQueryDto;
import com.arong.oj.entity.response.NoticeResponse;
import com.arong.oj.error.BusinessException;
import com.arong.oj.util.PageUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.service.NoticeService;
import com.arong.oj.mapper.NoticeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.arong.oj.common.Code.SQL_ERROR;

/**
* @author centos7
* @description 针对表【notice(通知表)】的数据库操作Service实现
* @createDate 2023-10-29 11:51:45
*/
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice>
    implements NoticeService{

    @Override
    public Long addNotice(NoticeAddDto noticeAddDto) {
        Notice notice = BeanUtil.copyProperties(noticeAddDto, Notice.class);
        boolean save = save(notice);
        if(!save) {
            throw new BusinessException(SQL_ERROR);
        }
        return notice.getId();
    }


    @Override
    public boolean deleteNotice(DeleteDto deleteDto) {
        return removeById(deleteDto.getId());
    }

    @Override
    public Long editNotice(NoticeEditDto noticeEditDto) {
        Notice notice = BeanUtil.copyProperties(noticeEditDto, Notice.class);
        boolean b = updateById(notice);
        if(!b) {
            throw new BusinessException(SQL_ERROR);
        }
        return notice.getId();
    }

    @Override
    public Page<NoticeResponse> getNoticeList(NoticeQueryDto noticeQueryDto) {
        QueryWrapper<Notice> noticeQueryWrapper = new QueryWrapper<>();
        noticeQueryWrapper.lambda()
                .eq(noticeQueryDto.getId() != null && noticeQueryDto.getId() > 0, Notice::getId, noticeQueryDto.getId())
                .eq(noticeQueryDto.getUserId() != null && noticeQueryDto.getUserId() > 0, Notice::getUserId, noticeQueryDto.getUserId())
                .like(noticeQueryDto.getContent() != null && noticeQueryDto.getContent().equals(""), Notice::getContent, noticeQueryDto.getContent());
        List<Notice> list = list(noticeQueryWrapper);
        List<NoticeResponse> collect = list.stream().map(notice -> BeanUtil.copyProperties(notice, NoticeResponse.class)).collect(Collectors.toList());
        Page<NoticeResponse> pageList = PageUtil.getPageList(collect, noticeQueryDto.getCurrentPage(), noticeQueryDto.getPageSize());
        return pageList;
    }

    @Override
    public NoticeResponse getNotice(Long noticeId) {
        QueryWrapper<Notice> noticeQueryWrapper = new QueryWrapper<>();
        noticeQueryWrapper.lambda()
                .eq(noticeId != null && noticeId > 0, Notice::getId, noticeId);
        Notice one = getOne(noticeQueryWrapper);
        NoticeResponse noticeResponse = BeanUtil.copyProperties(one, NoticeResponse.class);
        return noticeResponse;
    }
}