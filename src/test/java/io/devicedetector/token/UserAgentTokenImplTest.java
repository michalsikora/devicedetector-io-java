package io.devicedetector.token;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserAgentTokenImplTest {

    @Test
    public void itShouldReturnUserAgent() {
        String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36";
        UserAgentTokenImpl token = new UserAgentTokenImpl(userAgent);

        assertEquals(userAgent, token.getData());
    }

    @Test
    public void itShouldBeEqualsWithSameUserAgent() {
        String userAgent1 = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36";
        String userAgent2 = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36";
        String userAgent3 = "Mozilla/4.78 [en] (Win98; U)";

        UserAgentTokenImpl token1 = new UserAgentTokenImpl(userAgent1);
        UserAgentTokenImpl token2 = new UserAgentTokenImpl(userAgent2);
        UserAgentTokenImpl token3 = new UserAgentTokenImpl(userAgent3);

        assertEquals(token1, token2);
        assertNotEquals(token1, token3);
    }
}