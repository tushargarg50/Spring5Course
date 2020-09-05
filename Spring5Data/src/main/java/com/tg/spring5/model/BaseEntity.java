package com.tg.spring5.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    private static Long CURRENT_ID = 0L;

    private Long id;

    public static Long getCurrentId() {
        return CURRENT_ID;
    }

    public static Long getNextId() {
        CURRENT_ID = CURRENT_ID + 1L;
        return CURRENT_ID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                '}';
    }
}
