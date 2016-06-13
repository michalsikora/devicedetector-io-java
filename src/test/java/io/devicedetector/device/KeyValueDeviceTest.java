package io.devicedetector.device;

import org.junit.Test;

import static org.junit.Assert.*;

public class KeyValueDeviceTest {

    @Test
    public void itShouldBeValidIfMapContainsAtLeastOneElement() {
        KeyValueDevice device = new KeyValueDevice();

        assertFalse(device.isValid());

        device.put("browser_name", "Google Chrome");

        assertTrue(device.isValid());
    }
}