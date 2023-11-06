package com.arong.oj.service.impl;

import cn.hutool.json.JSONUtil;
import com.arong.oj.common.Code;
import com.arong.oj.common.Page;
import com.arong.oj.entity.domain.Notice;
import com.arong.oj.entity.response.CompetitionResponse;
import com.arong.oj.entity.response.UserResponse;
import com.arong.oj.error.BusinessException;
import com.arong.oj.service.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.UserCompetitionDescription;
import com.arong.oj.mapper.UserCompetitionDescriptionMapper;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author centos7
* @description 针对表【user_competition_description】的数据库操作Service实现
* @createDate 2023-10-22 10:35:15
*/
@Service
public class UserCompetitionDescriptionServiceImpl extends ServiceImpl<UserCompetitionDescriptionMapper, UserCompetitionDescription>
    implements UserCompetitionDescriptionService{

    @Resource
    private UserService userService;

    @Resource
    private CompetitionService competitionService;

    @Resource
    private NoticeService noticeService;

    @Override
    public void description(HttpServletRequest request, Long competitionId) {
        // 表中新增数据
        UserCompetitionDescription userCompetitionDescription = new UserCompetitionDescription();
        UserResponse loginUser = userService.getLoginUser(request);
        userCompetitionDescription.setUserId(loginUser.getId());
        userCompetitionDescription.setCompetitionId(competitionId);
        boolean save = save(userCompetitionDescription);
        if(!save) {
            throw new BusinessException(Code.SQL_ERROR);
        }
    }

    @Override
    public void notice(Long competitionId) {
        QueryWrapper<UserCompetitionDescription> userCompetitionDescriptionQueryWrapper = new QueryWrapper<>();
        userCompetitionDescriptionQueryWrapper.lambda().eq(UserCompetitionDescription::getCompetitionId, competitionId);
        List<UserCompetitionDescription> list = list(userCompetitionDescriptionQueryWrapper);
        List<Long> userIds = list.stream().map(UserCompetitionDescription::getUserId).collect(Collectors.toList());
        CompetitionResponse competition = competitionService.getCompetition(competitionId);
        String content = competition.getCompetitionName() + "将于" + competition.getStartTime() + "开始，请做好准备";
        for(Long userId : userIds) {
            Notice notice = new Notice();
            notice.setUserId(userId);
            notice.setNoticeType(1L);
            notice.setContent(content);
            notice.setNoticeUserId(0L);
            notice.setIsRead(0);
            noticeService.save(notice);
        }
    }
}




