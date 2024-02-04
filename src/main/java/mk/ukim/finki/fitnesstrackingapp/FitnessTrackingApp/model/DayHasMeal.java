package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_DayHasMeal")
public class DayHasMeal {

    @Id
    @ManyToOne
    @JoinColumn(name = "mID")
    private Meal meal;

    @Id
    @ManyToOne
    @JoinColumn(name = "dID")
    private Day day;

}
