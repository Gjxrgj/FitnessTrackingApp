package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model;

import jakarta.persistence.*;
import lombok.*;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.user.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_UserHas_Day")
public class UserHasDay {

    @Id
    @ManyToOne
    @JoinColumn(name = "uID")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "dID")
    private Day day;

}
