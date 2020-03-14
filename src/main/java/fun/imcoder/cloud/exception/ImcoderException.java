package fun.imcoder.cloud.exception;

public class ImcoderException extends Exception {
    private String message;

    public ImcoderException(String msg) {
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }

    public static class PathAlreadyExists extends ImcoderException {
        public PathAlreadyExists(String msg) {
            super(msg);
        }
    }

}
