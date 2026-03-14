/**
 * regular member class
 * extends the GymMember class and implements the methods
 * @author Nigam Niroula
 * @version 1.0
 */

// package gym;

class RegularMember extends GymMember{
    private final int attendanceLimit=30;
    private boolean isEligibleForUpgrade;
    private String removalReason, referralSource;
    private String plan;
    private double price; 

/**
 * Constructor for RegularMember class.
 * @param id
 * @param name
 * @param location
 * @param phone
 * @param email
 * @param gender
 * @param DOB
 * @param membershipStartDate
 * @param referralSource
 */
    public RegularMember (int id, String name, String location, String phone, String email, String gender,String DOB, String membershipStartDate, String referralSource) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.isEligibleForUpgrade = false;
        this.referralSource = referralSource;
        this.plan = "Basic";
        this.price = 6500;
        this.removalReason = "";
    }
/**
 * increment the attendance of the member
 * and add loyalty points
 */
    @Override 
    public void markAttendance(){
        Attendance++;
        LoyaltyPoints +=5;
        if(Attendance>=attendanceLimit){
            isEligibleForUpgrade= true;
        }
    }


/**
 * A method to get the price of the selected plan.
 * @param plan the plan name
 * @return the price of the plan
 */
    public double getPlanPrice(String plan){
        switch (plan.toLowerCase()){
                case"basic":return 6500;
                case"standard":return 12500;
                case"deluxe":return 18500;
            default: System.out.println("invalid plan provided");
            return -1;
        }
    }

    public String getPlanType() {
        return this.plan;
    }

    public double getPrice() {
        return this.price;
    }

    public String getReferralSource() {
        return this.referralSource;
    }

    public String getRemovalReason() {
        return this.removalReason;
    }


    public boolean isEligibleForUpgrade() {
        return this.isEligibleForUpgrade;
    }

/**
 * A method to upgrade the plan of the member.
 * @param newPlan 
 * @return upgrade status
 */
   public String upgradePlan(String newPlan) {
        double newPrice = getPlanPrice(newPlan);
        if(newPrice == -1) return "Invalid plan Selection";
        
        
        if (this.Attendance == 0 || isEligibleForUpgrade) {
            if (this.plan.equalsIgnoreCase(newPlan)) return "Already subscribed to this plan.";
            
            this.plan = newPlan;
            this.price = newPrice;
            return "Plan set to " + newPlan + " successfully";
        }
        
        return "Not eligible for upgrade.";
    }
/**
 * A method to revert the member to a regular member.
 * @param reason
 */
    public void revertRegularMember(String reason) {
        resetmember();
        this.isEligibleForUpgrade = false;
        this.plan = "Basic";
        this.price = 6500;
        this.removalReason = reason;
    }
/**
 * A method to display the details of the member.
 * displays all the details of the regular member
 */
    @Override
    public void display() {
        super.display();
        System.out.println("Member Type: Regular Member");
        System.out.println("Plan: " + plan);
        System.out.println("Price: " + price);
        System.out.println("Referral Source: " + referralSource);
        System.out.println("Removal Reason: " + removalReason);
        System.out.println("Eligible for Upgrade: " + (isEligibleForUpgrade ? "Yes" : "No"));
    }
}