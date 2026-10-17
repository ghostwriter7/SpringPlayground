package com.rozplochowski.beans.service;

import jakarta.annotation.Resource;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class StringService {

    private final Map<String, String> names;

    // @Fallback, as there are 2 String @Beans and none is @Primary
    private final String nickname;

    @Resource
    private NumberService numberService;

    public void introduce() {
        IO.println(names);

        IO.println("Hello, I'm " + nickname);
    }

}
