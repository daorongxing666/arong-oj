package com.arong.oj.service.impl;

import com.arong.oj.common.DeleteDto;
import com.arong.oj.entity.request.topic.TopicEditDto;
import com.arong.oj.entity.request.topic.TopicPublishDto;
import com.arong.oj.entity.request.topic.TopicQueryDto;
import com.arong.oj.entity.response.TopicResponse;
import com.arong.oj.service.TopicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.Topic;
import com.arong.oj.mapper.TopicMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public void editTopic(TopicEditDto topicEditDto) {

    }

    @Override
    public boolean deleteTopic(DeleteDto deleteDto) {
        return false;
    }

    @Override
    public List<TopicResponse> getTopicList(TopicQueryDto topicQueryDto) {
        return null;
    }

    @Override
    public TopicResponse getTopic(Long topicId) {
        return null;
    }
}




