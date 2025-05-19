package com.caiquan.component;

import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

/**
 * @author  CarpCap
 */
@Component("c")
public class CCmp extends NodeComponent {

    @Override
    public void process() {
        System.out.println("cmp");
        //do your business
    }
}

