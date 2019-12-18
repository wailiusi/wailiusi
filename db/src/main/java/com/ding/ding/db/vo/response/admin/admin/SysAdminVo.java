package com.ding.ding.db.vo.response.admin.admin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@ApiModel
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SysAdminVo {
    @ApiModelProperty(notes = "主键")
    private Integer id;
    @ApiModelProperty(notes = "管理员名称")
    private String username;
    @ApiModelProperty(notes = "管理员密码")
    private String password;
    @ApiModelProperty(notes = "最近一次登录IP地址")
    private String lastLoginIp;
    @ApiModelProperty(notes = "最近一次登录时间")
    private LocalDateTime lastLoginTime;
    @ApiModelProperty(notes = "头像图片")
    private String avatar;
    @ApiModelProperty(notes = "创建时间")
    private LocalDateTime addTime;
    @ApiModelProperty(notes = "角色列表")
    private Integer[] roleIds;
}
