package com.chen.medicalsystembackend.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 删除请求
 *
 * @auther <a href="https://github.com/IceProgramer">chenjiahan</a>
 * @create 2023/4/4 22:24
 */
@Data
public class DeleteRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}