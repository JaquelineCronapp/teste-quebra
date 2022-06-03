
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
* Classe que representa a tabela PLAYER
* @generated
*/
@Entity
@Table(name = "\"PLAYER\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("fc.entity.Player")
public class Player implements Serializable {
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
    @Column(name = "name", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String name;


    /**
    * @generated
    */
    @Column(name = "img", nullable = true, unique = false, insertable=true, updatable=true)
        
        private byte[] img;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_team", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "", foreignKeyDefinition = "FOREIGN KEY (fk_team) REFERENCES TEAM (id)"))
        
        private Team team;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_position", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "", foreignKeyDefinition = "FOREIGN KEY (fk_position) REFERENCES POSITION (id)"))
        
        private Position position;


    /**
    * @generated
    */
    @Column(name = "totalGamesPlayed", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String totalGamesPlayed;


    /**
    * @generated
    */
    @Column(name = "price", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Double price;


    /**
    * @generated
    */
    @Column(name = "oldPrice", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Double oldPrice;


    /**
    * Construtor
    * @generated
    */
    public Player(){
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
    public Player setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém name
    * return name
    * @generated
    */
    public java.lang.String getName() {
        return this.name;
    }

    /**
    * Define name
    * @param name name
    * @generated
    */
    public Player setName(java.lang.String name) {
        this.name = name;
        return this;
    }
    /**
    * Obtém img
    * return img
    * @generated
    */
    public byte[] getImg() {
        return this.img;
    }

    /**
    * Define img
    * @param img img
    * @generated
    */
    public Player setImg(byte[] img) {
        this.img = img;
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
    public Player setTeam(Team team) {
        this.team = team;
        return this;
    }
    /**
    * Obtém position
    * return position
    * @generated
    */
    public Position getPosition() {
        return this.position;
    }

    /**
    * Define position
    * @param position position
    * @generated
    */
    public Player setPosition(Position position) {
        this.position = position;
        return this;
    }
    /**
    * Obtém totalGamesPlayed
    * return totalGamesPlayed
    * @generated
    */
    public java.lang.String getTotalGamesPlayed() {
        return this.totalGamesPlayed;
    }

    /**
    * Define totalGamesPlayed
    * @param totalGamesPlayed totalGamesPlayed
    * @generated
    */
    public Player setTotalGamesPlayed(java.lang.String totalGamesPlayed) {
        this.totalGamesPlayed = totalGamesPlayed;
        return this;
    }
    /**
    * Obtém price
    * return price
    * @generated
    */
    public java.lang.Double getPrice() {
        return this.price;
    }

    /**
    * Define price
    * @param price price
    * @generated
    */
    public Player setPrice(java.lang.Double price) {
        this.price = price;
        return this;
    }
    /**
    * Obtém oldPrice
    * return oldPrice
    * @generated
    */
    public java.lang.Double getOldPrice() {
        return this.oldPrice;
    }

    /**
    * Define oldPrice
    * @param oldPrice oldPrice
    * @generated
    */
    public Player setOldPrice(java.lang.Double oldPrice) {
        this.oldPrice = oldPrice;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Player object = (Player)obj;
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