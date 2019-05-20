package pl.grzeslowski.jsuplaservermock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;

import static com.google.common.base.Strings.emptyToNull;

@Component
class TokenFilter implements Filter {
    private static final String AUTHORIZATION_HEADER_PREFIX = "Bearer ";
    private final Logger logger = LoggerFactory.getLogger(TokenFilter.class);
    private final String token;

    TokenFilter(@Value("${jsupla.token}") final String token) {
        logger.info("Authorization uses token `{}`", token);
        this.token = emptyToNull(token);
    }

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain chain) throws IOException, ServletException {
        if (token == null) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader == null) {
            logger.warn("There is no authorization header!");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getOutputStream().write(("There is no authorization header!").getBytes(Charset.forName("UTF-8")));
            return;
        }
        if (!authorizationHeader.startsWith(AUTHORIZATION_HEADER_PREFIX)) {
            logger.warn("There is no `{}` prefix in authorization header!", AUTHORIZATION_HEADER_PREFIX);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getOutputStream().write(("Authorization header should be prefixed with `" + AUTHORIZATION_HEADER_PREFIX + "`!").getBytes(Charset.forName("UTF-8")));
            return;
        }
        String requestToken = authorizationHeader.substring(AUTHORIZATION_HEADER_PREFIX.length());
        if (token.equals(requestToken)) {
            chain.doFilter(servletRequest, servletResponse);
        } else {
            logger.warn("Wrong token `{}` during authorization!", requestToken);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getOutputStream().write(("Wrong token `" + requestToken + "` during authorization!").getBytes(Charset.forName("UTF-8")));
        }
    }
}
