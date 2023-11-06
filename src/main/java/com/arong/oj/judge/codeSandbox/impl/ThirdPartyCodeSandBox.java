package com.arong.oj.judge.codeSandbox.impl;

import com.arong.oj.judge.codeSandbox.CodeSandbox;
import com.arong.oj.judge.domain.JudgeInfoRequest;
import com.arong.oj.judge.domain.JudgeInfoResponse;

public class ThirdPartyCodeSandBox implements CodeSandbox {
    @Override
    public JudgeInfoResponse execute(JudgeInfoRequest judgeInfoRequest) {
        System.out.println("第三方代码沙箱执行");
        return null;
    }
}
