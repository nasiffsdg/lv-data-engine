package com.lv.common.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationContext;

class SpringContextUtilsTest {
    @Mock
    ApplicationContext applicationContext;
    @InjectMocks
    SpringContextUtils springContextUtils;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetBean() {
        Object result = SpringContextUtils.getBean("name");
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testContainsBean() {
        boolean result = SpringContextUtils.containsBean("name");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testIsSingleton() {
        boolean result = SpringContextUtils.isSingleton("name");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testGetType() {
        Class<?> result = SpringContextUtils.getType("name");
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: https://weirddev.com/forum#!/testme