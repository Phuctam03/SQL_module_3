package mvc.module3_accountname.model;

public class User_Role {
      private Role role_id;
      private User username ;


      public  User_Role(){}

      public User_Role(Role role_id, User username) {
            this.role_id = role_id;
            this.username = username;
      }

      public Role getRole_id() {
            return role_id;
      }

      public void setRole_id(Role role_id) {
            this.role_id = role_id;
      }

      public User getUsername() {
            return username;
      }

      public void setUsername(User username) {
            this.username = username;
      }
}
