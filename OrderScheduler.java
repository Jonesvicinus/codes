/*
 * Written by Jones Vicinus
 */

public class OrderScheduler {
    private MinHeap<Order> orders;
    private Order currentOrder;
    private int currentMinute;
    private int totalOrders;
    private int summedWaitingTimes;

    // Constructor
    public OrderScheduler() {
        orders = new MinHeap<>();
        currentOrder = null;
        currentMinute = 0;
        totalOrders = 0;
        summedWaitingTimes = 0;
    }

    // Add an order to the scheduler
    public void addOrder(Order order) {
        if (currentOrder == null) {
            currentOrder = order;
        } else {
            orders.add(order);
        }
        totalOrders++;
    }

    // Advance one minute in the simulation
    public void advanceOneMinute() {
        currentMinute++;
        
        if (currentOrder != null) {
            currentOrder.cookForOneMinute();

            if (currentOrder.isDone()) {
                int waitingTime = currentMinute - currentOrder.getArrivalTime();
                summedWaitingTimes += waitingTime;
                currentOrder = null; // Finished with current order
            }
        }

        if (currentOrder == null && !orders.isEmpty()) {
            currentOrder = orders.remove(); // Get next order
        }
    }

    // Check if there is a current order being cooked
    public boolean isDone() {
        return currentOrder == null && orders.isEmpty();
    }

    // Get the average waiting time
    public double getAverageWaitingTime() {
        return totalOrders == 0 ? 0 : (double) summedWaitingTimes / totalOrders;
    }

    // Method to display the current status of the scheduler
    public String getStatus() {
        return "Current Minute: " + currentMinute + ", Current Order: " + (currentOrder != null ? currentOrder.toString() : "None");
    }

    // Getter for the current order (for printing)
    public Order getCurrentOrder() {
        return currentOrder;
    }
}
