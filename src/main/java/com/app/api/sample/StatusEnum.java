package com.app.api.sample;

public enum StatusEnum {
    SELLING(Status.SELLING), SOLDOUT(Status.SOLDOUT);

    private final String status;

    StatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public static class Status{
        public static final String SELLING = "판매중입니다";
        public static final String SOLDOUT = "품절입니다";
    }


}
