package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class MyTeam {

public static final int TIMEOUT = 300;

/**
 *
 * MyTeam
 *
 * @param teamName
 * @param ownerName
 * @param team
 *
 * @author Root
 * @since 25/05/2022 15:31:57
 *
 */
public static Var Register(@ParamMetaData(description = "param_teamName", id = "08c3c9c3") Var param_teamName, @ParamMetaData(description = "param_ownerName", id = "4f14365a") Var param_ownerName, @ParamMetaData(description = "param_team", id = "a07e9d82") Var param_team) throws Exception {
 return new Callable<Var>() {

   // param
   private Var teamName = param_teamName;
   private Var ownerName = param_ownerName;
   private Var team = param_team;
   // end
   private Var userId = Var.VAR_NULL;
   private Var myTeam = Var.VAR_NULL;
   private Var transaction = Var.VAR_NULL;

   public Var call() throws Exception {
    userId =
    cronapi.util.Operations.callBlockly(Var.valueOf("blockly.UserManager:GetUserIdByLogin"), Var.valueOf("e986361b", Var.VAR_NULL));
    myTeam =
    cronapi.database.Operations.query(Var.valueOf("fc.entity.MyTeam"),Var.valueOf("select m from MyTeam m where m.userId = :userId"),Var.valueOf("userId",userId));
    if (
    cronapi.database.Operations.hasElement(myTeam)
    .negate().getObjectAsBoolean()) {
        myTeam =
        cronapi.database.Operations.newEntity(Var.valueOf("fc.entity.MyTeam"),Var.valueOf("ownerName",ownerName),Var.valueOf("teamName",teamName),Var.valueOf("team",team),Var.valueOf("tacticalScheme",
        Var.valueOf("4-3-3")),Var.valueOf("userId",userId));
        cronapi.database.Operations.insert(Var.valueOf("fc.entity.MyTeam"),myTeam);
        transaction =
        cronapi.database.Operations.newEntity(Var.valueOf("fc.entity.Transaction"),Var.valueOf("userId",userId),Var.valueOf("type",
        Var.valueOf("balance")),Var.valueOf("date",
        cronapi.dateTime.Operations.getNow()),Var.valueOf("value",
        Var.valueOf(100)));
        cronapi.database.Operations.insert(Var.valueOf("fc.entity.Transaction"),transaction);
    } else {
        cronapi.database.Operations.execute(Var.valueOf("fc.entity.MyTeam"), Var.valueOf("update MyTeam set teamName = :teamName, ownerName = :ownerName, team = :team where userId = :userId"),Var.valueOf("teamName",teamName),Var.valueOf("ownerName",ownerName),Var.valueOf("team",team),Var.valueOf("userId",userId));
    }
    return Var.VAR_NULL;
   }
 }.call();
}

}

