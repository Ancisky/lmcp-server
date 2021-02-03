package com.kglab.lmcp.global.handle;

import com.kglab.lmcp.constant.StatusCode;
import com.kglab.lmcp.global.handle.exception.result.FailResultMessage;
import com.kglab.lmcp.global.handle.exception.result.RebutResultMessage;
import com.kglab.lmcp.global.handle.exception.result.ResultVoMessage;
import com.kglab.lmcp.global.handle.exception.result.SuccessResultMessage;

/**
 * TODO  响应类模板，依赖于{@link GlobalExceptionHandler#exceptionHandler(ResultVoMessage)}$
 *
 * @author sc
 * @date 2021/1/14
 */
public abstract class ResponseTemplate implements StatusCode {


    protected void success(){ success("Success", null); }

    protected void success(String msg){ success(msg, null); }

    protected void success(String msg, Object data){ throw new SuccessResultMessage(msg, data); }


    protected void fail(){ fail("Fail", null); }

    protected void fail(String msg){ fail(msg, null); }

    protected void fail(String msg, Object data){throw new FailResultMessage(msg, data);}


    protected void rebut(){ rebut("Rebut", null); }

    protected void rebut(String msg){ rebut(msg, null); }

    protected void rebut(String msg, Object data){ throw new RebutResultMessage(msg, data); }


    protected void custom(){ custom("Custom", null); }

    protected void custom(String msg){ custom(msg, null); }

    protected void custom(String msg, Object data){ throw new SuccessResultMessage(msg, data); }

}
