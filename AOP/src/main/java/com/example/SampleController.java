package com.example;

import com.example.annotation.MethodExporter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SampleController {

    @MethodExporter("test")
    @GetMapping("/list")
    public Map list() {
        Map result = new HashMap();
        result.put("code", 0);
        return result;
    }
}
