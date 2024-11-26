package ru.isands.test.estore.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ElectroEmployeesPK implements Serializable {

    /**
     * Идентификатор сотрудника
     */
    @Column(nullable = false)
    private Long employeeId;

    /**
     * Идентификатор типа электроники
     */
    @Column(nullable = false)
    private Long electroTypeId;
}
