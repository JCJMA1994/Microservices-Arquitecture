package com.sistemas.basico.dominio;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Trabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_cliente_trabajo"))
    private Cliente cliente;

    @Column(length = 60)
    @NotBlank(message = "La descripcion no debe estar en blanco")
    private String descripcion;

    @Min(value = 0)
    @Max(value = 20)
    private Double largo;

    @Min(value = 0)
    @Max(value = 20)
    private Double ancho;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tarifa_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_tarifa_trabajo"))
    private Tarifa tarifa;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaEntrega;

    @Positive
    private Double costo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajo")
    public List<Tarea> tareas;

}
