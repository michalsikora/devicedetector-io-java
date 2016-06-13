package io.devicedetector.useragent;

import org.junit.Test;

import java.util.List;

public class RegexTokenizerImplTest {

    @Test
    public void itShouldTokenizeUserAgent() throws Exception {
        RegexTokenizerImpl tokenizer = new RegexTokenizerImpl();

        List<Token> tokens = tokenizer.tokenize("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0); 360Spider(compatible; HaosouSpider; http://www.haosou.com/help/help_3_2.html)");
        return;
    }
}