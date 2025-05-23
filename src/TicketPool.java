public class TicketPool {
    private int availableTickets;

    public TicketPool(int totalTickets) {
        this.availableTickets = totalTickets;
    }

    public synchronized Ticket reserveTicket(String customerName) {
        while (availableTickets <= 0) {
            System.out.println(customerName + " is waiting for a ticket...");
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }

        availableTickets--;
        Ticket ticket = new Ticket(availableTickets + 1, "Concert");
        System.out.println(customerName + " reserved Ticket #" + ticket.getId());
        return ticket;
    }

    public synchronized void releaseTicket() {
        availableTickets++;
        notify();
    }
}
