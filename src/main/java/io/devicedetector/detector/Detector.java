package io.devicedetector.detector;

import io.devicedetector.device.Device;

import java.util.Map;

public interface Detector<I, O extends Map & Device> {
    O detect(I input);
}
