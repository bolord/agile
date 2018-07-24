package agile.service.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;

import agile.core.web.rest.common.entity.AuditingEntity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableLogic;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author Alex
 * @since 2018-07-05
 */
@TableName("sys_user")
public class User extends AuditingEntity<User> {

    private static final long serialVersionUID = 1L;


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String account;

    /**
     * 密码（加密后）
     */
    private String password;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 手机号码
     */
    private String mobileNum;

    /**
     * 身份证号码
     */
    private String idcardNum;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 用户所在城市
     */
    private String city;

    /**
     * 用户所在省份
     */
    private String province;

    /**
     * 用户所在国家
     */
    private String country;

    /**
     * 用户的语言，简体中文为zh_CN
     */
    private String language;

    /**
     * 默认设备ID
     */
    private Long defDeviceId;

    /**
     * 默认设备名称
     */
    private String defDeviceName;

    /**
     * 用户标签
     */
    private String tags;

    /**
     * 状态
     */
    @TableLogic
    private Integer status;


    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 用户名
     */
    public String getAccount() {
        return account;
    }

    public User setAccount(String account) {
        this.account = account;
        return this;
    }

    /**
     * 密码（加密后）
     */
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * 头像
     */
    public String getAvatar() {
        return avatar;
    }

    public User setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    /**
     * 手机号码
     */
    public String getMobileNum() {
        return mobileNum;
    }

    public User setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
        return this;
    }

    /**
     * 身份证号码
     */
    public String getIdcardNum() {
        return idcardNum;
    }

    public User setIdcardNum(String idcardNum) {
        this.idcardNum = idcardNum;
        return this;
    }

    /**
     * 用户昵称
     */
    public String getNickName() {
        return nickName;
    }

    public User setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    /**
     * 性别
     */
    public Integer getGender() {
        return gender;
    }

    public User setGender(Integer gender) {
        this.gender = gender;
        return this;
    }

    /**
     * 用户所在城市
     */
    public String getCity() {
        return city;
    }

    public User setCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * 用户所在省份
     */
    public String getProvince() {
        return province;
    }

    public User setProvince(String province) {
        this.province = province;
        return this;
    }

    /**
     * 用户所在国家
     */
    public String getCountry() {
        return country;
    }

    public User setCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     * 用户的语言，简体中文为zh_CN
     */
    public String getLanguage() {
        return language;
    }

    public User setLanguage(String language) {
        this.language = language;
        return this;
    }

    /**
     * 默认设备ID
     */
    public Long getDefDeviceId() {
        return defDeviceId;
    }

    public User setDefDeviceId(Long defDeviceId) {
        this.defDeviceId = defDeviceId;
        return this;
    }

    /**
     * 默认设备名称
     */
    public String getDefDeviceName() {
        return defDeviceName;
    }

    public User setDefDeviceName(String defDeviceName) {
        this.defDeviceName = defDeviceName;
        return this;
    }

    /**
     * 用户标签
     */
    public String getTags() {
        return tags;
    }

    public User setTags(String tags) {
        this.tags = tags;
        return this;
    }

    /**
     * 状态
     */
    public Integer getStatus() {
        return status;
    }

    public User setStatus(Integer status) {
        this.status = status;
        return this;
    }

    @Override
    protected Serializable getPrimaryKeyValue() {
        return this.id;
    }

}
