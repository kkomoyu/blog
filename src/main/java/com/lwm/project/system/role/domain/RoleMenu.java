package com.lwm.project.system.role.domain;

import lombok.Data;

/**
 * @Auther: guya
 * @Date: 2020/3/21 21:53
 * @Description: 色和菜单关联 sys_role_menu
 */
@Data
public class RoleMenu {
    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 菜单ID
     */
    private Long menuId;

}