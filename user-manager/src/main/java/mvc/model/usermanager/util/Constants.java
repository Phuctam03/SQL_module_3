package mvc.model.usermanager.util;

public class Constants {
    public  static  final  String FIND_ALL_USER = "Select * from users ";
    public  static  final  String FIND_USER_BY_ID = "Select * from users where id = ?";
    public  static  final  String CREATE_USER = "insert into users(name,email,country) values(?,?,?)";
    public  static  final  String DELETE_USER_BY_ID = "delete from users where id = ?";
    public  static  final  String FIND_USER_BY_COUNTRY = "Select * from users where country = ?";
    public  static  final  String SORT_BY_NAME = "Select * from users ORDER BY name ASC";
    public  static  final String UPDATE_USER = "update users set name = ? ,email = ?,country=? where id = ? ";
}
