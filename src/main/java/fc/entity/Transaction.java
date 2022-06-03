
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
* Classe que representa a tabela TRANSACTION
* @generated
*/
@Entity
@Table(name = "\"TRANSACTION\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("fc.entity.Transaction")
public class Transaction implements Serializable {
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
    @Column(name = "userId", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String userId;


    /**
    * @generated
    */
    @Column(name = "type", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String type;


    /**
    * @generated
    */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.util.Date date;


    /**
    * @generated
    */
    @Column(name = "value", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Double value;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_player", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "", foreignKeyDefinition = "FOREIGN KEY (fk_player) REFERENCES PLAYER (id)"))
        
        private Player player;


    /**
    * Construtor
    * @generated
    */
    public Transaction(){
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
    public Transaction setId(java.lang.String id) {
        this.id = id;
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
    public Transaction setUserId(java.lang.String userId) {
        this.userId = userId;
        return this;
    }
    /**
    * Obtém type
    * return type
    * @generated
    */
    public java.lang.String getType() {
        return this.type;
    }

    /**
    * Define type
    * @param type type
    * @generated
    */
    public Transaction setType(java.lang.String type) {
        this.type = type;
        return this;
    }
    /**
    * Obtém date
    * return date
    * @generated
    */
    public java.util.Date getDate() {
        return this.date;
    }

    /**
    * Define date
    * @param date date
    * @generated
    */
    public Transaction setDate(java.util.Date date) {
        this.date = date;
        return this;
    }
    /**
    * Obtém value
    * return value
    * @generated
    */
    public java.lang.Double getValue() {
        return this.value;
    }

    /**
    * Define value
    * @param value value
    * @generated
    */
    public Transaction setValue(java.lang.Double value) {
        this.value = value;
        return this;
    }
    /**
    * Obtém player
    * return player
    * @generated
    */
    public Player getPlayer() {
        return this.player;
    }

    /**
    * Define player
    * @param player player
    * @generated
    */
    public Transaction setPlayer(Player player) {
        this.player = player;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Transaction object = (Transaction)obj;
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