# 🖥️ file2printMonitor

**The desktop companion application for [File2Print](https://github.com/cajx-it/File2Print) — monitor incoming client submissions in real time, right from your desktop.**

[![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=flat-square&logo=java&logoColor=white)](https://www.java.com/)
[![JavaFX](https://img.shields.io/badge/JavaFX-Desktop_App-007396?style=flat-square)](https://openjfx.io/)
[![License](https://img.shields.io/badge/License-MIT-blue?style=flat-square)](LICENSE)
[![Status](https://img.shields.io/badge/Status-Active-brightgreen?style=flat-square)]()

---

## 🧩 What is file2printMonitor?

[File2Print](https://github.com/cajx-it/File2Print) lets clients upload their files through a web browser — organized automatically into folders by client name and date. But once a submission comes in, how do you know about it right away?

**file2printMonitor** solves that. It's a JavaFX desktop application that watches the File2Print `uploads/` directory and gives you a real-time dashboard of all incoming client submissions — no need to manually check folders, no missed jobs.

> ✅ Built for **printing shops**, **computer services**, **internet cafés**, and any business running File2Print on their local network.

---

## ✨ Features

- 🔔 **Real-Time Monitoring** — Automatically detects new client submissions the moment they arrive in the uploads folder
- 📋 **Submission Dashboard** — View all incoming jobs with client name, submission date, and file list at a glance
- 🗂️ **Organized Overview** — Mirrors the folder structure created by File2Print for quick reference
- 🖥️ **Native Desktop Experience** — Runs as a standalone JavaFX application on Windows, macOS, and Linux
- ⚡ **Lightweight** — Minimal resource footprint; runs quietly in the background while you work
- 🔗 **Seamless Integration** — Works directly with File2Print's `uploads/` directory — no extra configuration needed

---

## 🔗 How It Fits Into the File2Print Ecosystem

```
[Client's Browser]
       │
       │  uploads files via web form
       ▼
[File2Print Web Server]  ──────────────────────────────────────────┐
  (Node.js / Express)                                              │
       │                                                           │
       │  saves to /uploads/<ClientName>-<Date>/                   │
       ▼                                                           │
[uploads/ folder on your machine]                                  │
       │                                                           │
       │  watched in real time                                      │
       ▼                                                           │
[file2printMonitor]  ◄─────────────────────────────────────────────┘
  (JavaFX Desktop App)
  → Notifies you of new submissions
  → Displays client name, files, and timestamp
```

file2printMonitor is a **companion tool** — File2Print handles the intake, and file2printMonitor keeps you informed.

---

## 🚀 Getting Started

### Prerequisites

- **Java 17 or higher** — [Download JDK](https://adoptium.net/)
- **JavaFX SDK** — [Download JavaFX](https://openjfx.io/) *(if not bundled)*
- A running instance of **[File2Print](https://github.com/cajx-it/File2Print)** with an accessible `uploads/` directory

Verify your Java version:

```bash
java -version   # Should output 17.x.x or higher
```

---

### Installation

**1. Clone the repository**

```bash
git clone https://github.com/cajx-it/file2printMonitor.git
cd file2printMonitor
```

**2. Open in your IDE**

This project uses the **Eclipse e(fx)clipse** build system. Open it in:
- [Eclipse IDE](https://www.eclipse.org/downloads/) with the e(fx)clipse plugin, **or**
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) with JavaFX support configured

**3. Build the application**

Using Eclipse:
```
Right-click project → Export → JavaFX → Ant-based Build
```

Or build from the command line using the generated Ant build script:
```bash
ant -f build.xml
```

**4. Run the application**

The compiled executable will be placed in:
```
bin/application/
```

Run it with:
```bash
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -jar file2printMonitor.jar
```

---

### Configuration

On first launch, point file2printMonitor to your File2Print `uploads/` directory. The app will begin watching that folder immediately and display any existing or new client submissions.

---

## 🗂️ Project Structure

```
file2printMonitor/
├── src/                    # Java source files
├── bin/
│   └── application/        # Compiled output / packaged executable
├── .settings/              # Eclipse IDE settings
├── .classpath              # Eclipse classpath configuration
├── .project                # Eclipse project definition
├── build.fxbuild           # JavaFX Ant build configuration
└── README.md
```

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|------------|
| Language | Java 17+ |
| UI Framework | JavaFX |
| Build System | Eclipse e(fx)clipse / Ant |
| IDE | Eclipse |
| File Watching | Java NIO WatchService |

---

## 🤝 Related Project

| Repo | Description |
|------|-------------|
| [📁 File2Print](https://github.com/cajx-it/File2Print) | The web-based file intake system — clients upload files through a browser |
| [🖥️ file2printMonitor](https://github.com/cajx-it/file2printMonitor) | This repo — the desktop monitoring dashboard for shop operators |

---

## 🤝 Contributing

Contributions are welcome! If you have ideas for improvements or find a bug:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/your-feature`)
3. Commit your changes (`git commit -m 'Add your feature'`)
4. Push to the branch (`git push origin feature/your-feature`)
5. Open a Pull Request

---

## 📄 License

This project is licensed under the **MIT License** — see the [LICENSE](LICENSE) file for details.

---

Made with ❤️ by [cajx-it](https://github.com/cajx-it)

*File2Print takes the files in. file2printMonitor keeps you in the loop.*
