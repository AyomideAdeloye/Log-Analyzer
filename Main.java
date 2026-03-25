// Using the scanner class from the utility library
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        /**
         * Array of strings that shows the kind of events
         * that real servers generate
         */
        String[] logs = {
            "INFO: System boot complete",
            "WARNING: Disk usage at 85%",
            "ERROR: Failed login attempt for user admin",
            "INFO: Scheduled backup started",
            "ERROR: Network timeout while contacting server",
            "INFO: Backup completed successfully",
            "WARNING: High memory usage detected",
            "INFO: User logged out",
            "ERROR: Permission denied accessing /secure"
        };

        LogAnalyzer analyzer = new LogAnalyzer(logs);

        System.out.println(analyzer.generateReport());

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a keyword to search: ");
        
        // This waits for user to type something and press Enter
        String keyword = scanner.nextLine();

        int occurrences = analyzer.countKeyword(keyword);

        System.out.println("The keyword '" + keyword + "' appears in "
                + occurrences + " log entries.");

        scanner.close();
    }
}