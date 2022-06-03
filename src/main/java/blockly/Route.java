package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity(get = "Public", execute = "Public")
public class Route {

public static final int TIMEOUT = 300;

/**
 *
 * Route
 *
 * @param login
 *
 * @author Root
 * @since 25/05/2022 14:58:44
 *
 */
public static Var ToTake(@ParamMetaData(description = "param_login", id = "c19ec136") Var param_login) throws Exception {
 return new Callable<Var>() {

   // param
   private Var login = param_login;
   // end
   private Var userId = Var.VAR_NULL;
   private Var myTeam = Var.VAR_NULL;
   private Var route = Var.VAR_NULL;

   public Var call() throws Exception {
    if (
    cronapi.logic.Operations.isNullOrEmpty(login).getObjectAsBoolean()) {
        login =
        cronapi.util.Operations.getCurrentUserName();
    }
    userId =
    cronapi.util.Operations.callBlockly(Var.valueOf("blockly.UserManager:GetUserIdByLogin"), Var.valueOf("e986361b", login));
    myTeam =
    cronapi.database.Operations.query(Var.valueOf("fc.entity.MyTeam"),Var.valueOf("select m from MyTeam m where m.userId = :userId"),Var.valueOf("userId",userId));
    if (
    Var.valueOf(
    cronapi.database.Operations.hasElement(myTeam)
    .negate().getObjectAsBoolean() ||
    cronapi.logic.Operations.isNullOrEmpty(
    cronapi.database.Operations.getField(myTeam,
    Var.valueOf("this[0].teamName"))).getObjectAsBoolean()).getObjectAsBoolean()) {
        route =
        Var.valueOf("my-team");
    } else {
        route =
        Var.valueOf("pick-player");
    }
    return route;
   }
 }.call();
}

}

