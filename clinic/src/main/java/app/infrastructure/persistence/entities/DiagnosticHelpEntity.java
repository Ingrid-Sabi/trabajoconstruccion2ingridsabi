package app.infrastructure.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "diagnostic_helps")
public class DiagnosticHelpEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDiagnosticHelp;

    @Column(nullable = false)
    private Long orderNumber;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private boolean specialistAssistance;

    @Column(nullable = false)
    private Long idTypeSpecialist;

    @Column(nullable = false)
    private int item;

    // ===== Getters y Setters =====
    public Long getIdDiagnosticHelp() {
        return idDiagnosticHelp;
    }

    public void setIdDiagnosticHelp(Long idDiagnosticHelp) {
        this.idDiagnosticHelp= idDiagnosticHelp;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isSpecialistAssistance() {
        return specialistAssistance;
    }

    public void setSpecialistAssistance(boolean specialistAssistance) {
        this.specialistAssistance = specialistAssistance;
    }

    public Long getIdTypeSpecialist() {
        return idTypeSpecialist;
    }

    public void setIdTypeSpecialist(Long idTypeSpecialist) {
        this.idTypeSpecialist = idTypeSpecialist;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }
}