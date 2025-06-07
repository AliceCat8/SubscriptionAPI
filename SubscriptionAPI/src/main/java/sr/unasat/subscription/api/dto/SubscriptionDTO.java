package sr.unasat.subscription.api.dto;

public class SubscriptionDTO {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String phonenumber;
    private String subscription;
    private String services;
    // Comma-separated values for checkboxes
    private boolean active = true;

    public SubscriptionDTO() {
    }

    public SubscriptionDTO(int id, String firstname, String lastname, String email, String phonenumber, boolean active) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.active = active;
    }

    public SubscriptionDTO(int id, String firstname, String lastname, String email, String phonenumber, String subscription, String services, boolean active) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.subscription = subscription;
        this.services = services;
        this.active = active;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public boolean isActive() { return active; }

    public void setActive(boolean active) { this.active = active; }

    @Override
    public String toString() {
        return "SubscriptionDTO{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", subscription='" + subscription + '\'' +
                ", services='" + services + '\'' +
                '}';
    }
}
