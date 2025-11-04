# 💧 FlowCtrl System
### Your Personal Cycle Companion  
A Java console application for **CS 211 Final Project**

---

## 🧠 Overview
**FlowCtrl System** is a console-based menstrual cycle tracker built using Java.  
It helps users record their cycle dates, moods, and symptoms, predict their next cycle, and export reports — all while demonstrating **Object-Oriented Programming (OOP)** principles.

The system provides a friendly command-line interface where users can:
- Sign up and log in securely  
- Record and view their menstrual cycles  
- Predict their next cycle start date  
- Export a personalized report as a `.txt` file  

---

## ⚙️ Features

| Feature | Description |
|----------|-------------|
| 🧍 **Sign Up / Log In** | Create and access user accounts securely |
| 🩸 **Add Cycle** | Record cycle start and end dates, mood, and symptoms |
| 📖 **View Cycle History** | View all recorded cycles |
| 🌙 **Predict Next Cycle** | Calculates average cycle length and predicts next date |
| 📄 **Export Report** | Generates a `.txt` report file with user data |
| 🚫 **Exception Handling** | Handles invalid dates, mismatched passwords, and input errors |

---

## 🧩 OOP Concepts Used

| OOP Concept | Implementation in FlowCtrl System |
|--------------|----------------------------------|
| **Encapsulation** | Private fields and getters/setters in `User` and `Cycle` classes |
| **Inheritance** | `PremiumUser` extends `User` with enhanced reporting features |
| **Polymorphism** | Overridden `getDetailedInfo()` method in `PremiumUser` |
| **Abstraction** | `Reportable` interface defines `generateReport()` |
| **Exception Handling** | Custom `InvalidDateException` used for invalid input |
| **Arrays** | `String[] symptoms` array in `Cycle` class |
| **Collections** | `ArrayList` for cycles and `HashMap` for users |

---

## 💻 How to Run the Program (VS Code or CMD)

### 📦 Requirements
- **Java JDK 17 or higher**
- **VS Code** with *Extension Pack for Java*
- (Optional) **Code Runner** extension for one-click execution

### ▶️ Steps
1. Open **VS Code**.
2. Go to **File → Open Folder** and select your project folder (e.g., `FlowCtrlSystem`).
3. Ensure all `.java` files are inside that folder.
4. Open the integrated terminal (**Ctrl + `**) and type:
   ```bash
   javac *.java
   java Main
