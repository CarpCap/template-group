package com.caiquan.component;

import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

/**
 * @author  CarpCap
 */
@Component("b")
public class BCmp extends NodeComponent {

    @Override
    public void process() {
        System.out.println("bmp");

        //do your business
    }
}

