package io.devicedetector.device;

import java.util.HashMap;

public class KeyValueDevice extends HashMap<String, Object> implements Device {
    @Override
    public boolean isValid() {
        return size() > 0;
    }
}
