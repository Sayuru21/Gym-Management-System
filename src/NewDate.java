import java.util.Scanner;

public class NewDate {
    private int day;
    private int month;
    private int year;
    int newYear;
    int newMonth;
    int newDay;

    public NewDate() {
        validate();
        this.day = this.day;
        this.month = this.month;
        this.year = this.year;
    }

    public static String validate() {
        while(true) {
            while(true) {
                int newYear;
                Scanner scanner;
                try {
                    scanner = new Scanner(System.in);
                    System.out.print("Enter the Year(YYYY) : ");
                    newYear = scanner.nextInt();
                    if (newYear < 1920 || newYear > 2120) {
                        System.out.println("Start membership date is not in range.");
                        System.out.println("-----------------------------------------------------------------");
                        continue;
                    }
                } catch (Exception var6) {
                    System.out.println("Input is not valid");
                    System.out.println("-----------------------------------------------------------------");
                    continue;
                }

                int newMonth;
                while(true) {
                    try {
                        scanner = new Scanner(System.in);
                        System.out.print("Enter the Month(MM) : ");
                        newMonth = scanner.nextInt();
                        if (newMonth >= 1 && newMonth <= 12) {
                            break;
                        }

                        System.out.println("Month is out of range");
                        System.out.println("-----------------------------------------------------------------");
                    } catch (Exception var5) {
                        System.out.println("Input is not valid");
                        System.out.println("-----------------------------------------------------------------");
                    }
                }

                int newDay;
                while(true) {
                    try {
                        scanner = new Scanner(System.in);
                        System.out.print("Enter the day(DD) : ");
                        newDay = scanner.nextInt();
                        if (newYear % 4 != 0) {
                            if (newMonth == 9 || newMonth == 10 || newMonth == 11) {
                                if (newDay <= 30 && newDay >= 1) {
                                    break;
                                }

                                System.out.println("April,June,September,October,November should have 30 days.");
                                System.out.println("-----------------------------------------------------------------");
                            }

                            if (newMonth == 8 || newMonth == 12) {
                                if (newDay <= 31 && newDay >= 1) {
                                    break;
                                }

                                System.out.println("January,March,May,July,August,December should have 31 days.");
                                System.out.println("-----------------------------------------------------------------");
                            }

                            if (newMonth == 2) {
                                if (newDay <= 28 && newDay >= 1) {
                                    break;
                                }

                                System.out.println("Normally, February should have 28 days except leap year.");
                                System.out.println("-----------------------------------------------------------------");
                            } else if (newMonth % 2 == 0) {
                                if (newDay <= 30 && newDay >= 1) {
                                    break;
                                }

                                System.out.println("April,June,September,October,November should have 30 days.");
                                System.out.println("-----------------------------------------------------------------");
                            } else if (newMonth % 2 == 1) {
                                if (newDay <= 31 && newDay >= 1) {
                                    break;
                                }

                                System.out.println("January,March,May,July,August,December should have 31 days.");
                                System.out.println("-----------------------------------------------------------------");
                            }
                        } else {
                            if (newMonth == 9 || newMonth == 10 || newMonth == 11) {
                                if (newDay <= 30 && newDay >= 1) {
                                    break;
                                }

                                System.out.println("April,June,September,October,November should have 30 days.");
                                System.out.println("-----------------------------------------------------------------");
                            }

                            if (newMonth == 8 || newMonth == 12) {
                                if (newDay <= 31 && newDay >= 1) {
                                    break;
                                }

                                System.out.println("January,March,May,July,August,December should have 31 days.");
                                System.out.println("-----------------------------------------------------------------");
                            }

                            if (newMonth == 2) {
                                if (newDay <= 29 && newDay >= 1) {
                                    break;
                                }

                                System.out.println("February should have 28 days because this is a leap year.");
                                System.out.println("-----------------------------------------------------------------");
                            } else if (newMonth % 2 == 0) {
                                if (newDay <= 30 && newDay >= 1) {
                                    break;
                                }

                                System.out.println("April,June,September,October,November should have 30 days.");
                                System.out.println("-----------------------------------------------------------------");
                            } else if (newMonth % 2 == 1) {
                                if (newDay <= 31 && newDay >= 1) {
                                    break;
                                }

                                System.out.println("January,March,May,July,August,December should have 31 days.");
                                System.out.println("-----------------------------------------------------------------");
                            }
                        }
                    } catch (Exception var4) {
                        System.out.println("Input is not valid");
                        System.out.println("-----------------------------------------------------------------");
                    }
                }

                String startMembershipDate = newDay + "/" + newMonth + "/" + newYear;
                return startMembershipDate;
            }
        }
    }
}
