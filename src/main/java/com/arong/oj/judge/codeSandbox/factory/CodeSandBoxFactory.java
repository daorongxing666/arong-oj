package com.arong.oj.judge.codeSandbox.factory;

import com.arong.oj.judge.codeSandbox.CodeSandbox;
import com.arong.oj.judge.codeSandbox.impl.ExampleCodeSandBox;
import com.arong.oj.judge.codeSandbox.impl.RemoteCodeSandBox;
import com.arong.oj.judge.codeSandbox.impl.ThirdPartyCodeSandBox;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂模式，后续需要优化
 */
public class CodeSandBoxFactory {

    public static final Map<String, CodeSandbox> CODE_SANDBOX_INSTANCE_MAP= new HashMap<>();
    /**
     * 静态单例工程模式
     * @param type 工厂类型
     * @return
     */
    public static CodeSandbox getCodeSandBoxInstance(String type) {
        CodeSandbox codeSandbox;
        switch (type) {
            case "example":
                codeSandbox = CODE_SANDBOX_INSTANCE_MAP.get(type);
                if (codeSandbox == null) {
                    codeSandbox = new ExampleCodeSandBox();
                    CODE_SANDBOX_INSTANCE_MAP.put(type, codeSandbox);
                }
                return codeSandbox;
            case "remote":
                codeSandbox = CODE_SANDBOX_INSTANCE_MAP.get(type);
                if (codeSandbox == null) {
                    codeSandbox = new RemoteCodeSandBox();
                    CODE_SANDBOX_INSTANCE_MAP.put(type, codeSandbox);
                }
                return codeSandbox;
            case "thirdParty":
                codeSandbox = CODE_SANDBOX_INSTANCE_MAP.get(type);
                if (codeSandbox == null) {
                    codeSandbox = new ThirdPartyCodeSandBox();
                    CODE_SANDBOX_INSTANCE_MAP.put(type, codeSandbox);
                }
                return codeSandbox;
            default:
                codeSandbox = CODE_SANDBOX_INSTANCE_MAP.get(type);
                if (codeSandbox == null) {
                    codeSandbox = new ExampleCodeSandBox();
                    CODE_SANDBOX_INSTANCE_MAP.put(type, codeSandbox);
                }
                return codeSandbox;
        }
    }

}
