package ysq.com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Describle:
 * @Author: yangsongqing
 * @Date: 2017/11/28 11:44
 */
@Table(name = "t_user")
public class User implements Serializable {
    private static final long serialVersionUID = 166202443522768309L;
    @Column(name = "userAddress")
    private String userAddress;
    @Column(name = "chainId")
    private String chainId;
    @Column(name = "name")
    private String name;
    @Column(name = "departmentId")
    private String departmentId;
    @Column(name = "account")
    private String account;
    @Column(name = "ownerAddr")
    private String ownerAddr;

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getOwnerAddr() {
        return ownerAddr;
    }

    public void setOwnerAddr(String ownerAddr) {
        this.ownerAddr = ownerAddr;
    }
}
