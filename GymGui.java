/**
 * Gym Management System GUI
 * This class creates a graphical user interface for managing gym members.
 * It makes us able to add, activate, deactivate, and display members.
 * sleek design with clean layout.
 *@author Nigam Niroula
 *@version 1.0
 */

// package gym;

import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class GymGui {
    public static void main(String[] args) {
        ArrayList<PremiumMember> premiumMembers = new ArrayList<>();
        ArrayList<GymMember> gymMembers = new ArrayList<>();
        ArrayList<RegularMember> regularMembers = new ArrayList<>();

        JFrame frame = new JFrame("Gym Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);
        frame.setLayout(null);

        JLabel label = new JLabel("Id:");
        label.setBounds(30, 30, 100, 25);

        JTextField Id = new JTextField();
        Id.setBounds(140, 30, 200, 25);

        JLabel Namelabel = new JLabel("Name:");
        Namelabel.setBounds(30, 70, 100, 25);

        JTextField name = new JTextField();
        name.setBounds(140, 70, 200, 25);

        JLabel LocationLabel = new JLabel("Location:");
        LocationLabel.setBounds(30, 110, 100, 25);

        JTextField location = new JTextField();
        location.setBounds(140, 110, 200, 25);

        JLabel Phonelabel = new JLabel("Phone:");
        Phonelabel.setBounds(30, 150, 100, 25);

        JTextField Phone = new JTextField();
        Phone.setBounds(140, 150, 200, 25);

        JLabel EmailLabel = new JLabel("Email:");
        EmailLabel.setBounds(30, 190, 100, 25);

        JTextField Email = new JTextField();
        Email.setBounds(140, 190, 200, 25);

        JLabel GenderLabel = new JLabel("Gender:");
        GenderLabel.setBounds(30, 230, 100, 25);
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");

        maleButton.setBounds(140, 230, 80, 25);
        femaleButton.setBounds(230, 230, 80, 25);

        ButtonGroup group = new ButtonGroup();
        group.add(maleButton);
        group.add(femaleButton);

        JLabel DOBLabel = new JLabel("DOB:");
        DOBLabel.setBounds(30, 270, 100, 25);

        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = String.valueOf(i + 1);
        }
        JComboBox<String> dayBox = new JComboBox<>(days);
        dayBox.setBounds(280, 270, 60, 25);

        String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        JComboBox<String> monthBox = new JComboBox<>(months);
        monthBox.setBounds(190, 270, 80, 25);

        String[] years = new String[100];
        for (int i = 0; i < 100; i++) {
            years[i] = String.valueOf(2023 - i);
        }
        JComboBox<String> yearBox = new JComboBox<>(years);
        yearBox.setBounds(130, 270, 60, 25);

        JLabel MembershipStartDateLabel = new JLabel("MS Date:");
        MembershipStartDateLabel.setBounds(30, 310, 100, 25);

        String[] startDays = new String[31];
        for (int i = 0; i < 31; i++) {
            startDays[i] = String.valueOf(i + 1);
        }
        JComboBox<String> startDayBox = new JComboBox<>(startDays);
        startDayBox.setBounds(280, 310, 60, 25);

        String[] startMonths = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        JComboBox<String> startMonthBox = new JComboBox<>(startMonths);
        startMonthBox.setBounds(190, 310, 80, 25);

        String[] startYears = new String[100];
        for (int i = 0; i < 100; i++) {
            startYears[i] = String.valueOf(2026 - i);
        }
        JComboBox<String> startYearBox = new JComboBox<>(startYears);
        startYearBox.setBounds(130, 310, 60, 25);

        JLabel ReferalLabel = new JLabel("Referral:");
        ReferalLabel.setBounds(400, 30, 100, 30);

        JTextField Referral = new JTextField();
        Referral.setBounds(510, 30, 200, 25);

        JLabel PaidAmountLabel = new JLabel("Paid Amount:");
        PaidAmountLabel.setBounds(400, 70, 100, 25);
        JTextField PaidAmount = new JTextField();
        PaidAmount.setBounds(510, 70, 200, 25);

        JLabel RemovalLabel = new JLabel("Removal Reason:");
        RemovalLabel.setBounds(400, 110, 100, 25);

        JTextField Removal = new JTextField();
        Removal.setBounds(510, 110, 200, 25);

        JLabel TrainerNameLabel = new JLabel("Trainer Name:");
        TrainerNameLabel.setBounds(400, 150, 100, 25);

        JTextField TrainerName = new JTextField();
        TrainerName.setBounds(510, 150, 200, 25);

        JLabel PlanLabel = new JLabel("Plan:");
        PlanLabel.setBounds(400, 310, 100, 25);

        String[] plans = { "Basic", "Standard", "Deluxe" };
        JComboBox<String> Plan = new JComboBox<>(plans);
        Plan.setBounds(510, 310, 200, 25);

        JButton AddRegularMember = new JButton(" Add Regular Member");
        AddRegularMember.setBounds(30, 400, 180, 35);

        JButton AddPremiumMember = new JButton("Premium Member");
        AddPremiumMember.setBounds(230, 400, 180, 35);

        JButton ActivateMembership = new JButton("Activate Membership");
        ActivateMembership.setBounds(430, 400, 180, 35);

        JButton DeactivateMembership = new JButton("Deactivate Membership");
        DeactivateMembership.setBounds(630, 400, 180, 35);

        JButton clearButton = new JButton("Clear Fields");
        clearButton.setBounds(30, 450, 180, 35);

        clearButton.addActionListener(e -> {
                    Id.setText("");
                    name.setText("");
                    location.setText("");
                    Phone.setText("");
                    Email.setText("");
                    Referral.setText("");
                    PaidAmount.setText("");
                    Removal.setText("");
                    TrainerName.setText("");
                    group.clearSelection();
                    dayBox.setSelectedIndex(0);
                    monthBox.setSelectedIndex(0);
                    yearBox.setSelectedIndex(0);
                    startDayBox.setSelectedIndex(0);
                    startMonthBox.setSelectedIndex(0);
                    startYearBox.setSelectedIndex(0);
                    Plan.setSelectedIndex(0);
            });

        JButton MarkAttendanceButton = new JButton("Mark Attendance");
        MarkAttendanceButton.setBounds(230, 450, 180, 35);

        JButton RevertMemberButton = new JButton("Revert Member");
        RevertMemberButton.setBounds(430, 450, 180, 35);

        JButton DisplayButton = new JButton("Display");
        DisplayButton.setBounds(630, 450, 180, 35);

        JLabel RegularPlanLabel = new JLabel("Regular Plan:");
        RegularPlanLabel.setBounds(400, 190, 100, 25);

        JTextField RegularPlanField = new JTextField("6500");
        RegularPlanField.setBounds(510, 190, 200, 25);
        RegularPlanField.setEditable(false);

        JLabel PremiumPlanLabel = new JLabel("Premium Plan:");
        PremiumPlanLabel.setBounds(400, 230, 100, 25);

        JTextField PremiumPlanField = new JTextField("20000");
        PremiumPlanField.setBounds(510, 230, 200, 25);
        PremiumPlanField.setEditable(false);

        JLabel DiscountAmountLabel = new JLabel("Discount Amount:");
        DiscountAmountLabel.setBounds(400, 270, 100, 25);

        JTextField DiscountAmountField = new JTextField("2000");
        DiscountAmountField.setBounds(510, 270, 200, 25);
        DiscountAmountField.setEditable(false);

        JButton ReadFromFileButton = new JButton("Read from File");
        ReadFromFileButton.setBounds(325, 550, 180, 35); 

        ReadFromFileButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try (BufferedReader reader = new BufferedReader(new FileReader("MemberDetails.txt"))) {
                        StringBuilder fileContent = new StringBuilder();
                        String line;

                        while ((line = reader.readLine()) != null) {
                            fileContent.append(line).append("\n");
                        }

                        JOptionPane.showMessageDialog(frame, 
                            fileContent.toString(), 
                            "Member Details from File", 
                            JOptionPane.INFORMATION_MESSAGE);

                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(frame, 
                            "File not found. Save data first!", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, 
                            "Error reading file: " + ex.getMessage(), 
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        /**
         * Action listener for the Add Regular Member button.
         * It retrieves the input data, creates a RegularMember object,
         * and adds it to the gym members list.
         */
        AddRegularMember.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        int id = Integer.parseInt(Id.getText());
                        String memberName = name.getText();
                        String memberLocation = location.getText();
                        String memberPhone = Phone.getText();
                        String memberEmail = Email.getText();

                        String memberGender = "";
                        if (maleButton.isSelected()) {
                            memberGender = "Male";
                        } else if (femaleButton.isSelected()) {
                            memberGender = "Female";
                        } else {
                            JOptionPane.showMessageDialog(frame, "Please select a gender.");
                            return;
                        }

                        String dob = yearBox.getSelectedItem() + "-" +
                            monthBox.getSelectedItem() + "-" +
                            dayBox.getSelectedItem();

                        String msDate = startYearBox.getSelectedItem() + "-" +
                            startMonthBox.getSelectedItem() + "-" +
                            startDayBox.getSelectedItem();

                        String memberReferral = Referral.getText();

                        if (memberName.isEmpty() || memberLocation.isEmpty() || // checking if required fields are filled up
                        memberPhone.isEmpty() || memberEmail.isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Please fill in all required fields.");
                            return;
                        }

                        RegularMember member = new RegularMember(id, memberName, memberLocation,
                                memberPhone, memberEmail, memberGender,
                                dob, msDate, memberReferral);

                        String selectedPlan = (String) Plan.getSelectedItem();
                        member.upgradePlan(selectedPlan);

                        regularMembers.add(member);
                        gymMembers.add(member);

                        JOptionPane.showMessageDialog(frame, "Regular Member added successfully!");

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid ID number.");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                    }
                }
            });

        /**
         * Action listener for the Add Premium Member button.
         * It retrieves the input data, creates a PremiumMember object,
         */
        AddPremiumMember.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        int id = Integer.parseInt(Id.getText());
                        String memberName = name.getText();
                        String memberLocation = location.getText();
                        String memberPhone = Phone.getText();
                        String memberEmail = Email.getText();

                        String memberGender = ""; // checking if gender is selected
                        if (maleButton.isSelected()) {
                            memberGender = "Male";
                        } else if (femaleButton.isSelected()) {
                            memberGender = "Female";
                        } else {
                            JOptionPane.showMessageDialog(frame, "Please select a gender.");
                            return;
                        }

                        String dob = yearBox.getSelectedItem() + "-" +
                            monthBox.getSelectedItem() + "-" +
                            dayBox.getSelectedItem();

                        String msDate = startYearBox.getSelectedItem() + "-" +
                            startMonthBox.getSelectedItem() + "-" +
                            startDayBox.getSelectedItem();

                        String trainerName = TrainerName.getText();

                        if (memberName.isEmpty() || memberLocation.isEmpty() ||
                        memberPhone.isEmpty() || memberEmail.isEmpty() ||
                        trainerName.isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Please fill in all required fields.");
                            return;
                        }

                        PremiumMember member = new PremiumMember(id, memberName, memberLocation,
                                memberPhone, memberEmail, memberGender,
                                dob, msDate, trainerName);

                        if (!PaidAmount.getText().isEmpty()) {
                            double amount = Double.parseDouble(PaidAmount.getText());
                            String paymentResult = member.payDueAmount(amount);
                            JOptionPane.showMessageDialog(frame, paymentResult);

                            String discountResult = member.calculateDiscount();
                            if (!discountResult.startsWith("fullpayment")) {
                                JOptionPane.showMessageDialog(frame, discountResult);
                            }
                        }

                        premiumMembers.add(member);
                        gymMembers.add(member);

                        JOptionPane.showMessageDialog(frame, "Premium Member added successfully!");

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Please enter valid numeric values.");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                    }
                }
            });

        /**
         * Action listener for the Activate Membership button.
         */
        ActivateMembership.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        int id = Integer.parseInt(Id.getText());
                        boolean found = false;

                        for (GymMember member : gymMembers) {
                            if (member.getId() == id) {
                                member.activateMembership();
                                found = true;
                                JOptionPane.showMessageDialog(frame, "Membership activated for ID: " + id);
                                break;
                            }
                        }

                        if (!found) {
                            JOptionPane.showMessageDialog(frame, "Member with ID " + id + " not found.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid ID number.");
                    }
                }
            });

        /**
         * Action listener for the Deactivate Membership button.
         */
        DeactivateMembership.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        int id = Integer.parseInt(Id.getText());
                        boolean found = false;

                        for (GymMember member : gymMembers) {
                            if (member.getId() == id) {
                                member.deactiveMembership();
                                found = true;
                                JOptionPane.showMessageDialog(frame, "Membership deactivated for ID: " + id);
                                break;
                            }
                        }

                        if (!found) {
                            JOptionPane.showMessageDialog(frame, "Member with ID " + id + " not found.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid ID number.");
                    }
                }
            });

        /**
         * Action listener for the Mark Attendance button.
         */
        MarkAttendanceButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        int id = Integer.parseInt(Id.getText());
                        boolean found = false;

                        for (GymMember member : gymMembers) {
                            if (member.getId() == id) {
                                if (member.isActiveStatus()) {
                                    member.markAttendance();
                                    found = true;
                                    JOptionPane.showMessageDialog(frame, "Attendance marked for ID: " + id);
                                } else {
                                    JOptionPane.showMessageDialog(frame,
                                        "Member is not active. Please activate the membership first.");
                                }
                                break;
                            }
                        }

                        if (!found) {
                            JOptionPane.showMessageDialog(frame, "Member with ID " + id + " not found.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid ID number.");
                    }
                }
            });

        /**
         * Action listener for the Revert Member button.
         */
        RevertMemberButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        int id = Integer.parseInt(Id.getText());
                        boolean found = false;

                        for (GymMember member : gymMembers) {
                            if (member.getId() == id && member instanceof PremiumMember) {
                                PremiumMember premMember = (PremiumMember) member;

                                premMember.revertPremiumMember();

                                JOptionPane.showMessageDialog(frame,
                                    "Premium Member (ID: " + id + ") reverted successfully!");
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            JOptionPane.showMessageDialog(frame,
                                "Premium Member with ID " + id + " not found.");
                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid ID number.");
                    }
                }
            });

        /**
         * Action listener for the Display button.
         * used for displaying member details.
         */
        DisplayButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        int id = Integer.parseInt(Id.getText());
                        boolean found = false;

                        for (GymMember member : gymMembers) {
                            if (member.getId() == id) {
                                found = true;

                                name.setText(member.getName());
                                location.setText(member.getLocation());
                                Phone.setText(member.getPhone());
                                Email.setText(member.getEmail());

                                if (member.getGender().equals("Male")) {
                                    maleButton.setSelected(true);
                                } else {
                                    femaleButton.setSelected(true);
                                }

                                StringBuilder details = new StringBuilder();
                                details.append("ID: ").append(member.getId()).append("\n");
                                details.append("Name: ").append(member.getName()).append("\n");
                                details.append("Location: ").append(member.getLocation()).append("\n");
                                details.append("Phone: ").append(member.getPhone()).append("\n");
                                details.append("Email: ").append(member.getEmail()).append("\n");
                                details.append("Gender: ").append(member.getGender()).append("\n");
                                details.append("DOB: ").append(member.getDOB()).append("\n");
                                details.append("Membership Start Date: ").append(member.getMembershipStartDate())
                                .append("\n");
                                details.append("Attendance: ").append(member.getAttendance()).append("\n");
                                details.append("Loyalty Points: ").append(member.getLoyaltyPoints()).append("\n");
                                details.append("Status: ").append(member.isActiveStatus() ? "Active" : "Inactive")
                                .append("\n");

                                if (member instanceof RegularMember) {
                                    RegularMember regMember = (RegularMember) member;
                                    details.append("Member Type: Regular Member\n");
                                    details.append("Plan: ").append(regMember.getPlanType()).append("\n");
                                    details.append("Plan Price: ").append(regMember.getPlanPrice(regMember.getPlanType()))
                                    .append("\n");
                                } else if (member instanceof PremiumMember) {
                                    PremiumMember premMember = (PremiumMember) member;
                                    details.append("Member Type: Premium Member\n");
                                    details.append("Personal Trainer: ").append(premMember.getPersonalTrainer())
                                    .append("\n");
                                    details.append("Premium Charge: ").append(premMember.getPremiumCharge()).append("\n");
                                }

                                JOptionPane.showMessageDialog(frame, details.toString(), "Member Details",
                                    JOptionPane.INFORMATION_MESSAGE);
                                break;
                            }
                        }

                        if (!found) {
                            JOptionPane.showMessageDialog(frame, "Member with ID " + id + " not found.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid ID number.");
                    }
                }
            });

        JButton upgradeButton = new JButton("Upgrade Plan");
        upgradeButton.setBounds(30, 500, 180, 35);

        upgradeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        int id = Integer.parseInt(Id.getText());
                        String selectedPlan = (String) Plan.getSelectedItem();
                        boolean found = false;

                        for (GymMember member : gymMembers) {
                            if (member.getId() == id && member instanceof RegularMember) {
                                RegularMember regMember = (RegularMember) member;

                                String result = regMember.upgradePlan(selectedPlan);

                                JOptionPane.showMessageDialog(frame, result);
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            JOptionPane.showMessageDialog(frame,
                                "Regular Member with ID " + id + " not found.");
                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid ID number.");
                    }
                }
            });

        JButton calculateDiscountButton = new JButton("Calculate Discount");
        calculateDiscountButton.setBounds(230, 500, 180, 35);

        calculateDiscountButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        int id = Integer.parseInt(Id.getText());
                        boolean found = false;

                        for (GymMember member : gymMembers) {
                            if (member.getId() == id && member instanceof PremiumMember) {
                                PremiumMember premMember = (PremiumMember) member;

                                String discountMessage = premMember.calculateDiscount();

                                DiscountAmountField.setText(String.valueOf(premMember.getDiscountAmount()));
                                JOptionPane.showMessageDialog(frame, discountMessage);
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            JOptionPane.showMessageDialog(frame,
                                "Premium Member with ID " + id + " not found.");
                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid ID number.");
                    }
                }
            });

        JButton paydueamountButton = new JButton("Pay Due Amount");
        paydueamountButton.setBounds(430, 500, 180, 35);

        paydueamountButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        int id = Integer.parseInt(Id.getText());
                        double amount = Double.parseDouble(PaidAmount.getText());
                        boolean found = false;

                        for (GymMember member : gymMembers) {
                            if (member.getId() == id && member instanceof PremiumMember) {
                                PremiumMember premMember = (PremiumMember) member;

                                String result = premMember.payDueAmount(amount);

                                JOptionPane.showMessageDialog(frame, result);
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            JOptionPane.showMessageDialog(frame,
                                "Premium Member with ID " + id + " not found.");
                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame,
                            "Please enter a valid ID and amount (numbers only).");
                    }
                }
            });

        JButton SavetofileButton = new JButton("Save");
        SavetofileButton.setBounds(630, 500, 180, 35);

        SavetofileButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try (PrintWriter writer = new PrintWriter(new FileWriter("MemberDetails.txt"))) {

                        writer.println(String.format("%-5s %-15s %-10s %-15s %-20s %-10s %-10s %-15s %-15s",
                                "ID", "Name", "Type", "Plan", "Membership Start", "Attendance", "Loyalty", "Status",
                                "Balance/Due"));

                        for (GymMember member : gymMembers) {
                            if (member instanceof RegularMember) {
                                RegularMember reg = (RegularMember) member;
                                writer.println(String.format("%-5d %-15s %-10s %-20s %-15s %-10d %-10.2f %-15s %-15s",
                                        member.getId(),
                                        member.getName(),
                                        "Regular",
                                        reg.getPlanType(),
                                        member.getMembershipStartDate(),
                                        member.getAttendance(),
                                        member.getLoyaltyPoints(),
                                        member.isActiveStatus() ? "Active" : "Inactive",
                                        "N/A"));
                            } else if (member instanceof PremiumMember) {
                                PremiumMember prem = (PremiumMember) member;
                                writer.println(String.format("%-5d %-15s %-10s %-20s %-15s %-10d %-10.2f %-15s %-15.2f",
                                        member.getId(),
                                        member.getName(),
                                        "Premium",
                                        "Premium",
                                        member.getMembershipStartDate(),
                                        member.getAttendance(),
                                        member.getLoyaltyPoints(),
                                        member.isActiveStatus() ? "Active" : "Inactive",
                                        prem.getPremiumCharge() - prem.getPaidAmount()));
                            }
                        }

                        JOptionPane.showMessageDialog(frame,
                            "All member data saved to MemberDetails.txt!");

                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame,
                            "Error saving file: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        frame.add(SavetofileButton);
        frame.add(paydueamountButton);
        frame.add(calculateDiscountButton);
        frame.add(upgradeButton);
        frame.add(DiscountAmountLabel);
        frame.add(DiscountAmountField);
        frame.add(PremiumPlanLabel);
        frame.add(PremiumPlanField);
        frame.add(RegularPlanLabel);
        frame.add(RegularPlanField);
        frame.add(MarkAttendanceButton);
        frame.add(RevertMemberButton);
        frame.add(DisplayButton);
        frame.add(clearButton);
        frame.add(DeactivateMembership);
        frame.add(ActivateMembership);
        frame.add(AddPremiumMember);
        frame.add(AddRegularMember);
        frame.add(PlanLabel);
        frame.add(Plan);
        frame.add(TrainerNameLabel);
        frame.add(TrainerName);
        frame.add(RemovalLabel);
        frame.add(PaidAmountLabel);
        frame.add(Removal);
        frame.add(PaidAmount);
        frame.add(Referral);
        frame.add(ReferalLabel);
        frame.add(MembershipStartDateLabel);
        frame.add(startYearBox);
        frame.add(startMonthBox);
        frame.add(startDayBox);
        frame.add(yearBox);
        frame.add(monthBox);
        frame.add(dayBox);
        frame.add(DOBLabel);
        frame.add(femaleButton);
        frame.add(maleButton);
        frame.add(GenderLabel);
        frame.add(Phone);
        frame.add(Phonelabel);
        frame.add(Email);
        frame.add(EmailLabel);
        frame.add(location);
        frame.add(LocationLabel);
        frame.add(Id);
        frame.add(label);
        frame.add(Namelabel);
        frame.add(name);
        frame.add(ReadFromFileButton);

        frame.setVisible(true);
    }

}