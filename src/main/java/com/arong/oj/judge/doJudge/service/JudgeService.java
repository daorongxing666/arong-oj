package com.arong.oj.judge.doJudge.service;

import com.arong.oj.entity.domain.UserQuestion;
import org.springframework.stereotype.Service;

@Service
public interface JudgeService {

    public UserQuestion doJudge(UserQuestion userQuestion);
}
