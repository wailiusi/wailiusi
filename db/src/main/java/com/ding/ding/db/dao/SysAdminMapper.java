package com.ding.ding.db.dao;

import com.ding.ding.db.domain.SysAdmin;
import com.ding.ding.db.domain.SysAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAdminMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated
     */
    long countByExample(SysAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated
     */
    int deleteByExample(SysAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated
     */
    int insert(SysAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated
     */
    int insertSelective(SysAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SysAdmin selectOneByExample(SysAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SysAdmin selectOneByExampleSelective(@Param("example") SysAdminExample example, @Param("selective") SysAdmin.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<SysAdmin> selectByExampleSelective(@Param("example") SysAdminExample example, @Param("selective") SysAdmin.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated
     */
    List<SysAdmin> selectByExample(SysAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SysAdmin selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") SysAdmin.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated
     */
    SysAdmin selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SysAdmin selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SysAdmin record, @Param("example") SysAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SysAdmin record, @Param("example") SysAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByExample(@Param("example") SysAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_admin
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByPrimaryKey(Integer id);
}