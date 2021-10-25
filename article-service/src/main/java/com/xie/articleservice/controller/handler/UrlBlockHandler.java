package com.xie.articleservice.controller.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xie.articleservice.dto.ResponseObject;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiemouren
 */
@Component
public class UrlBlockHandler implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        String message = null;
        if (e instanceof FlowException){
            message = "接口以被限流";
        }else if (e instanceof DegradeException){
            message = "接口以被熔断";
        }else if (e instanceof ParamFlowException){
            message = "热点参数限流";
        }else if (e instanceof SystemBlockException){
            message = "系统规则（cpu负载过高/其他硬件不满足要求）";
        }else if (e instanceof AuthorityException){
            message = "授权规则不通过";
        }
        httpServletResponse.setStatus(500);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        // 设置json序列化时某个对象的属性为null不进行序列化输出
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.writeValue(httpServletResponse.getWriter(),
                new ResponseObject(e.getClass().getSimpleName(),message));
    }
}
