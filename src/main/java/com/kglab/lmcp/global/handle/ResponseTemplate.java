package com.kglab.lmcp.global.handle;

import com.kglab.lmcp.constant.StatusCode;
import com.kglab.lmcp.global.handle.exception.result.ResultVoMessage;

/**
 * TODO  响应类模板，依赖于{@link GlobalExceptionHandler#exceptionHandler(ResultVoMessage)}$
 *
 * @author sc
 * @date 2021/1/14
 */
public abstract class ResponseTemplate implements StatusCode {


    protected void success(){ success("Success", null); }

    protected void success(String msg){ success(msg, null); }

    protected void success(String msg, Object data){ response(SUCCESS, msg, data); }


    protected void fail(){ fail("Fail", null); }

    protected void fail(String msg){ fail(msg, null); }

    protected void fail(String msg, Object data){response(FAIL, msg, data);}


    protected void rebut(){ rebut("Rebut", null); }

    protected void rebut(String msg){ rebut(msg, null); }

    protected void rebut(String msg, Object data){ response(REBUT, msg, data); }


    protected void custom(){ custom("Custom", null); }

    protected void custom(String msg){ custom(msg, null); }

    protected void custom(String msg, Object data){ response(CUSTOM, msg, data); }

    /**
     * TODO 响应请求（调用此方法后函数结束）
     * @param
     * @return void
     * @author sc
     * @date 2021/1/14
     */
    protected void response(int no, String msg, Object data){
        throw new ResultVoMessage(no, msg, data);
    }
}
