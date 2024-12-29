package Com;

import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) throws Exception {
        UserDao dao = new UserDao();

        Scanner s = new Scanner(System.in);
        System.out.println("**Welcome to the User Application**");

        boolean b = true;

        while (b) {
            System.out.println("1) Press 1 for sign up");
            System.out.println("2) Press 2 for login");
            System.out.println("3) Press 3 for view all users");
            System.out.println("4) Press 4 for view user by ID");
            System.out.println("5) Press 5 to delete user by ID");
            System.out.println("6) Press 6 to Update user by ID");
            System.out.println("7) Press 7 for logout");

            int choice = s.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("**Welcome to the sign-up page**");

                    System.out.println("Enter ID:");
                    int id = s.nextInt();

                    System.out.println("Enter first name:");
                    String fname = s.next();

                    System.out.println("Enter last name:");
                    String lname = s.next();

                    System.out.println("Enter email:");
                    String email = s.next();

                    System.out.println("Enter password:");
                    String password = s.next();

                    System.out.println("Enter gender:");
                    String gender = s.next();

                    System.out.println("Enter phone:");
                    Long phone = s.nextLong();

                    User u = new User();
                    u.setId(id);
                    u.setFname(fname);
                    u.setLname(lname);
                    u.setEmail(email);
                    u.setPassword(password);
                    u.setGender(gender);
                    u.setPhone(phone);

                    dao.saveUser(u);
                    break;
                }
                case 2: {
                	  System.out.println("**Welcome to the Login Page**");

                      int attemptCount = 0;
                      boolean isLoggedIn = false;

                      while (attemptCount < 3 && !isLoggedIn) {
                          System.out.println("Enter Email:");
                          String email = s.next();

                          System.out.println("Enter Password:");
                          String pass = s.next();

                          User u = dao.getByEmail(email);

                          if (u != null) {
                              if (pass.equals(u.getPassword())) {
                                  System.out.println("Login Successful!");
                                  isLoggedIn = true;
                              } else {
                                  System.out.println("Incorrect Password.");
                              }
                          } else {
                              System.out.println("Email Not Found.");
                          }

                          attemptCount++;

                          if (attemptCount == 3 && !isLoggedIn) {
                              System.out.println("3 incorrect attempts. Please Sign Up first.");
                              break;
                          }
                      }
                      break;
                }
                case 3: {
                    System.out.println("**Viewing all users**");
                    List<User> users = dao.fetchAll();
                    for (User user : users) {
                        System.out.println(user);
                    }
                    break;
                }
                case 4: {
                    System.out.println("**View user by ID**");

                    System.out.println("Enter ID:");
                    int id = s.nextInt();

                    User user = dao.getById(id);

                    if (user != null) {
                        System.out.println(user);
                    } else {
                        System.out.println("User not found for ID: " + id);
                    }
                    break;
                }
                case 5: {
                    System.out.println("**Delete user by ID**");

                    System.out.println("Enter ID:");
                    int id = s.nextInt();

                    try {
                        dao.deleteById(id);
                        System.out.println("User deleted successfully.");
                    } catch (Exception e) {
                        System.out.println("Error while deleting user: " + e.getMessage());
                    }
                    break;
                }
                case 6:{
                	System.out.println("**Update user**");
                	 System.out.print("Enter the ID of the user to update: ");
                     int id = s.nextInt();

                     System.out.print("Enter New First Name: ");
                     String fname = s.next();

                     System.out.print("Enter New Last Name: ");
                     String lname = s.next();

                     System.out.print("Enter New Gender: ");
                     String gender = s.next();

                     System.out.print("Enter New Email: ");
                     String email = s.next();

                     System.out.print("Enter New Password: ");
                     String password = s.next();

                     User u = new User();
                     u.setId(id);
                     u.setFname(fname);
                     u.setLname(lname);
                     u.setGender(gender);
                     u.setEmail(email);
                     u.setPassword(password);

                     dao.UpdateUser(u);
                     System.out.println("User updated successfully.");
                     break;
                }
                case 7: {
                    System.out.println("**Logout successful**");
                    b = false;
                    break;
                }
                default: {
                    System.out.println("Enter a valid input!");
                }
            }
        }
    }
}
