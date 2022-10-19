/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

public class Participation {
    private Long idParticipation ;
    private Double    resultat ; 
    private Long idUser ; 
    private Long idFormation ; 

    public Participation(Long idParticipation, Double resultat, Long idUser, Long idFormation) {
        this.idParticipation = idParticipation;
        this.resultat = resultat;
        this.idUser = idUser;
        this.idFormation = idFormation;
    }

    public Participation(Long idParticipation, Double resultat) {
        this.idParticipation = idParticipation;
        this.resultat = resultat;
    }

    public Participation(Double resultat, Long idUser, Long idFormation) {
        this.resultat = resultat;
        this.idUser = idUser;
        this.idFormation = idFormation;
    }

    public Participation(Double resultat) {
        this.resultat = resultat;
    }

    public Participation() {
     }

    public Long getIdParticipation() {
        return idParticipation;
    }

    public Double getResultat() {
        return resultat;
    }

    public Long getIdUser() {
        return idUser;
    }

    public Long getIdFormation() {
        return idFormation;
    }

    public void setIdParticipation(Long idParticipation) {
        this.idParticipation = idParticipation;
    }

    public void setResultat(Double resultat) {
        this.resultat = resultat;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public void setIdFormation(Long idFormation) {
        this.idFormation = idFormation;
    }

    @Override
    public String toString() {
        return "Participation{" + "idParticipation=" + idParticipation + ", resultat=" + resultat + ", idUser=" + idUser + ", idFormation=" + idFormation + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}




 	
