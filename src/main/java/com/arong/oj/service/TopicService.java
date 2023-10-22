package com.arong.oj.service;

import com.arong.oj.common.DeleteDto;
import com.arong.oj.entity.domain.Topic;
import com.arong.oj.entity.request.topic.TopicEditDto;
import com.arong.oj.entity.request.topic.TopicPublishDto;
import com.arong.oj.entity.request.topic.TopicQueryDto;
import com.arong.oj.entity.response.TopicResponse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author centos7
* @description 针对表【topic】的数据库操作Service
* @createDate 2023-10-21 15:54:39
*/
public interface TopicService extends IService<Topic> {

    /**
     * 发布话题
     * @param topicPublishDto 话题发布请求类
     * @return
     */
    public Long publishTopic(TopicPublishDto topicPublishDto);

    /**
     * 编辑话题
     * @param topicEditDto 话题编辑请求类
     */
    public void editTopic(TopicEditDto topicEditDto);

    /**
     * 删除话题
     * @param deleteDto 删除请求类
     * @return
     */
    public boolean deleteTopic(DeleteDto deleteDto);

    /**
     * 查询话题列表
     * @param topicQueryDto 话题列表请求类
     * @return
     */
    public List<TopicResponse> getTopicList(TopicQueryDto topicQueryDto);

    /**
     * 查询具体话题
     * @param topicId 话题id
     * @return
     */
    public TopicResponse getTopic(Long topicId);
}
