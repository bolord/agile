package agile.core.web.rest.common.result.builder;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;

import com.alibaba.fastjson.JSON;

import agile.core.web.rest.common.result.Result;

public abstract class ResultResponseBuilder {

    public static HttpServletResponse build(HttpServletResponse response, int status,
            boolean success, String code, String message) {
        Result result = new Result(success, code, message);

        response.setContentType(MediaType.APPLICATION_JSON_UTF8.toString());
        response.setStatus(status);

        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (writer != null) {
            writer.println(JSON.toJSONString(result, false));
            writer.flush();
            writer.close();
        }

        return response;
    }

}
