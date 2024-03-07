import java.time.LocalDate;

public class Event {
    private LocalDate date;
    private String name;
    private String description;

    public Event(LocalDate date, String name, String description) {
        this.date = date;
        this.name = name;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Event{" +
                "date=" + date +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}