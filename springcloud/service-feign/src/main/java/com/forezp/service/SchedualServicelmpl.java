package com.forezp.service;

import com.forezp.pojo.Book;
import org.springframework.stereotype.Component;

/**
 * @ClassName SchedualServicelmpl
 * @Auther: CarpCap
 * @Date: 2019-11-24 22:08
 * @Description:
 */
@Component
public class SchedualServicelmpl implements SchedualServiceHi{
    @Override
    public String sayHiFromClientOne(String name) {
        return null;
    }

    @Override
    public String sdsdaaaa(Book book) {

        return "降级机制";
    }
}
