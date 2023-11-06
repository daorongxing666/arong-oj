package com.arong.oj.judge.codeSandbox.proxy;

import com.arong.oj.judge.codeSandbox.CodeSandbox;
import com.arong.oj.judge.domain.JudgeInfoRequest;
import com.arong.oj.judge.domain.JudgeInfoResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CodeSandBoxProxy implements CodeSandbox {

    private CodeSandbox codeSandbox;

    public CodeSandBoxProxy(CodeSandbox codeSandbox) {
        this.codeSandbox = codeSandbox;
    }

    /**
     * 静态代理类增强原有功能
     * @param judgeInfoRequest
     * @return
     */
    @Override
    public JudgeInfoResponse execute(JudgeInfoRequest judgeInfoRequest) {
        log.info("输入判题信息为：{}", judgeInfoRequest);
        JudgeInfoResponse judgeInfoResponse = codeSandbox.execute(judgeInfoRequest);
        log.info("输出判题信息为：{}", judgeInfoResponse);
        return judgeInfoResponse;
    }
}
