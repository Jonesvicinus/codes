/*
 * Written by Jones Vicinus
 */

public class Order implements Comparable<Order> {
    private String customer;
    private String foodOrder;
    private int cookingTime;
    private int arrivalTime;
    private int cookingTimeLeft;

    // Default constructor
    public Order() {
        this.customer = "none";
        this.foodOrder = "none";
        this.cookingTime = 1;
        this.arrivalTime = 0;
        this.cookingTimeLeft = 1;
    }

    // Parameterized constructor
    public Order(String customer, String foodOrder, int cookingTime, int arrivalTime) {
        if (customer != null && !customer.isEmpty()) {
            this.customer = customer;
        } else {
            this.customer = "none";
        }
        
        if (foodOrder != null && !foodOrder.isEmpty()) {
            this.foodOrder = foodOrder;
        } else {
            this.foodOrder = "none";
        }

        if (cookingTime > 0) {
            this.cookingTime = cookingTime;
        } else {
            this.cookingTime = 1;
        }

        if (arrivalTime >= 0) {
            this.arrivalTime = arrivalTime;
        } else {
            this.arrivalTime = 0;
        }

        this.cookingTimeLeft = this.cookingTime;
    }

    // Accessors
    public String getCustomer() {
        return customer;
    }

    public String getFoodOrder() {
        return foodOrder;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getCookingTimeLeft() {
        return cookingTimeLeft;
    }

    // Mutators
    public void setCustomer(String customer) {
        if (customer != null && !customer.isEmpty()) {
            this.customer = customer;
        }
    }

    public void setFoodOrder(String foodOrder) {
        if (foodOrder != null && !foodOrder.isEmpty()) {
            this.foodOrder = foodOrder;
        }
    }

    public void setCookingTime(int cookingTime) {
        if (cookingTime > 0) {
            this.cookingTime = cookingTime;
            this.cookingTimeLeft = cookingTime;
        }
    }

    public void setArrivalTime(int arrivalTime) {
        if (arrivalTime >= 0) {
            this.arrivalTime = arrivalTime;
        }
    }

    // Method to reduce the cooking time by one minute
    public void cookForOneMinute() {
        if (cookingTimeLeft > 0) {
            cookingTimeLeft--;
        }
    }

    // Method to check if cooking is done
    public boolean isDone() {
        return cookingTimeLeft == 0;
    }

    // compareTo method for heap ordering by cooking time
    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.cookingTime, other.cookingTime);
    }

    // toString method to display order information
    @Override
    public String toString() {
        return "Customer: " + customer + ", Order: " + foodOrder + ", Cooking Time Left: " + cookingTimeLeft;
    }
}
