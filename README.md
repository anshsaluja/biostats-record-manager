# Health Department Biostats Manager

A Java-based personal data management tool simulating a government health department’s system. It allows importing, managing, and exporting citizens' biostatistics using a custom array-based storage (no `ArrayList` used).

---

## 📁 Project Structure

- `Person.java` – Represents an individual with name, gender, age, height, and weight.
- `PersonDataManager.java` – Manages an array of `Person` objects. Handles file imports, additions, deletions, and lookups.
- `PersonManager.java` – CLI interface for user interaction.
- `PersonAlreadyExistException.java` – Custom exception when duplicate entries are added.
- `PersonDoesNotExistException.java` – Custom exception when accessing a non-existent entry.
- `biostats.csv` – Sample input file for testing.

---

## 🧱 Data Structures Used

- **Static Array** (`Person[]`): Custom managed array with dynamic resizing.
- **Custom Exceptions**: For robust user input validation and error handling.

---

## 🚀 Features

- Import data from `.csv`
- Add person to array (keeps alphabetical order)
- Remove a person by name
- Retrieve and display specific person’s info
- Print full table in tabular format
- Save data to new `.csv` file
- Input validation and exception safety

---

## 🖥️ How to Run

1. **Compile**
```bash
javac *.java
```

2. **Run**
```bash
java PersonManager
```

3. **Sample CSV Format**
```
Name,Sex,Age,Height (in),Weight (lbs)
Alex,M,41,74,170
Elly,F,30,66,124
...
```

---

## 📋 Sample CLI Usage

```
(I) – Import from File
(A) – Add Person
(R) – Remove Person
(G) – Get Info on Person
(P) – Print Table
(S) – Save to File
(Q) – Quit
```

---

## 📌 Example Output

```
Name   Age  Gender   Height     Weight
=========================================
Alex   41   M        6'2"       170 lbs
Elly   30   F        5'6"       124 lbs
...
```

---

## ✅ Notes

- CSV must be clean and sorted by name.
- Uses only core Java (`java.io`, no external libs).
- Designed to be robust, user-friendly, and modular.

---

## License
This project is not open source. All rights reserved © 2025 Ansh Saluja.

