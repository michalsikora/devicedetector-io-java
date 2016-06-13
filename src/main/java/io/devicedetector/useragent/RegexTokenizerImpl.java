package io.devicedetector.useragent;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTokenizerImpl implements Tokenizer {
    @Override
    public List<Token> tokenize(String userAgent) {
        List<Token> tokens = new ArrayList<>();
        Pattern tokenPatterns = Pattern.compile(preparePattern());
        Matcher matcher = tokenPatterns.matcher(userAgent.toLowerCase());

        while (matcher.find()) {
            if (matcher.group(TokenType.TEXT.name()) != null) {
                tokens.add(new Token(TokenType.TEXT, matcher.group(TokenType.TEXT.name()), matcher.start()));
            } else if (matcher.group(TokenType.WHITESPACE.name()) != null) {
                tokens.add(new Token(TokenType.WHITESPACE, matcher.group(TokenType.WHITESPACE.name()).trim(), matcher.start()));
            } else if (matcher.group(TokenType.URL.name()) != null) {
                tokens.add(new Token(TokenType.URL, matcher.group(TokenType.URL.name()).trim(), matcher.start()));
            }
        }

        return tokens;
    }

    protected String preparePattern() {
        StringBuffer tokenPatternsBuffer = new StringBuffer();
        for (TokenType tokenType : TokenType.values()) {
            tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));
        }

        return tokenPatternsBuffer.substring(1);
    }
}
