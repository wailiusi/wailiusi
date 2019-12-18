package com.ding.ding.admin.dto.admin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class AdminLogin {
    @ApiModelProperty(notes = "名称")
    @NotBlank(message = "姓名不可为空")
    private String username;
    @ApiModelProperty(notes = "密码")
    @NotBlank(message = "密码不可为空")
    private String password;
    @ApiModelProperty(notes = "头像")
    private String avatar;

}
