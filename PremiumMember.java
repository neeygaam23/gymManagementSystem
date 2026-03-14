/**
 * This class represents a premium member of a gym.
 * It extends the GymMember class and adds additional attributes and methods
 * specific to premium members.
 * 
 * @author Nigam Niroula
 * @version 1.0
 */
// package gym;

class PremiumMember extends GymMember {
    private final double premiumCharge = 20000;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount, discountAmount;

    /**
     * Constructor for PremiumMember class.
     * initializes the attributes of the PremiumMember class.
     * 
     * @param id
     * @param name
     * @param location
     * @param Phone
     * @param Email
     * @param gender
     * @param DOB
     * @param membershipStartDate
     * @param personalTrainer
     */
    public PremiumMember(int id, String name, String location, String Phone, String Email, String gender, String DOB,
            String membershipStartDate, String personalTrainer) {
        super(id, name, location, Phone, Email, gender, DOB, membershipStartDate);
        this.personalTrainer = personalTrainer;
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }

    /**
     * increments the attendance of the member by 1 .
     * premium members earn more loyalty points per visit than regular members.
     */
    @Override
    public void markAttendance() {
        Attendance++;
        LoyaltyPoints += 10;
    }

    public double getPremiumCharge() {
        return premiumCharge;
    }

    public String getPersonalTrainer() {
        return personalTrainer;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public boolean isFullPayment() {
        return isFullPayment;
    }

    /**
     * This method allows the premium member to pay the due amount.
     * 
     * @param amount
     * @return
     */
    public String payDueAmount(double amount) {
        if (isFullPayment)
            return "payment is already completed.";
        if ((paidAmount + amount) > premiumCharge)
            return "Payment exceeds required amount.";
        paidAmount += amount;
        isFullPayment = (paidAmount == premiumCharge);
        return "Payment successfull. Remaining amount:" + (premiumCharge - paidAmount);
    }

    /**
     * This method calculates the discount for the premium member.
     * It applies a 10% discount if the member has made a full payment.
     * 
     * @return
     */
    public String calculateDiscount() {
        if (isFullPayment) {
            discountAmount = premiumCharge * 0.10;
            return "Discount of 10% applied:" + discountAmount;
        }
        return "fullpayment is required for obtaining discount.";
    }

    /**
     * Reverts the premium member to initial state by resetting all attributes.
     * 
     * This method resets the attendance, loyalty points, and active status of the member.
     */
    public void revertPremiumMember() {
        super.resetmember(); // Resets attendance, loyalty points, and active status
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }
}
