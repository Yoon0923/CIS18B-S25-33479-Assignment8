public class Customer implements Runnable {
    private final String name;
    private final TicketPool pool;

    public Customer(String name, TicketPool pool) {
        this.name = name;
        this.pool = pool;
    }

    @Override
    public void run() {
        Ticket ticket = pool.reserveTicket(name);
        if (ticket != null) {
            System.out.println(name + " got ticket for: " + ticket.getEvent());
        } else {
            System.out.println(name + " did not get a ticket.");
        }
    }
}
