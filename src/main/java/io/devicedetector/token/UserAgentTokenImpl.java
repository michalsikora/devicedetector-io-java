package io.devicedetector.token;

public class UserAgentTokenImpl implements Token<String> {
    public final String userAgent;

    public UserAgentTokenImpl(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public String getData() {
        return userAgent;
    }

    @Override
    public String toString() {
        return userAgent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAgentTokenImpl)) return false;

        UserAgentTokenImpl that = (UserAgentTokenImpl) o;

        return userAgent.equals(that.userAgent);

    }

    @Override
    public int hashCode() {
        return userAgent.hashCode();
    }
}
