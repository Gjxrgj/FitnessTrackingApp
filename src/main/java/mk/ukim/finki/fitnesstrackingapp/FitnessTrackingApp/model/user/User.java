package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Day;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.WorkoutProgram;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "_user_seq")
    @SequenceGenerator(name = "_user_seq", sequenceName = "_user_seq", allocationSize = 1)
    @Column(name = "uid")
    private Long uID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "height")
    private int height;

    @Column(name = "weight")
    private int weight;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "userhasdays",
            joinColumns = @JoinColumn(name = "uID"),
            inverseJoinColumns = @JoinColumn(name = "dID")
    )
    private List<Day> days = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "userhasprogram",
            joinColumns = @JoinColumn(name = "uID"),
            inverseJoinColumns = @JoinColumn(name = "wpID")
    )
    private List<WorkoutProgram> workoutPrograms= new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void addDay(Day day) {
        days.add(day);
    }

    public Day getToday() {
        return days.get(days.size() - 1);
    }
}

