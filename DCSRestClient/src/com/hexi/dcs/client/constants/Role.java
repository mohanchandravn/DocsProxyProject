package com.hexi.dcs.client.constants;

import javax.annotation.Generated;


@Generated("run|b8272d2f-c42c-4f65-b22b-d79d71c0c086")
public enum Role {

    VIEWER("viewer"),
    DOWNLOADER("downloader"),
    CONTRIBUTOR("contributor"),
    MANAGER("manager");
    private String stringVal;

    private Role(String v) {
        stringVal = v;
    }

    public String toString() {
        return stringVal;
    }

}
