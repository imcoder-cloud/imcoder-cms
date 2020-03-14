package fun.imcoder.cloud.handle;

import fun.imcoder.cloud.common.ResponseData;
import fun.imcoder.cloud.enums.ResponseEnum;
import fun.imcoder.cloud.exception.ImcoderException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//@ControllerAdvice
@Slf4j
public class ImcoderExceptionHandle {
    @ExceptionHandler(ImcoderException.PathAlreadyExists.class)
    @ResponseBody
    public ResponseData<String> HttpMediaTypeNotSupportedExceptionHandler(ImcoderException.PathAlreadyExists e) {
        return ResponseData.error(ResponseEnum.INCORRECT_PARAMS, e.getMessage());
    }

}
