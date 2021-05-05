import java.util.*;

class Customer {
    private final String name;
    private final ArrayList<Rental> rentals = new ArrayList<>();

    public Customer(String newname) {
        name = newname;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        for (Rental element : rentals) {
            result += "\t" + element.getMovie().getTitle() + "\t" + "\t" + element.getDaysRented() + "\t" + String.valueOf(element.getCharge()) + "\n";
        }

        //add footer lines
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";

        return result;
    }

//    It is worth stopping to think a bit about the last refactoring. Most refactorings reduce the amount
//    of code, but this one increases it. That's because Java 1.1 requires a lot of statements to set up a
//    summing loop. Even a simple summing loop with one line of code per element needs six lines of
//    support around it. It's an idiom that is obvious to any programmer but is a lot of lines all the same.
//    The other concern with this refactoring lies in performance. The old code executed the "while"
//    loop once, the new code executes it three times. A while loop that takes a long time might impair
//    performance. Many programmers would not do this refactoring simply for this reason. But note
//    the words if and might. Until I profile I cannot tell how much time is needed for the loop to
//    calculate or whether the loop is called often enough for it to affect the overall performance of the
//    system. Don't worry about this while refactoring. When you optimize you will have to worry about
//    it, but you will then be in a much better position to do something about it, and you will have more
//    options to optimize effectively (see the discussion on page 69).

    private double getTotalCharge() {
        double result = 0;

        for (Rental element : rentals) {
            result += element.getCharge();
        }

        return result;
    }

    private int getTotalFrequentRenterPoints() {
        var result = 0;

        for (Rental element : rentals) {
            result += element.getFrequentRenterPoints();
        }

        return result;
    }

}
    