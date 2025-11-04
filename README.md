# ProjectDraft_FLOWCTRL
Just like programmers manage data flow, FlowCtrl helps users manage their body’s flow, naturally and intuitively. This console-based menstrual tracker lets users log period dates, symptoms, and moods while intelligently predicting upcoming cycles. Simple, smart, and private, it’s self-care written in code.

# 💧 FlowCtrl System
### Your Personal Cycle Companion

## 1. Description / Overview
FlowCtrl System is a Java console application that helps users track their menstrual cycles, moods, and symptoms. It predicts the next cycle and exports personalized reports.

## 2. OOP Concepts Applied
- **Encapsulation:** Private attributes with getters/setters in User and Cycle classes.
- **Inheritance:** PremiumUser extends User.
- **Polymorphism:** generateReport() method overridden for PremiumUser.
- **Abstraction:** Reportable interface implemented by ReportGenerator.
- **Exception Handling:** Custom exception for invalid dates or input mismatch.

## 3. Program Structure
- `Main` – Main menu and navigation.
- `User` – Stores user data and cycle history.
- `Cycle` – Represents a menstrual cycle.
- `CycleManager` – Adds/view/predict cycles.
- `ReportGenerator` – Creates text reports.

## 4. How to Run the Program
1. Open terminal or command prompt.  
2. Navigate to the project folder.  
3. Compile: `javac *.java`  
4. Run: `java Main`

## 5. Sample Output
(Include screenshots or code blocks like the sample you showed.)

## 6. Authors and Acknowledgment
- [Your names here]

## 7. Future Enhancements
- Add database for saving user data.
- Add health tips and reminders.
