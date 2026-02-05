public class Main {
    int assignmentPoints = 0;
    int examPoints = 0;
    int projectPoints = 0;

    void addAssignmentPoints(int points) {
        assignmentPoints += points;
    }

    void addExamPoints(int points) {
        examPoints += points;
    }

    void addProjectPoints(int points) {
        projectPoints += points;
    }

    void printTotal() {
        int total = assignmentPoints + examPoints + projectPoints;
        System.out.println("Total score: " + total);
    }

    String getGrade() {
        int total = assignmentPoints + examPoints + projectPoints;

        if (total <= 50) {
            return "-3";
        } else if (total <= 70) {
            return "00";
        } else if (total <= 85) {
            return "7";
        } else {
            return "12";
        }
    }

    void main(String[] args) {
        addAssignmentPoints(25);
        addExamPoints(40);
        addProjectPoints(30);

        printTotal();
        System.out.println("Karakter: " + getGrade());
    }
}