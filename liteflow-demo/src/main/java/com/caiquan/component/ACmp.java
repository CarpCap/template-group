package com.caiquan.component;

import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

/**
 * @author  CarpCap
 */
@Component("a")
public class ACmp extends NodeComponent {

    @Override
    public void process() {
        System.out.println("amp");
        //do your business
    }
}

