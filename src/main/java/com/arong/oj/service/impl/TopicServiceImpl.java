package com.arong.oj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.arong.oj.common.DeleteDto;
import com.arong.oj.entity.domain.UserNote;
import com.arong.oj.entity.request.topic.TopicEditDto;
import com.arong.oj.entity.request.topic.TopicPublishDto;
import com.arong.oj.entity.request.topic.TopicQueryDto;
import com.arong.oj.entity.response.TopicResponse;
import com.arong.oj.entity.response.UserNoteResponse;
import com.arong.oj.error.BusinessException;
import com.arong.oj.service.TopicService;
import com.arong.oj.util.PageUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.Topic;
import com.arong.oj.mapper.TopicMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.arong.oj.common.Code.SQL_ERROR;

/**
* @author centos7
* @description 针对表【topic】的数据库操作Service实现
* @createDate 2023-10-21 15:54:39
*/
@Service
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic>
    implements TopicService {

    @Override
    public Long publishTopic(TopicPublishDto topicPublishDto) {
        Topic topic = BeanUtil.copyProperties(topicPublishDto, Topic.class);
        boolean save = save(topic);
        if(!save) {
            throw new BusinessException(SQL_ERROR);
        }
        return topic.getId();
    }

    @Override
    public boolean editTopic(TopicEditDto topicEditDto) {
        Topic topic = BeanUtil.copyProperties(topicEditDto, Topic.class);
        boolean save = updateById(topic);
        if(!save) {
            throw new BusinessException(SQL_ERROR);
        }
        return save;
    }

    @Override
    public boolean deleteTopic(DeleteDto deleteDto) {
        return removeById(deleteDto.getId());
    }

    @Override
    public Page<TopicResponse> getTopicList(TopicQueryDto topicQueryDto) {
        QueryWrapper<Topic> topicQueryWrapper = new QueryWrapper<>();
        topicQueryWrapper.lambda()
                .eq(topicQueryDto.getId() != null && topicQueryDto.getId() > 0, Topic::getId, topicQueryDto.getId())
                .eq(topicQueryDto.getUserId() != null && topicQueryDto.getUserId() > 0, Topic::getUserId, topicQueryDto.getUserId())
                .like(topicQueryDto.getTitle() != null && topicQueryDto.getTitle().equals(""), Topic::getTitle, topicQueryDto.getTitle())
                .like(topicQueryDto.getContent() != null, Topic::getContent, topicQueryDto.getContent());

        List<Topic> list = list(topicQueryWrapper);
        List<TopicResponse> collect = list.stream().map(topic -> BeanUtil.copyProperties(topic, TopicResponse.class)).collect(Collectors.toList());
        return PageUtil.getPageList(collect, topicQueryDto.getCurrentPage(), topicQueryDto.getPageSize());
    }

    @Override
    public TopicResponse getTopic(Long topicId) {
        QueryWrapper<Topic> topicQueryWrapper = new QueryWrapper<>();
        topicQueryWrapper.lambda()
                .eq(topicId != null && topicId > 0, Topic::getId, topicId);
        Topic one = getOne(topicQueryWrapper);
        return BeanUtil.copyProperties(one, TopicResponse.class);
    }
}




