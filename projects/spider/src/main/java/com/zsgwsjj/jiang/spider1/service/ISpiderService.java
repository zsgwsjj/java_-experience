package com.zsgwsjj.jiang.spider1.service;

import java.io.IOException;

/**
 * @author : jiang
 * @time : 2018/4/12 16:28
 */
public interface ISpiderService {
    void cleanUp();

    void checkLastOne() throws IOException;
}
