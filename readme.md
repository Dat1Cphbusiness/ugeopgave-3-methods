# Ugeopgave: Metoder og Objekter

**Formål:** Træning i metoder (uden/med parametre, return-værdier) og simple klasser med objekter.

**Tidsramme:** Ca. 6 timer

## Opgaver
1. [Bank-konto](#opgave-1-bank-konto)
2. [Karakter-beregner](#opgave-2-karakter-beregner)
3. [Pris-beregner](#opgave-3-pris-beregner)
4. [Statistik-beregner](#opgave-4-statistik-beregner)
5. [Student klasse](#opgave-5-student-klasse)
6. [Product klasse](#opgave-6-product-klasse)

---

## Opgave 1: Bank-konto

Lav et program der simulerer en simpel bankkonto med metoder til at indsætte og hæve penge.

**Globale variable:**
- `balance` (double)
- `accountName` (String)

**Metoder du skal lave:**
- `deposit100()` - indsætter 100 kr
- `withdraw50()` - hæver 50 kr
- `printBalance()` - udskriver saldo

**I main:**
1. Sæt `accountName` til dit navn
2. Kald `deposit100()` to gange
3. Kald `withdraw50()` én gang
4. Udskriv saldoen

**Ekstra udfordring:** Lav en metode `deposit200()` og brug Scanner til at spørge brugeren hvor mange gange de vil indsætte 200 kr.

<details>
<summary>Trin-for-trin guide</summary>

1. Opret to globale variable `balance` og `accountName` uden for metoderne
2. Lav metoden `deposit100()` der lægger 100 til `balance`
3. Lav metoden `withdraw50()` der trækker 50 fra `balance`
4. Lav metoden `printBalance()` der udskriver kontonavn og saldo
5. I main: sæt kontonavn, kald metoderne i den rigtige rækkefølge

</details>

<details>
<summary>Se svar</summary>

```java
import java.util.Scanner;

public class BankAccount {
    double balance = 0;
    String accountName;
    
     void deposit100() {
        balance += 100;
    }
    
     void withdraw50() {
        balance -= 50;
    }
    
     void printBalance() {
        System.out.println(accountName + " har " + balance + " kr");
    }
    
     void deposit200() {
        balance += 200;
    }
    
     void main(String[] args) {
        accountName = "Anders";
        
        deposit100();
        deposit100();
        withdraw50();
        printBalance();
        
        // Ekstra udfordring
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hvor mange gange vil du indsætte 200 kr? ");
        int times = scanner.nextInt();
        
        for (int i = 0; i < times; i++) {
            deposit200();
        }
        
        printBalance();
    }
}
```

</details>

---

## Opgave 2: Karakter-beregner

Lav et program der holder styr på point fra forskellige afleveringer og beregner den samlede score.

**Globale variable:**
- `assignmentPoints` (int)
- `examPoints` (int)
- `projectPoints` (int)

**Metoder med parametre:**
- `addAssignmentPoints(int points)` - tilføjer point til assignment
- `addExamPoints(int points)` - tilføjer point til eksamen
- `addProjectPoints(int points)` - tilføjer point til projekt
- `printTotal()` - udskriver total score

**I main:**
1. Tilføj 25 assignment points
2. Tilføj 40 exam points
3. Tilføj 30 project points
4. Udskriv totalen

**Ekstra udfordring:** Lav en metode `getGrade()` der returnerer karakteren baseret på total score (0-50: -3, 51-70: 00, 71-85: 7, 86-100: 12).

<details>
<summary>Trin-for-trin guide</summary>

1. Opret tre globale variable til de forskellige point-typer
2. Lav tre metoder der hver tager én int parameter og lægger den til den tilsvarende variabel
3. Lav `printTotal()` der udregner og udskriver summen af alle tre variabler
4. I main: kald metoderne med forskellige point-værdier
5. For ekstra udfordring: lav en metode der bruger if-else til at returnere en String baseret på total

</details>

<details>
<summary>Se svar</summary>

```java
public class GradeCalculator {
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
```

</details>

---

## Opgave 3: Pris-beregner

Lav et program til en webshop der beregner slutprisen på et produkt ved at anvende rabat og derefter moms.

**Metoder der returnerer værdier:**
- `applyDiscount(double price, double discountPercent)` - returnerer pris efter rabat
- `addTax(double price)` - returnerer pris inkl. 25% moms
- `calculateFinalPrice(double basePrice, double discount)` - bruger de to andre metoder

**I main:**
1. Start med en basispris på 500 kr
2. Anvend 20% rabat
3. Tilføj moms
4. Udskriv slutprisen

**Ekstra udfordring:** Brug Scanner til at lade brugeren indtaste basispris og rabatprocent. Brug en switch-case til at give forskellige rabatter baseret på kundetyper (normal, student, senior).

<details>
<summary>Trin-for-trin guide</summary>

1. Lav `applyDiscount()` der tager pris og rabatprocent som parametre, beregner den nye pris og returnerer den
2. Lav `addTax()` der tager en pris, ganger med 1.25 og returnerer resultatet
3. Lav `calculateFinalPrice()` der kalder først `applyDiscount()`, gemmer resultatet, og sender det videre til `addTax()`
4. I main: kald `calculateFinalPrice()` og gem resultatet i en variabel, udskriv det
5. For ekstra: brug switch til at vælge rabat baseret på kundeType (String)

</details>

<details>
<summary>Se svar</summary>

```java
import java.util.Scanner;
    
    double applyDiscount(double price, double discountPercent) {
        return price * (1 - discountPercent / 100);
    }
    
   double addTax(double price) {
        return price * 1.25;
    }
    
    double calculateFinalPrice(double basePrice, double discount) {
        double priceAfterDiscount = applyDiscount(basePrice, discount);
        double finalPrice = addTax(priceAfterDiscount);
        return finalPrice;
    }
    
    void main() {
        double finalPrice = calculateFinalPrice(500, 20);
        System.out.println("Slutpris: " + finalPrice + " kr");
        
        // Ekstra udfordring
        Scanner scanner = new Scanner(System.in);
        System.out.print("Indtast basispris: ");
        double basePrice = scanner.nextDouble();
        
        System.out.print("Kundetype (normal/student/senior): ");
        String customerType = scanner.next();
        
        double discount = 0;
        switch (customerType) {
            case "normal":
                discount = 0;
                break;
            case "student":
                discount = 15;
                break;
            case "senior":
                discount = 10;
                break;
            default:
                discount = 0;
        }
        
        finalPrice = calculateFinalPrice(basePrice, discount);
        System.out.println("Slutpris med " + discount + "% rabat: " + finalPrice + " kr");
    }

```

</details>

---

## Opgave 4: Statistik-beregner

Lav et program der analyserer et array af tal og beregner forskellige statistikker.

**Metoder der arbejder med arrays:**
- `calculateAverage(int[] numbers)` - returnerer gennemsnittet
- `findMax(int[] numbers)` - returnerer det største tal
- `findMin(int[] numbers)` - returnerer det mindste tal
- `countAboveAverage(int[] numbers)` - returnerer antal tal over gennemsnittet

**I main:**
1. Opret et array med tallene: 45, 67, 23, 89, 34, 56, 78
2. Beregn og udskriv gennemsnit, max og min
3. Udskriv hvor mange tal der er over gennemsnittet

**Ekstra udfordring:** Lav en metode `printAllStats(int[] numbers)` der kalder alle de andre metoder og præsenterer resultaterne pænt.

<details>
<summary>Trin-for-trin guide</summary>

1. Lav `calculateAverage()` - brug en løkke til at summere alle tal, divider med array længde, returner
2. Lav `findMax()` - start med første tal som max, gennemløb array med løkke, opdater max hvis større tal findes
3. Lav `findMin()` - samme som max, bare omvendt
4. Lav `countAboveAverage()` - kald først `calculateAverage()`, brug løkke til at tælle hvor mange der er større
5. I main: opret array og kald metoderne

</details>

<details>
<summary>Se svar</summary>

```java
public class StatisticsCalculator {
    
    double calculateAverage(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.length;
    }
    
     int findMax(int[] numbers) {
        int max = numbers[0];
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    
    int findMin(int[] numbers) {
        int min = numbers[0];
        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
    
    int countAboveAverage(int[] numbers) {
        double average = calculateAverage(numbers);
        int count = 0;
        for (int num : numbers) {
            if (num > average) {
                count++;
            }
        }
        return count;
    }
    
    void printAllStats(int[] numbers) {
        System.out.println("=== Statistik ===");
        System.out.println("Gennemsnit: " + calculateAverage(numbers));
        System.out.println("Største tal: " + findMax(numbers));
        System.out.println("Mindste tal: " + findMin(numbers));
        System.out.println("Antal over gennemsnit: " + countAboveAverage(numbers));
    }
    
    void main(String[] args) {
        int[] numbers = {45, 67, 23, 89, 34, 56, 78};
        
        System.out.println("Gennemsnit: " + calculateAverage(numbers));
        System.out.println("Max: " + findMax(numbers));
        System.out.println("Min: " + findMin(numbers));
        System.out.println("Over gennemsnit: " + countAboveAverage(numbers));
        
        System.out.println();
        
        // Ekstra udfordring
        printAllStats(numbers);
    }
}
```

</details>

---

## Opgave 5: Student klasse

Lav en klasse der repræsenterer studerende og arbejd med flere studerende i et array.

**Student klasse med:**
- Felter: `name` (String), `age` (int)
- Constructor der tager name og age
- Metode: `printInfo()` - udskriver studentens info

**I main:**
1. Opret 3 studerende med forskellige navne og aldre
2. Put dem i et array
3. Brug en løkke til at udskrive info for alle studerende
4. Find og udskriv den ældste studerende

**Ekstra udfordring:** Tilføj et felt `studentId` (String) til klassen. Lav en metode der finder en studerende baseret på ID.

<details>
<summary>Trin-for-trin guide</summary>

1. Opret Student.java fil med klassen Student
2. Lav to felter: name og age
3. Lav en constructor der modtager name og age som parametre og tildeler dem til felterne
4. Lav `printInfo()` metode der udskriver navn og alder
5. I main: opret 3 Student objekter med new
6. Opret et Student array og læg objekterne ind
7. Brug for-each løkke til at kalde printInfo() på hver studerende
8. Brug en løkke med if til at finde den ældste

</details>

<details>
<summary>Se svar</summary>

```java
// Student.java
public class Student {
    String name;
    int age;
    String studentId;
    
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public Student(String name, int age, String studentId) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
    }
    
    public void printInfo() {
        System.out.println(name + " er " + age + " år");
        if (studentId != null) {
            System.out.println("  ID: " + studentId);
        }
    }
}

// Main.java
public class Main {
    
    Student findOldest(Student[] students) {
        Student oldest = students[0];
        for (Student s : students) {
            if (s.age > oldest.age) {
                oldest = s;
            }
        }
        return oldest;
    }
    
    Student findById(Student[] students, String id) {
        for (Student s : students) {
            if (s.studentId != null && s.studentId.equals(id)) {
                return s;
            }
        }
        return null;
    }
    
    void main(String[] args) {
        Student s1 = new Student("Anna", 21);
        Student s2 = new Student("Peter", 19);
        Student s3 = new Student("Maria", 23);
        
        Student[] students = {s1, s2, s3};
        
        System.out.println("Alle studerende:");
        for (Student s : students) {
            s.printInfo();
        }
        
        Student oldest = findOldest(students);
        System.out.println("\nÆldste studerende:");
        oldest.printInfo();
        
        // Ekstra udfordring
        System.out.println("\n=== Med student ID ===");
        Student st1 = new Student("Anna", 21, "S001");
        Student st2 = new Student("Peter", 19, "S002");
        Student st3 = new Student("Maria", 23, "S003");
        
        Student[] studentsWithId = {st1, st2, st3};
        
        Student found = findById(studentsWithId, "S002");
        if (found != null) {
            System.out.println("Fundet studerende med ID S002:");
            found.printInfo();
        }
    }
}
```

</details>

---

## Opgave 6: Product klasse

Lav en klasse der repræsenterer produkter i en webshop med tags.

**Product klasse med:**
- Felter: `name` (String), `price` (double), `tags` (String array)
- Constructor der tager name, price og tags
- Metode: `printInfo()` - udskriver produkt info inkl. tags
- Metode: `hasTag(String tag)` - returnerer true hvis produktet har det tag

**I main:**
1. Opret 4 produkter med forskellige tags (f.eks. "electronics", "sale", "new")
2. Put dem i et array
3. Find og udskriv alle produkter med "sale" tag
4. Find og udskriv det dyreste produkt

**Ekstra udfordring:** Lav en metode der finder alle produkter inden for et prisinterval (min, max).

<details>
<summary>Trin-for-trin guide</summary>

1. Opret Product.java med klassen Product
2. Lav felter for name, price og tags (String array)
3. Lav constructor der modtager alle tre parametre
4. Lav `printInfo()` der udskriver navn, pris og løber gennem tags med løkke
5. Lav `hasTag()` der løber gennem tags array og returnerer true hvis den finder matchet
6. I main: opret produkter, put i array
7. Løb gennem array og check hasTag("sale"), udskriv hvis true
8. Find dyreste produkt med løkke der sammenligner price

</details>

<details>
<summary>Se svar</summary>

```java
// Product.java
public class Product {
    String name;
    double price;
    String[] tags;
    
    public Product(String name, double price, String[] tags) {
        this.name = name;
        this.price = price;
        this.tags = tags;
    }
    
    public void printInfo() {
        System.out.println(name + " - " + price + " kr");
        System.out.print("  Tags: ");
        for (int i = 0; i < tags.length; i++) {
            System.out.print(tags[i]);
            if (i < tags.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    
    public boolean hasTag(String tag) {
        for (String t : tags) {
            if (t.equals(tag)) {
                return true;
            }
        }
        return false;
    }
}

// Main.java
public class Main {
    
    Product findMostExpensive(Product[] products) {
        Product mostExpensive = products[0];
        for (Product p : products) {
            if (p.price > mostExpensive.price) {
                mostExpensive = p;
            }
        }
        return mostExpensive;
    }
    
    void findProductsInPriceRange(Product[] products, double min, double max) {
        System.out.println("Produkter mellem " + min + " og " + max + " kr:");
        for (Product p : products) {
            if (p.price >= min && p.price <= max) {
                p.printInfo();
            }
        }
    }
    
     void main(String[] args) {
        Product p1 = new Product("Laptop", 5999, new String[]{"electronics", "new"});
        Product p2 = new Product("Mouse", 199, new String[]{"electronics", "sale"});
        Product p3 = new Product("Keyboard", 499, new String[]{"electronics", "sale"});
        Product p4 = new Product("Monitor", 2499, new String[]{"electronics"});
        
        Product[] products = {p1, p2, p3, p4};
        
        System.out.println("Produkter på tilbud:");
        for (Product p : products) {
            if (p.hasTag("sale")) {
                p.printInfo();
            }
        }
        
        System.out.println("\nDyreste produkt:");
        Product expensive = findMostExpensive(products);
        expensive.printInfo();
        
        // Ekstra udfordring
        System.out.println();
        findProductsInPriceRange(products, 200, 1000);
    }
}
```

</details>
