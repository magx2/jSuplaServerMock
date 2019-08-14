package pl.grzeslowski.jsuplaservermock;

import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Random;

@Component
class LatencyFilter implements Filter {
    private final Random random = new Random();

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain chain) throws IOException, ServletException {
        sleep(random.nextInt(2_000) + 1);
        chain.doFilter(servletRequest, servletResponse);
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            // nah
        }
    }
}
