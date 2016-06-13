package io.devicedetector.detector;

import io.devicedetector.device.KeyValueDevice;
import io.devicedetector.token.Token;
import io.devicedetector.visitor.Manager;
import io.devicedetector.visitor.SetManagerImpl;

import java.util.Set;

public class TokenPoolDetectorImpl implements Detector<Set<Token>, KeyValueDevice> {
    private final Manager manager;

    public TokenPoolDetectorImpl(Manager manager) {
        this.manager = manager;
    }

    public TokenPoolDetectorImpl() {
        this(new SetManagerImpl());
    }

    @Override
    public KeyValueDevice detect(Set<Token> input) {
        KeyValueDevice device = new KeyValueDevice();

        manager.visit(input, device);

        return device;
    }
}
