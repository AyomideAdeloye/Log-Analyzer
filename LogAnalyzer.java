/**
 * Log Analysis tool that simulates how real systems 
 * classify and seach log data
 */

public class LogAnalyzer {
    private String[] logs;

    // Constructor
    /**
     * It receives logb data from Main.java
     * 
     * @param logs
     */
    public LogAnalyzer(String[] logs) {
        this.logs = logs;
    }

    // Count how many logs start with a specific level (e.g., "ERROR", "WARNING", "INFO")
    public int countLevel(String level) {
        int count = 0;

        for (int i = 0; i < logs.length; i++) {
            if (logs[i].startsWith(level + ":")) {
                count++;
            }
        }

        return count;
    }

    public int countErrors() {
        return countLevel("ERROR");
    }

    public int countWarnings() {
        return countLevel("WARNING");
    }

    public int countInfos() {
        return countLevel("INFO");
    }

    // Get the first N logs (quick preview)
    public String preview(int n) {
        if (n <= 0) return "No preview requested.";

        int limit = Math.min(n, logs.length);
        String result = "";

        for (int i = 0; i < limit; i++) {
            result += (i + 1) + ") " + logs[i] + "\n";
        }

        return result;
    }
    // This compares the counts and returns which level shows up most.
    public String mostCommonLevel() {
        int errors = countErrors();
        int warnings = countWarnings();
        int infos = countInfos();

        if (errors >= warnings && errors >= infos) {
            return "ERROR";
        } else if (warnings >= errors && warnings >= infos) {
            return "WARNING";
        } else {
            return "INFOS";
        }
    }

    /**
     * This converts both the log line and the keyword to lowercase
     * Checks if the log contains that word
     * Counts how many lines match
     * @param keyword
     * @return
     */
    public int countKeyword(String keyword) {
        int count = 0;
        String target = keyword.toLowerCase();

        /**
         * .contains checks each logs
         */
        for (int i = 0; i < logs.length; i++) {
            String line = logs[i].toLowerCase();
            if (line.contains(target)) {
                count++;
            }
        }
        
        return count;
    }

    // Generate a full report string
    public String generateReport() {
        int errors = countErrors();
        int warnings = countWarnings();
        int infos = countInfos();
        int total = logs.length;

        String report = "";
        report += "===== LOG ANALYSIS REPORT =====\n";
        report += "Total Entries: " + total + "\n";
        report += "ERROR: " + errors + "\n";
        report += "WARNING: " + warnings + "\n";
        report += "INFO: " + infos + "\n";
        report += "\nTop Preview:\n";
        report += preview(5);
        report += "===============================\n";

        return report;
    }
}