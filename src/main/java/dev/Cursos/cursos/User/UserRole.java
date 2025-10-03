package dev.Cursos.cursos.User;

public enum UserRole {
    USER("user"),
    ADMIN("admin");

    private String roleName;

    UserRole(String role) {
        this.roleName = role;
    }
    
    public String getRoleName() {
        return roleName;
    }  
}
