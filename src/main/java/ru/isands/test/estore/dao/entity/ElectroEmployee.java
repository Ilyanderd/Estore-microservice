package ru.isands.test.estore.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
/*@IdClass(ElectroEmployeesPK.class)*/
@Table(name = "ElectroEmployees")
@AllArgsConstructor
@NoArgsConstructor
public class ElectroEmployee {
    @Id
    private long id;
    /*@EmbeddedId
    private ElectroEmployeesPK id;*/

    /**
     * Идентификатор сотрудника
     */
   /* @ManyToOne
    @MapsId("employeeId")
    @JoinColumn
    private Employee employeeId;*/

    /**
     * Идентификатор типа электроники
     */
    /*@ManyToOne
    @MapsId("electroTypeId")
    @JoinColumn
    private ElectroType electroTypeId;*/

}
