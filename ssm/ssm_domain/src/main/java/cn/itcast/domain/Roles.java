package cn.itcast.domain;

import java.util.List;

public class Roles {
    private String id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissions;
    private UserInfo users;

    public UserInfo getUsers() {
        return users;
    }

    public void setUsers(UserInfo users) {
        this.users = users;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

}
