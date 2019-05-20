package pl.grzeslowski.jsuplaservermock;

import io.github.glytching.junit.extension.random.Random;
import io.github.glytching.junit.extension.random.RandomBeansExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

@SuppressWarnings("WeakerAccess")
@ExtendWith(MockitoExtension.class)
@ExtendWith(RandomBeansExtension.class)
class TokenFilterTest {
    TokenFilter filter;

    @Mock HttpServletRequest request;
    @Mock HttpServletResponse response;
    @Mock ServletOutputStream servletOutputStream;
    @Mock FilterChain chain;

    @Random String token;

    @BeforeEach
    void setUpFilter() {
        filter = new TokenFilter(token);
    }

    @Test
    @DisplayName("should write 403 to response if token is not correct")
    void wrongToken(@Random final String wrongToken) throws IOException, ServletException {
        // given
        given(request.getHeader("Authorization")).willReturn("Bearer " + wrongToken);
        given(response.getOutputStream()).willReturn(servletOutputStream);

        // when
        filter.doFilter(request, response, chain);

        //then
        verify(response).setStatus(HttpServletResponse.SC_FORBIDDEN);
        verify(servletOutputStream).write(("Wrong token `" + wrongToken + "` during authorization!").getBytes(Charset.forName("UTF-8")));
        verifyZeroInteractions(chain);
    }

    @Test
    @DisplayName("should continue chain filter if token is orrect")
    void correctToken() throws IOException, ServletException {
        // given
        given(request.getHeader("Authorization")).willReturn("Bearer " + token);

        // when
        filter.doFilter(request, response, chain);

        //then
        verify(chain).doFilter(request, response);
        verifyZeroInteractions(response);
        verifyZeroInteractions(servletOutputStream);
    }

    @Test
    @DisplayName("should write 401 if 'Bearer ' prefix is not present")
    void bearer() throws IOException, ServletException {
        // given
        given(request.getHeader("Authorization")).willReturn(token);
        given(response.getOutputStream()).willReturn(servletOutputStream);

        // when
        filter.doFilter(request, response, chain);

        //then
        verify(response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        verify(servletOutputStream).write(("Authorization header should be prefixed with `Bearer `!").getBytes(Charset.forName("UTF-8")));
        verifyZeroInteractions(chain);
    }

    @Test
    @DisplayName("should write 401 if there is no authorization header")
    void nullHeader() throws IOException, ServletException {
        // given
        given(request.getHeader("Authorization")).willReturn(null);
        given(response.getOutputStream()).willReturn(servletOutputStream);

        // when
        filter.doFilter(request, response, chain);

        //then
        verify(response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        verify(servletOutputStream).write(("There is no authorization header!").getBytes(Charset.forName("UTF-8")));
        verifyZeroInteractions(chain);
    }

    @Test
    @DisplayName("should authorize if url is in url not to authorize")
    void contextPath() throws IOException, ServletException {
        // given
        final String contextPath = "/context-path";
        final String url = "/api-docs";
        given(request.getRequestURI()).willReturn(contextPath + url);
        given(request.getContextPath()).willReturn(contextPath);

        // when
        filter.doFilter(request, response, chain);

        // then
        verify(chain).doFilter(request, response);
        verifyZeroInteractions(response);
        verifyZeroInteractions(servletOutputStream);
    }

    @ParameterizedTest
    @MethodSource("emptyTokenParams")
    @DisplayName("should not do authorization if token is empty")
    void emptyToken(String token) throws IOException, ServletException {
        // given
        filter = new TokenFilter(token);

        // when
        filter.doFilter(request, response, chain);

        //then
        verify(chain).doFilter(request, response);
        verifyZeroInteractions(response);
        verifyZeroInteractions(servletOutputStream);
    }

    static List<String> emptyTokenParams() {
        List<String> strings = new ArrayList<>(2);
        strings.add("");
        strings.add(null);
        return strings;
    }
}
