package sr.unasat.subscription.api.dto;

public class SubscriptionNotesDTO {
    private int id;
    private int subscriptionId;
    private String note;

    public SubscriptionNotesDTO() {}

    // Constructor with ID and note
    public SubscriptionNotesDTO(int id, int subscriptionId, String note) {
        this.id = id;
        this.subscriptionId = subscriptionId;
        this.note = note;
    }

    // Getters and Setters
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


    @Override
    public String toString() {
        return "SubscriptionNotesDTO{" +
                "id=" + id +
                ", subscriptionId=" + subscriptionId +
                ", note='" + note + '\'' +
                '}';
    }
}
