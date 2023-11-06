package com.arong.oj.judge.codeSandbox;

import com.arong.oj.judge.domain.JudgeInfoRequest;
import com.arong.oj.judge.domain.JudgeInfoResponse;

public interface CodeSandbox {

    public JudgeInfoResponse execute(JudgeInfoRequest judgeInfoRequest);
}
