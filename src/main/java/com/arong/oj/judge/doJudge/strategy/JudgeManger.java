package com.arong.oj.judge.doJudge.strategy;

import com.arong.oj.entity.domain.UserQuestion;
import com.arong.oj.judge.doJudge.strategy.common.CppJudgeStrategy;
import com.arong.oj.judge.doJudge.strategy.common.DefaultJudgeStrategy;
import com.arong.oj.judge.doJudge.strategy.common.GoJudgeStrategy;
import com.arong.oj.judge.doJudge.strategy.common.JavaJudgeStrategy;
import org.apache.commons.lang3.ObjectUtils;

public class JudgeManger {
    public static UserQuestion getStrategy(JudgeContext judgeContext) {

        JudgeStrategy judgeStrategy;
        String language = judgeContext.getLanguage();
        if(ObjectUtils.isEmpty(language)) {
            judgeStrategy = new DefaultJudgeStrategy();
            return judgeStrategy.judge(judgeContext);
        }

        switch (language) {
            case "cpp":
                judgeStrategy = new CppJudgeStrategy();
                return judgeStrategy.judge(judgeContext);
            case "java":
                judgeStrategy = new JavaJudgeStrategy();
                return judgeStrategy.judge(judgeContext);
            case "golang":
                judgeStrategy = new GoJudgeStrategy();
                return judgeStrategy.judge(judgeContext);
            default:
                judgeStrategy = new DefaultJudgeStrategy();
                return judgeStrategy.judge(judgeContext);
        }
    }
}
