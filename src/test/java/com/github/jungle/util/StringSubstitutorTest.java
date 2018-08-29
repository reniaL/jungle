package com.github.jungle.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.text.StringSubstitutor;
import org.junit.Assert;
import org.junit.Test;

public class StringSubstitutorTest {

    // default value separated by delimiter (default :-)
    private static final String TEMPLATE = "my name is ${name}, age ${age}, and gender ${gender:-male}. call me ${name} ha.";

    @Test
    public void replace_static() {
        String expected = "my name is Terry, age 12, and gender male. call me Terry ha.";
        String actual = StringSubstitutor.replace(TEMPLATE, getMap());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void replace_normal() {
        StringSubstitutor ss = new StringSubstitutor(getMap());
        String expected = "my name is Terry, age 12, and gender male. call me Terry ha.";
        String actual = ss.replace(TEMPLATE);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void replace_embed() {
        String template = "embeded variable won't work by default ${my.${name}}";
        String actual = StringSubstitutor.replace(template, getMap());
        Assert.assertEquals(template, actual);
    }

    @Test
    public void replace_escape() {
        String template = "can escape $${my.${name}}"; // escape by prefixing $
        String expected = "can escape ${my.Terry}";
        String actual = StringSubstitutor.replace(template, getMap());
        Assert.assertEquals(expected, actual);
    }

    private Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Terry");
        map.put("age", 12);
        map.put("job", "Engineer"); // may have additional keys
        return map;
    }
}
