package ua.com.mytodo.model;

public class Todo {

    private Long id;
    private String name;
    private Long status;

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long statusId) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
