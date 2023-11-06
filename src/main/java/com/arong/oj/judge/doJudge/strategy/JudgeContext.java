package com.arong.oj.judge.doJudge.strategy;

import com.arong.oj.entity.domain.UserQuestion;
import com.arong.oj.judge.domain.JudgeInfoRequest;
import com.arong.oj.judge.domain.JudgeInfoResponse;
import lombok.Data;

import java.util.List;

@Data
public class JudgeContext {

    private JudgeInfoResponse judgeInfoResponse;

    private UserQuestion userQuestion;

    private List<String> inputList;

    private String language;
}
