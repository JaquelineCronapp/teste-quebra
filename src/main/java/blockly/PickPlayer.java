package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class PickPlayer {

public static final int TIMEOUT = 300;

/**
 *
 * @author Root
 * @since 02/06/2022 16:31:41
 *
 */
public static Var CalculateTeamPrice() throws Exception {
 return new Callable<Var>() {

   private Var userId = Var.VAR_NULL;
   private Var myTeam = Var.VAR_NULL;
   private Var total = Var.VAR_NULL;

   public Var call() throws Exception {
    userId =
    cronapi.util.Operations.callBlockly(Var.valueOf("blockly.UserManager:GetUserIdByLogin"), Var.valueOf("e986361b", Var.VAR_NULL));
    myTeam =
    cronapi.database.Operations.query(Var.valueOf("fc.entity.MyTeam"),Var.valueOf("select m from MyTeam m where m.userId = :userId"),Var.valueOf("userId",userId));
    total =
    Var.valueOf(0);
    total =
    cronapi.math.Operations.sum(total,
    cronapi.database.Operations.getField(myTeam,
    Var.valueOf("this[0].player1.price")),
    cronapi.database.Operations.getField(myTeam,
    Var.valueOf("this[0].player2.price")),
    cronapi.database.Operations.getField(myTeam,
    Var.valueOf("this[0].player3.price")));
    total =
    cronapi.math.Operations.sum(total,
    cronapi.database.Operations.getField(myTeam,
    Var.valueOf("this[0].player4.price")),
    cronapi.database.Operations.getField(myTeam,
    Var.valueOf("this[0].player5.price")),
    cronapi.database.Operations.getField(myTeam,
    Var.valueOf("this[0].player6.price")));
    total =
    cronapi.math.Operations.sum(total,
    cronapi.database.Operations.getField(myTeam,
    Var.valueOf("this[0].player7.price")),
    cronapi.database.Operations.getField(myTeam,
    Var.valueOf("this[0].player8.price")),
    cronapi.database.Operations.getField(myTeam,
    Var.valueOf("this[0].player9.price")));
    total =
    cronapi.math.Operations.sum(total,
    cronapi.database.Operations.getField(myTeam,
    Var.valueOf("this[0].player10.price")),
    cronapi.database.Operations.getField(myTeam,
    Var.valueOf("this[0].player11.price")),
    cronapi.database.Operations.getField(myTeam,
    Var.valueOf("this[0].coach.price")));
    return total;
   }
 }.call();
}

/**
 *
 * @author Root
 * @since 02/06/2022 16:31:41
 *
 */
public static Var GetAllPlayersIdsFromTeam() throws Exception {
 return new Callable<Var>() {

   private Var myTeam = Var.VAR_NULL;
   private Var ids = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var i_start = Var.VAR_NULL;
   private Var i_end = Var.VAR_NULL;
   private Var i_inc = Var.VAR_NULL;

   public Var call() throws Exception {
    myTeam =
    cronapi.database.Operations.query(Var.valueOf("fc.entity.MyTeam"),Var.valueOf("select m from MyTeam m where m.userId = :userId"),Var.valueOf("userId",
    cronapi.util.Operations.callBlockly(Var.valueOf("blockly.UserManager:GetUserIdByLogin"), Var.valueOf("e986361b", Var.VAR_NULL))));
    ids =
    cronapi.list.Operations.newList();
    i_start =
    Var.valueOf(1);
    i_end =
    Var.valueOf(11);
    i_inc =
    Var.valueOf(1);
    if (i_start.greaterThan(i_end)) {
        i_inc.multiply(-1);
    }
    for (i = Var.valueOf(i_start);
        i_inc.getObjectAsInt() >= 0 ? i.getObjectAsLong() <= i_end.getObjectAsLong() : i.getObjectAsLong()  >= i_end.getObjectAsLong();
    i.inc(i_inc))  {
        if (
        cronapi.logic.Operations.isNullOrEmpty(
        cronapi.database.Operations.getField(myTeam,
        Var.valueOf(
        Var.valueOf("this[0].player").getObjectAsString() +
        i.getObjectAsString())))
        .negate().getObjectAsBoolean()) {
            cronapi.list.Operations.addLast(ids,
            cronapi.database.Operations.getField(myTeam,
            Var.valueOf(
            Var.valueOf("this[0].player").getObjectAsString() +
            i.getObjectAsString() +
            Var.valueOf(".id").getObjectAsString())));
        }
    } // end for
    i_start =
    Var.valueOf(1);
    i_end =
    Var.valueOf(4);
    i_inc =
    Var.valueOf(1);
    if (i_start.greaterThan(i_end)) {
        i_inc.multiply(-1);
    }
    for (i = Var.valueOf(i_start);
        i_inc.getObjectAsInt() >= 0 ? i.getObjectAsLong() <= i_end.getObjectAsLong() : i.getObjectAsLong()  >= i_end.getObjectAsLong();
    i.inc(i_inc))  {
        if (
        cronapi.logic.Operations.isNullOrEmpty(
        cronapi.database.Operations.getField(myTeam,
        Var.valueOf(
        Var.valueOf("this[0].playerReserve").getObjectAsString() +
        i.getObjectAsString())))
        .negate().getObjectAsBoolean()) {
            cronapi.list.Operations.addLast(ids,
            cronapi.database.Operations.getField(myTeam,
            Var.valueOf(
            Var.valueOf("this[0].playerReserve").getObjectAsString() +
            i.getObjectAsString() +
            Var.valueOf(".id").getObjectAsString())));
        }
    } // end for
    if (
    cronapi.logic.Operations.isNullOrEmpty(
    cronapi.database.Operations.getColumn(myTeam,
    Var.valueOf("this[0].coach")))
    .negate().getObjectAsBoolean()) {
        cronapi.list.Operations.addLast(ids,
        cronapi.database.Operations.getColumn(myTeam,
        Var.valueOf("this[0].coach.id")));
    }
    return ids;
   }
 }.call();
}

/**
 *
 * @param player
 * @param playerId
 * @param myTeam
 *
 * @author Root
 * @since 02/06/2022 16:31:41
 *
 */
public static Var HasBalanceToBuy(@ParamMetaData(description = "player", id = "680159ed") Var player, @ParamMetaData(description = "playerId", id = "b79d37f6") Var playerId, @ParamMetaData(description = "myTeam", id = "8d3ccebc") Var myTeam) throws Exception {
 return new Callable<Var>() {

   private Var balance = Var.VAR_NULL;
   private Var currentPlayerPrice = Var.VAR_NULL;
   private Var newPlayerPrice = Var.VAR_NULL;

   public Var call() throws Exception {
    balance =
    cronapi.list.Operations.getFirst((
    cronapi.database.Operations.query(Var.valueOf("fc.entity.Transaction"),Var.valueOf("select SUM(t.value) from Transaction t where t.userId = :userId"),Var.valueOf("userId",
    cronapi.util.Operations.callBlockly(Var.valueOf("blockly.UserManager:GetUserIdByLogin"), Var.valueOf("e986361b", Var.VAR_NULL))))));
    currentPlayerPrice =
    /*# sourceMappingStart=y]Pi(A0(SvN8H#iVc@s{ */
    ( cronapi.logic.Operations.isNullOrEmpty(
    cronapi.database.Operations.getField(myTeam,
    Var.valueOf(
    Var.valueOf("this[0].").getObjectAsString() +
    player.getObjectAsString())))
    .negate().getObjectAsBoolean() ?
    cronapi.database.Operations.getField(myTeam,
    Var.valueOf(
    Var.valueOf("this[0].").getObjectAsString() +
    player.getObjectAsString() +
    Var.valueOf(".price").getObjectAsString())) :
    Var.valueOf(0));
    newPlayerPrice =
    /*# sourceMappingStart=dWaAU!~_Y!4ONn[?Bdhm */
    ( cronapi.logic.Operations.isNullOrEmpty(playerId)
    .negate().getObjectAsBoolean() ?
    cronapi.database.Operations.getField(
    cronapi.database.Operations.query(Var.valueOf("fc.entity.Player"),Var.valueOf("select p from Player p where p.id = :id"),Var.valueOf("id",playerId)),
    Var.valueOf("this[0].price")) :
    Var.valueOf(0));
    return
Var.valueOf(newPlayerPrice.compareTo((
cronapi.math.Operations.sum(balance,currentPlayerPrice))) <= 0);
   }
 }.call();
}

/**
 *
 * Descreva esta função...
 *
 * @author Root
 * @since 02/06/2022 16:31:41
 *
 */
public static void LoadPlayers() throws Exception {
  new Callable<Var>() {

   private Var myTeam = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var i_start = Var.VAR_NULL;
   private Var i_end = Var.VAR_NULL;
   private Var i_inc = Var.VAR_NULL;
   private Var playerOrCoach = Var.VAR_NULL;
   private Var indexOrEmpty = Var.VAR_NULL;
   private Var playerInMyTeam = Var.VAR_NULL;
   private Var playerReserve = Var.VAR_NULL;

   public Var call() throws Exception {
    myTeam =
    cronapi.database.Operations.query(Var.valueOf("fc.entity.MyTeam"),Var.valueOf("select m from MyTeam m where m.userId = :userId"),Var.valueOf("userId",
    cronapi.util.Operations.callBlockly(Var.valueOf("blockly.UserManager:GetUserIdByLogin"), Var.valueOf("e986361b", Var.VAR_NULL))));
    i_start =
    Var.valueOf(1);
    i_end =
    Var.valueOf(12);
    i_inc =
    Var.valueOf(1);
    if (i_start.greaterThan(i_end)) {
        i_inc.multiply(-1);
    }
    for (i = Var.valueOf(i_start);
        i_inc.getObjectAsInt() >= 0 ? i.getObjectAsLong() <= i_end.getObjectAsLong() : i.getObjectAsLong()  >= i_end.getObjectAsLong();
    i.inc(i_inc))  {
        playerOrCoach =
        /*# sourceMappingStart=E:bx}X7Fo6,HIwg^lviT */
        ( Var.valueOf(i.compareTo(
        Var.valueOf(12)) < 0).getObjectAsBoolean() ?
        Var.valueOf("player") :
        Var.valueOf("coach"));
        indexOrEmpty =
        /*# sourceMappingStart=yXRQY~|6#zg%6]]|BJ-A */
        ( Var.valueOf(i.compareTo(
        Var.valueOf(12)) < 0).getObjectAsBoolean() ? i :
        Var.valueOf(""));
        playerInMyTeam =
        cronapi.logic.Operations.isNullOrEmpty(
        cronapi.database.Operations.getField(myTeam,
        Var.valueOf(
        Var.valueOf(
        Var.valueOf("this[0].").getObjectAsString() +
        playerOrCoach.getObjectAsString()).getObjectAsString() +
        indexOrEmpty.getObjectAsString())))
        .negate();
        SetPlayerContent(
        Var.valueOf(
        playerOrCoach.getObjectAsString() +
        indexOrEmpty.getObjectAsString()), myTeam, playerInMyTeam);
    } // end for
    i_start =
    Var.valueOf(1);
    i_end =
    Var.valueOf(4);
    i_inc =
    Var.valueOf(1);
    if (i_start.greaterThan(i_end)) {
        i_inc.multiply(-1);
    }
    for (i = Var.valueOf(i_start);
        i_inc.getObjectAsInt() >= 0 ? i.getObjectAsLong() <= i_end.getObjectAsLong() : i.getObjectAsLong()  >= i_end.getObjectAsLong();
    i.inc(i_inc))  {
        playerReserve =
        Var.valueOf(
        Var.valueOf("playerReserve").getObjectAsString() +
        i.getObjectAsString());
        playerInMyTeam =
        cronapi.logic.Operations.isNullOrEmpty(
        cronapi.database.Operations.getField(myTeam, playerReserve))
        .negate();
        SetPlayerContent(playerReserve, myTeam, playerInMyTeam);
    } // end for
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * PickPlayer
 *
 * @author Root
 * @since 02/06/2022 16:31:41
 *
 */
public static Var OnLoad() throws Exception {
 return new Callable<Var>() {

   private Var userId = Var.VAR_NULL;
   private Var myTeam = Var.VAR_NULL;
   private Var balance = Var.VAR_NULL;

   public Var call() throws Exception {
    userId =
    cronapi.util.Operations.callBlockly(Var.valueOf("blockly.UserManager:GetUserIdByLogin"), Var.valueOf("e986361b", Var.VAR_NULL));
    myTeam =
    cronapi.database.Operations.query(Var.valueOf("fc.entity.MyTeam"),Var.valueOf("select m from MyTeam m where m.userId = :userId"),Var.valueOf("userId",userId));
    balance =
    cronapi.list.Operations.getFirst((
    cronapi.database.Operations.query(Var.valueOf("fc.entity.Transaction"),Var.valueOf("select SUM(t.value) from Transaction t where t.userId = :userId"),Var.valueOf("userId",userId))));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeContent"),
    Var.valueOf("teamPrice"),
    Var.valueOf(
    Var.valueOf("$ ").getObjectAsString() +
    cronapi.conversion.Operations.formatDouble(
    Var.valueOf(CalculateTeamPrice()),
    Var.valueOf("0.00")).getObjectAsString()),
    Var.valueOf("false"));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeContent"),
    Var.valueOf("balance"),
    Var.valueOf(
    Var.valueOf("$ ").getObjectAsString() +
    cronapi.conversion.Operations.formatDouble(balance,
    Var.valueOf("0.00")).getObjectAsString()),
    Var.valueOf("false"));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
    Var.valueOf("vars.schema"),
    cronapi.database.Operations.getField(myTeam,
    Var.valueOf("this[0].tacticalScheme")));
    LoadPlayers();
    cronapi.util.Operations.callClientFunction(Var.valueOf("blockly.js.blockly.TeamManager.SetScheme"),Var.valueOf("2376e36b",
    cronapi.database.Operations.getField(myTeam,
    Var.valueOf("this[0].tacticalScheme"))));
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * Descreva esta função...
 *
 * @param player
 * @param playerId
 *
 * @author Root
 * @since 02/06/2022 16:31:41
 *
 */
public static void SelectPlayer(@ParamMetaData(description = "player", id = "67ad29de") Var player, @ParamMetaData(description = "playerId", id = "bdc9375c") Var playerId) throws Exception {
  new Callable<Var>() {

   private Var userId = Var.VAR_NULL;
   private Var myTeam = Var.VAR_NULL;
   private Var price = Var.VAR_NULL;
   private Var playerFromQuery = Var.VAR_NULL;

   public Var call() throws Exception {
    userId =
    cronapi.util.Operations.callBlockly(Var.valueOf("blockly.UserManager:GetUserIdByLogin"), Var.valueOf("e986361b", Var.VAR_NULL));
    myTeam =
    cronapi.database.Operations.query(Var.valueOf("fc.entity.MyTeam"),Var.valueOf("select m from MyTeam m where m.userId = :userId"),Var.valueOf("userId",userId));
    if (
    Var.valueOf(HasBalanceToBuy(player, playerId, myTeam)).getObjectAsBoolean()) {
        if (
        cronapi.logic.Operations.isNullOrEmpty(
        cronapi.database.Operations.getField(myTeam,
        Var.valueOf(
        Var.valueOf("this[0].").getObjectAsString() +
        player.getObjectAsString())))
        .negate().getObjectAsBoolean()) {
            price =
            cronapi.database.Operations.getField(myTeam,
            Var.valueOf(
            Var.valueOf("this[0].").getObjectAsString() +
            player.getObjectAsString() +
            Var.valueOf(".price").getObjectAsString()));
            cronapi.database.Operations.insert(Var.valueOf("fc.entity.Transaction"),Var.valueOf("date",
            cronapi.dateTime.Operations.getNow()),Var.valueOf("player",
            cronapi.database.Operations.getField(myTeam,
            Var.valueOf(
            Var.valueOf("this[0].").getObjectAsString() +
            player.getObjectAsString() +
            Var.valueOf(".id").getObjectAsString()))),Var.valueOf("type",
            Var.valueOf("sell")),Var.valueOf("userId",userId),Var.valueOf("value",price));
        }
        if (
        cronapi.logic.Operations.isNullOrEmpty(playerId)
        .negate().getObjectAsBoolean()) {
            playerFromQuery =
            cronapi.database.Operations.query(Var.valueOf("fc.entity.Player"),Var.valueOf("select p from Player p where p.id = :id"),Var.valueOf("id",playerId));
            cronapi.database.Operations.insert(Var.valueOf("fc.entity.Transaction"),Var.valueOf("date",
            cronapi.dateTime.Operations.getNow()),Var.valueOf("player",playerId),Var.valueOf("type",
            Var.valueOf("buy")),Var.valueOf("userId",userId),Var.valueOf("value",
            cronapi.math.Operations.multiply(
            cronapi.database.Operations.getField(playerFromQuery,
            Var.valueOf("this[0].price")),
            Var.valueOf(-1))));
        }
        cronapi.database.Operations.updateField(myTeam, player, playerId);
    } else {
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"),
        Var.valueOf("Não existe saldo suficiente para comprar"));
    }
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * Descreva esta função...
 *
 * @param player
 * @param myTeam
 * @param playerInMyTeam
 *
 * @author Root
 * @since 02/06/2022 16:31:41
 *
 */
public static void SetPlayerContent(@ParamMetaData(description = "player", id = "89c02196") Var player, @ParamMetaData(description = "myTeam", id = "625b7090") Var myTeam, @ParamMetaData(description = "playerInMyTeam", id = "cd102154") Var playerInMyTeam) throws Exception {
  new Callable<Var>() {

   public Var call() throws Exception {
    if (playerInMyTeam.getObjectAsBoolean()) {
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeAttrValue"), player,
        Var.valueOf("data-player-id"),
        cronapi.database.Operations.getField(myTeam,
        Var.valueOf(
        Var.valueOf("this[0].").getObjectAsString() +
        player.getObjectAsString() +
        Var.valueOf(".id").getObjectAsString())));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeAttrValue"),
        Var.valueOf(
        player.getObjectAsString() +
        Var.valueOf("-image").getObjectAsString()),
        Var.valueOf("src"),
        Var.valueOf(
        Var.valueOf("data:image/png;base64,").getObjectAsString() +
        cronapi.database.Operations.getField(myTeam,
        Var.valueOf(
        Var.valueOf("this[0].").getObjectAsString() +
        player.getObjectAsString() +
        Var.valueOf(".img").getObjectAsString())).getObjectAsString()));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeContent"),
        Var.valueOf(
        player.getObjectAsString() +
        Var.valueOf("-position").getObjectAsString()),
        cronapi.database.Operations.getField(myTeam,
        Var.valueOf(
        Var.valueOf("this[0].").getObjectAsString() +
        player.getObjectAsString() +
        Var.valueOf(".name").getObjectAsString())),
        Var.valueOf("false"));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeContent"),
        Var.valueOf(
        player.getObjectAsString() +
        Var.valueOf("-balance").getObjectAsString()),
        Var.valueOf(
        Var.valueOf("$ ").getObjectAsString() +
        cronapi.conversion.Operations.formatDouble(
        cronapi.database.Operations.getField(myTeam,
        Var.valueOf(
        Var.valueOf("this[0].").getObjectAsString() +
        player.getObjectAsString() +
        Var.valueOf(".price").getObjectAsString())),
        Var.valueOf("0.00")).getObjectAsString()),
        Var.valueOf("false"));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.setVisibility"),
        Var.valueOf(
        player.getObjectAsString() +
        Var.valueOf("-container-balance").getObjectAsString()),
        Var.valueOf("true"));
    } else {
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeAttrValue"), player,
        Var.valueOf("data-player-id"),
        Var.valueOf(""));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeContent"),
        Var.valueOf(
        player.getObjectAsString() +
        Var.valueOf("-position").getObjectAsString()),
        Var.valueOf("ATA"),
        Var.valueOf("false"));
    }
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * Descreva esta função...
 *
 * @param scheme
 *
 * @author Root
 * @since 02/06/2022 16:31:41
 *
 */
public static void UpdateScheme(@ParamMetaData(description = "scheme", id = "99ba610a") Var scheme) throws Exception {
  new Callable<Var>() {

   private Var userId = Var.VAR_NULL;

   public Var call() throws Exception {
    cronapi.database.Operations.execute(Var.valueOf("fc.entity.MyTeam"), Var.valueOf("update MyTeam set tacticalScheme = :tacticalScheme where userId = :userId"),Var.valueOf("tacticalScheme",scheme),Var.valueOf("userId",
    cronapi.util.Operations.callBlockly(Var.valueOf("blockly.UserManager:GetUserIdByLogin"), Var.valueOf("e986361b", Var.VAR_NULL))));
   return Var.VAR_NULL;
   }
 }.call();
}

}

