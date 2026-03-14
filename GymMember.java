/**
 * Root class for the Gym Management System.
 * This class contains the attributes and methods common to all gym members.
 * 
 * @author Nigam Niroula
 * @version 1.0
 * 
 * 
 */



//  package gym;


public abstract class GymMember{
    //Attributes
    protected int id;
    protected String Name;
    protected String Location;
    protected String Phone;
    protected String Email;
    protected String Gender;
    protected String DOB;
    protected String MembershipStartDate;
    protected int Attendance;
    protected double LoyaltyPoints;
    protected boolean ActiveStatus;


    /**
     * Constructor for Gymmember class.
     * 
     * @param id  includes the id of the gymmember
     * @param Name includes the name of the gymmember                
     * @param Location includes the location of the gymmember 
     * @param Phone includes the phone number of the gymmember
     * @param Email includes the email of the gymmember 
     * @param Gender includes the gender of the gymmember 
     * @param DOB   includes the date of birth of the gymmember
     * @param MembershipStartDate includes the start date of membership
     */
    
    public GymMember(int id,String Name,String location,String Phone,String Email,String Gender,String DOB,String MembershipStartDate){
        this.id= id;
        this.Name= Name;
        this.Location= location;
        this.Phone= Phone;
        this.Email= Email;
        this.Gender= Gender;
        this.DOB= DOB;
        this.MembershipStartDate= MembershipStartDate;
        this.Attendance= 0;
        this.LoyaltyPoints=0;
        this.ActiveStatus=false;
    }


/**
 * Gets the id of the gym member.
 * @return the member id
 */
public int getId() {
    return id;
}

/**
 * Gets the name of the gym member.
 * @return the member name
 */
public String getName() {
    return Name;
}
/**
 * Gets the location of the gym member.
 * @return the member location
 */
public String getLocation() {
    return Location;
}
/**
 * Gets the phone number of the gym member.
 * @return the member phone number
 */
public String getPhone() {
    return Phone;
}
/**
 * Gets the email of the gym member.
 * @return the member email
 */
public String getEmail() {
    return Email;
}
/**
 * Gets the Gender of the gym member.
 * @return the member gender
 */
public String getGender() {
    return Gender;
}

/**
 * Gets the date of birth of the gym member.
 * @return the member's date of birth
 */
public String getDOB() {
    return DOB;
}

/**
 * Gets the membership start date of the gym member.
 * @return the member's membership start date
 */
public String getMembershipStartDate() {
    return MembershipStartDate;
}
/**
 * Gets the attendance of the gym member.
 * @return the member's attendance
 */
public int getAttendance() {
    return Attendance;
}
/**
 * Gets the loyalty points of the gym member.
 * @return the member's loyalty points
 */
public double getLoyaltyPoints() {
    return LoyaltyPoints;
}
/**
 * Gets the active status of the gym member.
 * @return true if the member is active otherwise false
 */
public boolean isActiveStatus() {
    return ActiveStatus;
}

/**
 * abstract method must be implemented by subclasses to mark attendance.
 * used for marking attendance of the gym member and loyalty points.
 */
public abstract void markAttendance();

/**
 * Activates the membership of the gym member.
 * This method sets ActiveStatus to true.
 */
public void activateMembership() {this.ActiveStatus = true;}

/**
 * Deactivates the membership of the gym member.
 * This method sets ActiveStatus to false.
 */
public void deactiveMembership(){
if (ActiveStatus){
this.ActiveStatus=false;
}else{
System.out.println("Already inactive");

}
}

/**
 * resets the member's attendance and loyalty points.
 */
public void resetmember(){
this.ActiveStatus=false;
this.Attendance=0;
this.LoyaltyPoints=0;
}

/**
 * Displays the details of the gym member.
 */
public void display() {
System.out.println("id:"+id+ "Name:" +Name+ "location:" +Location);
System.out.println("Phone:"+Phone+"Email"+Email);
System.out.println("Gender:"+Gender+"DOB:"+DOB);
System.out.println("membership start date:"+MembershipStartDate);
System.out.println("Attendance:"+Attendance+"Loyalty Points:"+ LoyaltyPoints);
System.out.println("Active Status:"+(ActiveStatus ? "Active": "Inactive"));
}
}






