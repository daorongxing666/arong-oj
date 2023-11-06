package com.arong.oj.judge.doJudge.strategy;

import com.arong.oj.entity.domain.UserQuestion;
import org.springframework.stereotype.Service;

@Service
public interface JudgeStrategy {

    public UserQuestion judge(JudgeContext judgeContext);
}
