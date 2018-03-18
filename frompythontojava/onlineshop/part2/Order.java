package part2;

public class Order implements Orderable {

    private Integer ID;
    private static int count = 0;
    private String status;

    public Order() {
        this.ID = ++count;
        this.status = "new";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public boolean checkout() {

        this.status = "checked";
        return this.status.equals("checked");

    }

    public boolean pay() {
        this.status = "payed";
        return this.status.equals("payed");

    }
}
