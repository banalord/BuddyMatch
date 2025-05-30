package com.xj.bm.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户退出队伍请求体
 *
 */
@Data
public class TeamQuitRequest implements Serializable {


    private static final long serialVersionUID = 3436584751862553389L;

    /**
     * id
     */
    private Long teamId;

}
