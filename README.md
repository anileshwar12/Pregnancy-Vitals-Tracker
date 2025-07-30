# 🤰 Pregnancy Vitals Tracker

A modern Android application built using Jetpack Compose and MVVM architecture, designed for pregnant women to easily log and track vital health metrics. The app includes automated reminders using WorkManager to ensure consistent tracking and health awareness.

---

## ✅ Features

- **Vitals Logging**
  - Log key health indicators:  
    - Systolic & Diastolic Blood Pressure  
    - Heart Rate  
    - Weight  
    - Baby Kicks Count
  - Input through a clean, intuitive Jetpack Compose dialog.
  - Data saved using Room database.

- **Real-Time UI Updates**
  - Vitals list updates immediately on adding new entries.
  - State management handled using `StateFlow` for reactive UI.

- **Automated Reminders**
  - Sends notifications every 5 hours to remind the user to log vitals.
  - Notification opens the app directly on the logging screen.

- **User Interface**
  - Built entirely in Jetpack Compose.
  - Material3 components with responsive and clean design.
  - Floating Action Button for quick vitals entry.

---

## 🛠 Tech Stack

| Layer             | Technology          |
|------------------|---------------------|
| Language          | Kotlin              |
| UI Framework      | Jetpack Compose     |
| Architecture      | MVVM                |
| Database          | Room                |
| State Management  | StateFlow           |
| Dependency Injection | Koin             |
| Background Tasks  | WorkManager         |
| Notifications     | Android Notification APIs  |

---

## 📷 Screenshots

| Main Screen | Add Vitals Dialog | Reminder Notification |
|-------------|-------------------|------------------------|
| ![Main Screen](screenshots/main_screen.png) | ![Add Dialog](screenshots/add_dialog.png) | ![Notification](screenshots/notification.png) |

---

## 🔧 How to Run

### 📥 Clone the Repository

```bash
git clone https://github.com/yourusername/pregnancy-vitals-tracker.git
cd pregnancy-vitals-tracker
```



## 🧭 Open the Project in Android Studio

- Open Android Studio  
- Click on **"Open an existing project"**  
- Select the cloned folder

---

## 🔨 Build the Project

- Let Gradle sync and resolve dependencies  
- Wait until the **"Build finished"** message appears

---

## ▶️ Run the App

- Connect a physical device or start an emulator  
- Press the green **▶️ Run** button in Android Studio

---

## 🔔 Grant Notification Permission

- When prompted, allow the app to send notifications  
- This is required for the vitals reminder feature to function properly

