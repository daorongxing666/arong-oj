package com.arong.oj.service;

import com.arong.oj.common.DeleteDto;
import com.arong.oj.entity.domain.Notice;
import com.arong.oj.entity.request.notice.NoticeAddDto;
import com.arong.oj.entity.request.notice.NoticeEditDto;
import com.arong.oj.entity.request.notice.NoticeQueryDto;
import com.arong.oj.entity.response.NoticeResponse;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author centos7
* @description 针对表【notice(通知表)】的数据库操作Service
* @createDate 2023-10-29 11:51:45
*/
public interface NoticeService extends IService<Notice> {
    /**
     * 通知发布
     * @param noticeAddDto 通知发布请求类
     * @return 通知id
     */
    public Long addNotice(NoticeAddDto noticeAddDto);


    /**
     * 删除通知
     * @param noticeId 通知id
     * @return 是否删除成功
     */
    public boolean deleteNotice(DeleteDto deleteDto);

    /**
     * 通知编辑
     * @param noticeEditDto 通知编辑请求类
     * @return 通知id
     */
    public Long editNotice(NoticeEditDto noticeEditDto);

    /**
     * 查询通知列表
     * @param noticeQueryDto 通知列表请求类
     * @return 通知列表
     */
    public Page<NoticeResponse> getNoticeList(NoticeQueryDto noticeQueryDto);

    /**
     * 查询单个通知
     * @param noticeId 通知id
     * @return 通知内容
     */
    public NoticeResponse getNotice(Long noticeId);
}
