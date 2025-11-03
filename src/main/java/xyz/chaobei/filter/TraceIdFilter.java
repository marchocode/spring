package xyz.chaobei.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TraceId 过滤器
 * @author mrc
 * @since 25/08/20
 */
@Component
@WebFilter(urlPatterns = "/api/*")
@Order(1)
public class TraceIdFilter implements Filter {

    private static final String TRACE_ID_HEADER = "X-Trace-Id";
    private final Logger logger = LoggerFactory.getLogger(TraceIdFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        try {
            long startTime = System.currentTimeMillis();
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            String traceId = req.getHeader(TRACE_ID_HEADER);

            String uri = req.getRequestURI();

            if (traceId == null || traceId.isEmpty()) {
                traceId = java.util.UUID.randomUUID().toString();
            }

            resp.addHeader(TRACE_ID_HEADER, traceId);
            MDC.put("traceId", traceId);
            chain.doFilter(request, response);

            long duration = System.currentTimeMillis() - startTime;
            logger.info("api monitor {} took {} ms", uri, duration);
        } finally {
            MDC.remove("traceId");
        }
    }
}