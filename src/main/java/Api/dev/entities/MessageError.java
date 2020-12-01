/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author alexjandrohum
 */
@Entity
@Table(name = "error_table")
public class MessageError implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_error")
    private Integer idError;
    private String name;
    private String message;

    public MessageError(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public Integer getIdError() {
        return idError;
    }

    public void setIdError(Integer idError) {
        this.idError = idError;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
