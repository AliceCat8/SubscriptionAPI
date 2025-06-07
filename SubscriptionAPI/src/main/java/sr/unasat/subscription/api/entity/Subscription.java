package sr.unasat.subscription.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.security.Timestamp;

@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "First name is required")
    @Column(nullable = false)
    private String firstname;

    @NotBlank(message = "Last name is required")
    @Column(nullable = false)
    private String lastname;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Phone number is required")
    @Column(nullable = false)
    private String phonenumber;

    @Column
    private String subscription;

    @Column
    private String services;

    @Column(nullable = false)
    private boolean active = true;


    // Comma-separated values for ch@Column(nullable = false)
    //    private boolean active = true;eckboxes

    // Constructors
    public Subscription() {}

    public Subscription(String firstname, String lastname, String email, String phonenumber, boolean active) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.active = active;

    }

    public Subscription(String firstname, String lastname, String email, String phonenumber, String subscription, String services, boolean active) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.subscription = subscription;
        this.services = services;
        this.active = active;
    }


    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhonenumber() { return phonenumber; }
    public void setPhonenumber(String phonenumber) { this.phonenumber = phonenumber; }
    public String getSubscription() { return subscription; }
    public void setSubscription(String subscription) { this.subscription = subscription; }
    public String getServices() { return services; }
    public void setServices(String services) { this.services = services; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}