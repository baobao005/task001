package org.hotel.vo;

public class Result<T> {


        private int code;
        private String message;
        private T result;

        public Result() {
        }

        public Result(Builder<T> builder) {
            this.code = builder.code;
            this.message = builder.message;
            this.result = builder.result;
        }

        public static class Builder<T> {
            private int code;
            private String message;
            private T result;

            public Builder() {
            }

            public Result buildCustomize(int code, String message) {
                this.code = code;
                this.message = message;
                return new Result(this);
            }
            public Result buildOk() {
                this.code = 200;
                this.message = "成功";
                return new Result(this);
            }

            public Result buildFail() {
                this.code = 500;
                this.message = "失败";
                return new Result(this);
            }
            public Result buildError() {
                this.code = 500;
                this.message = "错误";
                return new Result(this);
            }

            public Builder setResult(T result) {
                this.result = result;
                return this;
            }

            @Override
            public String toString() {
                return "Builder{" +
                        "code=" + code +
                        ", message='" + message + '\'' +
                        ", result=" + result +
                        '}';
            }
        }
        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public T getResult() {
            return result;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "code=" + code +
                    ", message='" + message + '\'' +
                    ", result=" + result +
                    '}';
        }

}
