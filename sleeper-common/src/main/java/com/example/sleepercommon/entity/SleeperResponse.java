package com.example.sleepercommon.entity;

import java.util.HashMap;

/**
 * @author zhouxz
 * @date 2023/7/15 16:53
 * @description
 */
public class SleeperResponse extends HashMap<String, Object> {
    private static final long serialVersionUID = -8713837118340960775L;

    public SleeperResponse message(String message) {
        this.put("message", message);
        return this;
    }

    public SleeperResponse data(Object data) {
        this.put("data", data);
        return this;
    }

    @Override
    public SleeperResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public String getMessage() {
        return String.valueOf(get("message"));
    }

    public Object getData() {
        return get("data");
    }
}
