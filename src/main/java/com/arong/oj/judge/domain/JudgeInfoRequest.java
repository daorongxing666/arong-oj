package com.arong.oj.judge.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class JudgeInfoRequest {

    /**
     * 输入用例
     */
    private List<String> inputList;

    /**
     * 代码
     */
    private String code;

    /**
     * 语言
     */
    private String language;
}
