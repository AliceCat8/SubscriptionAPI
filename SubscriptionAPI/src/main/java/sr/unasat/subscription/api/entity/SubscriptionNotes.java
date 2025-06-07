package sr.unasat.subscription.api.entity;

import jakarta.persistence.*;

        import java.security.Timestamp;

@Entity
@Table(name = "subscription_notes")
public class SubscriptionNotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "subscription_id")
    private int subscriptionId;

    @Column(name = "note")
    private String note;

    // Getters and Setters
    public SubscriptionNotes(int subscriptionId, String note, java.sql.Timestamp timestamp) {}

    public SubscriptionNotes(int subscriptionId, String note, Timestamp createdAt) {
        this.subscriptionId = subscriptionId;
        this.note = note;
    }
    public SubscriptionNotes(int subscriptionId, String note) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public void setCreatedAt(String createdAt) {
    }
}