package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class UserManager {

public static final int TIMEOUT = 300;

/**
 *
 * UserManager
 *
 * @param Entidade<app.entity.User>
 *
 * @author Root
 * @since 23/05/2022 16:43:46
 *
 */
public static Var BeforeDelete(@ParamMetaData(description = "Entidade", id = "3f923a9d") Var Entidade) throws Exception {
 return new Callable<Var>() {

   private Var authorizations = Var.VAR_NULL;
   private Var administrators = Var.VAR_NULL;

   public Var call() throws Exception {
    authorizations =
    cronapi.database.Operations.query(Var.valueOf("app.entity.UserRole"),Var.valueOf("select u from UserRole u where u.user = :user AND u.role.normalizedName = :roleNormalizedName"),Var.valueOf("user",Entidade),Var.valueOf("roleNormalizedName",
    Var.valueOf("administrators")));
    if (
    Var.valueOf(
    cronapi.list.Operations.size(authorizations).compareTo(
    Var.valueOf(0)) > 0).getObjectAsBoolean()) {
        administrators =
        cronapi.database.Operations.query(Var.valueOf("app.entity.UserRole"),Var.valueOf("select u.user from UserRole u where u.role.normalizedName = :roleNormalizedName"),Var.valueOf("roleNormalizedName",
        Var.valueOf("administrators")));
        if ((
        Var.valueOf(
        cronapi.list.Operations.size(administrators).compareTo(
        Var.valueOf(1)) > 0))
        .negate().getObjectAsBoolean()) {
            cronapi.util.Operations.throwException(
            cronapi.util.Operations.createException(
            cronapi.i18n.Operations.translate(Var.valueOf("UserManagerBlockly"))));
        }
    }
    return Entidade;
   }
 }.call();
}

/**
 *
 * UserManager
 *
 * @param Entidade<app.entity.User>
 *
 * @author Root
 * @since 23/05/2022 16:43:46
 *
 */
public static Var BeforeInsert(@ParamMetaData(description = "param_Entidade", id = "caee5f29") Var param_Entidade) throws Exception {
 return new Callable<Var>() {

   // param
   private Var Entidade = param_Entidade;
   // end

   public Var call() throws Exception {
    Entidade =
    Var.valueOf(BeforeDelete(Entidade));
    return Entidade;
   }
 }.call();
}

/**
 *
 * UserManager
 *
 * @param Entidade<app.entity.User>
 *
 * @author Root
 * @since 23/05/2022 16:43:46
 *
 */
public static Var BeforeUpdate(@ParamMetaData(description = "param_Entidade", id = "bb6c3b84") Var param_Entidade) throws Exception {
 return new Callable<Var>() {

   // param
   private Var Entidade = param_Entidade;
   // end

   public Var call() throws Exception {
    Entidade =
    Var.valueOf(BeforeDelete(Entidade));
    return Entidade;
   }
 }.call();
}

 /*
 * @param login
 *
 * @author Root
 * @since 23/05/2022 16:43:46
 *
 */
public static Var GetUserIdByLogin(@ParamMetaData(description = "param_login", id = "e986361b") Var param_login) throws Exception {
 return new Callable<Var>() {

   // param
   private Var login = param_login;
   // end
   private Var users = Var.VAR_NULL;
   private Var id2 = Var.VAR_NULL;

   public Var call() throws Exception {
    if (
    cronapi.logic.Operations.isNullOrEmpty(login).getObjectAsBoolean()) {
        login =
        cronapi.util.Operations.getCurrentUserName();
    }
    users =
    cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select u from User u where u.userName = :userName"),Var.valueOf("userName",login));
    if (
    cronapi.database.Operations.hasElement(users).getObjectAsBoolean()) {
        id2 =
        cronapi.database.Operations.getField(users,
        Var.valueOf("this[0].id"));
    }
    return id2;
   }
 }.call();
}

/**
 *
 * Descreva esta função...
 *
 * @param Entidade<app.entity.User>
 *
 * @author Root
 * @since 23/05/2022 16:43:46
 *
 */
public static Var Normalize(@ParamMetaData(description = "Entidade", id = "9becc432") Var Entidade) throws Exception {
 return new Callable<Var>() {

   private Var userName = Var.VAR_NULL;
   private Var email = Var.VAR_NULL;

   public Var call() throws Exception {
    userName =
    cronapi.text.Operations.normalize(
    cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("userName")));
    email =
    cronapi.text.Operations.normalize(
    cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("email")));
    cronapi.object.Operations.setObjectField(Entidade, Var.valueOf("normalizedUserName"), userName);
    cronapi.object.Operations.setObjectField(Entidade, Var.valueOf("normalizedEmail"), email);
    return Entidade;
   }
 }.call();
}

}

