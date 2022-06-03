
package fc.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;
import cronapi.swagger.CronappSwagger;


/**
* Classe que representa a tabela MYTEAM
* @generated
*/
@Entity
@Table(name = "\"MYTEAM\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("fc.entity.MyTeam")
public class MyTeam implements Serializable {
    /**
    * UID da classe, necessário na serialização
    * @generated
    */
    private static final long serialVersionUID = 1L;

    /**
    * @generated
    */
    @Id
    @Column(name = "id", nullable = false, insertable=true, updatable=true)
        private java.lang.String id = UUID.randomUUID().toString().toUpperCase();


    /**
    * @generated
    */
    @Column(name = "ownerName", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String ownerName;


    /**
    * @generated
    */
    @Column(name = "teamName", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String teamName;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_team", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "", foreignKeyDefinition = "FOREIGN KEY (fk_team) REFERENCES TEAM (id)"))
        
        private Team team;


    /**
    * @generated
    */
    @Column(name = "tacticalScheme", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String tacticalScheme;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_player_1", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "", foreignKeyDefinition = "FOREIGN KEY (fk_player_1) REFERENCES PLAYER (id)"))
        
        private Player player1;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_player_2", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "", foreignKeyDefinition = "FOREIGN KEY (fk_player_2) REFERENCES PLAYER (id)"))
        
        private Player player2;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_player_3", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "", foreignKeyDefinition = "FOREIGN KEY (fk_player_3) REFERENCES PLAYER (id)"))
        
        private Player player3;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_player_4", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "", foreignKeyDefinition = "FOREIGN KEY (fk_player_4) REFERENCES PLAYER (id)"))
        
        private Player player4;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_player_5", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "", foreignKeyDefinition = "FOREIGN KEY (fk_player_5) REFERENCES PLAYER (id)"))
        
        private Player player5;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_player_6", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "", foreignKeyDefinition = "FOREIGN KEY (fk_player_6) REFERENCES PLAYER (id)"))
        
        private Player player6;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_player_7", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "", foreignKeyDefinition = "FOREIGN KEY (fk_player_7) REFERENCES PLAYER (id)"))
        
        private Player player7;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_player_8", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "", foreignKeyDefinition = "FOREIGN KEY (fk_player_8) REFERENCES PLAYER (id)"))
        
        private Player player8;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_player_9", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "", foreignKeyDefinition = "FOREIGN KEY (fk_player_9) REFERENCES PLAYER (id)"))
        
        private Player player9;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_player_10", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "", foreignKeyDefinition = "FOREIGN KEY (fk_player_10) REFERENCES PLAYER (id)"))
        
        private Player player10;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_player_11", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "", foreignKeyDefinition = "FOREIGN KEY (fk_player_11) REFERENCES PLAYER (id)"))
        
        private Player player11;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_player_coach", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "", foreignKeyDefinition = "FOREIGN KEY (fk_player_coach) REFERENCES PLAYER (id)"))
        
        private Player coach;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_player_reserve_1", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "", foreignKeyDefinition = "FOREIGN KEY (fk_player_reserve_1) REFERENCES PLAYER (id)"))
        
        private Player playerReserve1;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_player_reserve_2", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "", foreignKeyDefinition = "FOREIGN KEY (fk_player_reserve_2) REFERENCES PLAYER (id)"))
        
        private Player playerReserve2;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_player_reserve_3", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "", foreignKeyDefinition = "FOREIGN KEY (fk_player_reserve_3) REFERENCES PLAYER (id)"))
        
        private Player playerReserve3;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_player_reserve_4", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "", foreignKeyDefinition = "FOREIGN KEY (fk_player_reserve_4) REFERENCES PLAYER (id)"))
        
        private Player playerReserve4;


    /**
    * @generated
    */
    @Column(name = "userId", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String userId;


    /**
    * Construtor
    * @generated
    */
    public MyTeam(){
    }

    /**
    * Obtém id
    * return id
    * @generated
    */
    public java.lang.String getId() {
        return this.id;
    }

    /**
    * Define id
    * @param id id
    * @generated
    */
    public MyTeam setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém ownerName
    * return ownerName
    * @generated
    */
    public java.lang.String getOwnerName() {
        return this.ownerName;
    }

    /**
    * Define ownerName
    * @param ownerName ownerName
    * @generated
    */
    public MyTeam setOwnerName(java.lang.String ownerName) {
        this.ownerName = ownerName;
        return this;
    }
    /**
    * Obtém teamName
    * return teamName
    * @generated
    */
    public java.lang.String getTeamName() {
        return this.teamName;
    }

    /**
    * Define teamName
    * @param teamName teamName
    * @generated
    */
    public MyTeam setTeamName(java.lang.String teamName) {
        this.teamName = teamName;
        return this;
    }
    /**
    * Obtém team
    * return team
    * @generated
    */
    public Team getTeam() {
        return this.team;
    }

    /**
    * Define team
    * @param team team
    * @generated
    */
    public MyTeam setTeam(Team team) {
        this.team = team;
        return this;
    }
    /**
    * Obtém tacticalScheme
    * return tacticalScheme
    * @generated
    */
    public java.lang.String getTacticalScheme() {
        return this.tacticalScheme;
    }

    /**
    * Define tacticalScheme
    * @param tacticalScheme tacticalScheme
    * @generated
    */
    public MyTeam setTacticalScheme(java.lang.String tacticalScheme) {
        this.tacticalScheme = tacticalScheme;
        return this;
    }
    /**
    * Obtém player1
    * return player1
    * @generated
    */
    public Player getPlayer1() {
        return this.player1;
    }

    /**
    * Define player1
    * @param player1 player1
    * @generated
    */
    public MyTeam setPlayer1(Player player1) {
        this.player1 = player1;
        return this;
    }
    /**
    * Obtém player2
    * return player2
    * @generated
    */
    public Player getPlayer2() {
        return this.player2;
    }

    /**
    * Define player2
    * @param player2 player2
    * @generated
    */
    public MyTeam setPlayer2(Player player2) {
        this.player2 = player2;
        return this;
    }
    /**
    * Obtém player3
    * return player3
    * @generated
    */
    public Player getPlayer3() {
        return this.player3;
    }

    /**
    * Define player3
    * @param player3 player3
    * @generated
    */
    public MyTeam setPlayer3(Player player3) {
        this.player3 = player3;
        return this;
    }
    /**
    * Obtém player4
    * return player4
    * @generated
    */
    public Player getPlayer4() {
        return this.player4;
    }

    /**
    * Define player4
    * @param player4 player4
    * @generated
    */
    public MyTeam setPlayer4(Player player4) {
        this.player4 = player4;
        return this;
    }
    /**
    * Obtém player5
    * return player5
    * @generated
    */
    public Player getPlayer5() {
        return this.player5;
    }

    /**
    * Define player5
    * @param player5 player5
    * @generated
    */
    public MyTeam setPlayer5(Player player5) {
        this.player5 = player5;
        return this;
    }
    /**
    * Obtém player6
    * return player6
    * @generated
    */
    public Player getPlayer6() {
        return this.player6;
    }

    /**
    * Define player6
    * @param player6 player6
    * @generated
    */
    public MyTeam setPlayer6(Player player6) {
        this.player6 = player6;
        return this;
    }
    /**
    * Obtém player7
    * return player7
    * @generated
    */
    public Player getPlayer7() {
        return this.player7;
    }

    /**
    * Define player7
    * @param player7 player7
    * @generated
    */
    public MyTeam setPlayer7(Player player7) {
        this.player7 = player7;
        return this;
    }
    /**
    * Obtém player8
    * return player8
    * @generated
    */
    public Player getPlayer8() {
        return this.player8;
    }

    /**
    * Define player8
    * @param player8 player8
    * @generated
    */
    public MyTeam setPlayer8(Player player8) {
        this.player8 = player8;
        return this;
    }
    /**
    * Obtém player9
    * return player9
    * @generated
    */
    public Player getPlayer9() {
        return this.player9;
    }

    /**
    * Define player9
    * @param player9 player9
    * @generated
    */
    public MyTeam setPlayer9(Player player9) {
        this.player9 = player9;
        return this;
    }
    /**
    * Obtém player10
    * return player10
    * @generated
    */
    public Player getPlayer10() {
        return this.player10;
    }

    /**
    * Define player10
    * @param player10 player10
    * @generated
    */
    public MyTeam setPlayer10(Player player10) {
        this.player10 = player10;
        return this;
    }
    /**
    * Obtém player11
    * return player11
    * @generated
    */
    public Player getPlayer11() {
        return this.player11;
    }

    /**
    * Define player11
    * @param player11 player11
    * @generated
    */
    public MyTeam setPlayer11(Player player11) {
        this.player11 = player11;
        return this;
    }
    /**
    * Obtém coach
    * return coach
    * @generated
    */
    public Player getCoach() {
        return this.coach;
    }

    /**
    * Define coach
    * @param coach coach
    * @generated
    */
    public MyTeam setCoach(Player coach) {
        this.coach = coach;
        return this;
    }
    /**
    * Obtém playerReserve1
    * return playerReserve1
    * @generated
    */
    public Player getPlayerReserve1() {
        return this.playerReserve1;
    }

    /**
    * Define playerReserve1
    * @param playerReserve1 playerReserve1
    * @generated
    */
    public MyTeam setPlayerReserve1(Player playerReserve1) {
        this.playerReserve1 = playerReserve1;
        return this;
    }
    /**
    * Obtém playerReserve2
    * return playerReserve2
    * @generated
    */
    public Player getPlayerReserve2() {
        return this.playerReserve2;
    }

    /**
    * Define playerReserve2
    * @param playerReserve2 playerReserve2
    * @generated
    */
    public MyTeam setPlayerReserve2(Player playerReserve2) {
        this.playerReserve2 = playerReserve2;
        return this;
    }
    /**
    * Obtém playerReserve3
    * return playerReserve3
    * @generated
    */
    public Player getPlayerReserve3() {
        return this.playerReserve3;
    }

    /**
    * Define playerReserve3
    * @param playerReserve3 playerReserve3
    * @generated
    */
    public MyTeam setPlayerReserve3(Player playerReserve3) {
        this.playerReserve3 = playerReserve3;
        return this;
    }
    /**
    * Obtém playerReserve4
    * return playerReserve4
    * @generated
    */
    public Player getPlayerReserve4() {
        return this.playerReserve4;
    }

    /**
    * Define playerReserve4
    * @param playerReserve4 playerReserve4
    * @generated
    */
    public MyTeam setPlayerReserve4(Player playerReserve4) {
        this.playerReserve4 = playerReserve4;
        return this;
    }
    /**
    * Obtém userId
    * return userId
    * @generated
    */
    public java.lang.String getUserId() {
        return this.userId;
    }

    /**
    * Define userId
    * @param userId userId
    * @generated
    */
    public MyTeam setUserId(java.lang.String userId) {
        this.userId = userId;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
MyTeam object = (MyTeam)obj;
        if (id != null ? !id.equals(object.id) : object.id != null) return false;
        return true;
    }

    /**
    * @generated
    */
    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}