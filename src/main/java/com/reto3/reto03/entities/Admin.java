package com.reto3.reto03.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "administrador")
public class Admin {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idAdmin;
}
