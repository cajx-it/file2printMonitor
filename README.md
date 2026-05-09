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
┌─────────────────────────────────┐
│   Docker Container              │
│   (File2Print Web Server)       │
│   Node.js / Express on :3000    │
│                                 │
│   saves to /uploads/            │
│   <ClientName>-<Date>/          │
└──────────────┬──────────────────┘
               │  volume mount
               │  (shared with host)
               ▼
[uploads/ folder on your machine]
               │
               │  watched in real time
               ▼
     [file2printMonitor]
       (JavaFX Desktop App)
       → Notifies you of new submissions
       → Displays client name, files, and timestamp
```

file2printMonitor is a **companion tool** — File2Print runs inside Docker and handles the intake, while file2printMonitor runs natively on your desktop to keep you informed.

---

## 🐳 File2Print — Docker Setup (Required)

file2printMonitor monitors the `uploads/` folder that **File2Print** writes to. File2Print must be running inside a **Docker container** with its `uploads/` directory mounted to a folder on your host machine — this is the folder that file2printMonitor watches.

### Step 1 — Clone and set up File2Print

```bash
git clone https://github.com/cajx-it/File2Print.git
cd File2Print
```

### Step 2 — Build the Docker image

```bash
docker build -t file2print .
```

### Step 3 — Run the container with a volume mount

The key here is mounting the container's `/app/uploads` to a local folder on your machine so file2printMonitor can watch it:

```bash
docker run -d \
  -p 3000:3000 \
  -v /path/to/your/local/uploads:/app/uploads \
  --name file2print \
  file2print
```

> 💡 Replace `/path/to/your/local/uploads` with an actual folder on your machine, for example:
> - **Windows:** `C:/Users/YourName/uploads`
> - **macOS/Linux:** `/home/yourname/uploads`

### Step 4 — Verify it's running

```bash
docker ps
```

Clients on your local network can now access the upload form at:

```
http://<your-local-ip>:3000
```

> ⚠️ **Important for file2printMonitor:** The local path you mount (e.g., `./uploads` or `C:/Users/YourName/uploads`) is the folder you will configure file2printMonitor to watch. Make sure both point to the same location.

---

## 🚀 Getting Started

### Prerequisites

- **Java 17 or higher** — [Download JDK](https://adoptium.net/)
- **JavaFX SDK** — [Download JavaFX](https://openjfx.io/) *(if not bundled)*
- **Docker** — [Download Docker Desktop](https://www.docker.com/products/docker-desktop/) *(required to run File2Print)*
- A running instance of **[File2Print](https://github.com/cajx-it/File2Print)** in Docker with its `uploads/` folder mounted to your host machine (see [Docker Setup](#-file2print--docker-setup-required) above)

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

On first launch, point file2printMonitor to your **local mounted `uploads/` folder** — the same path you used as the volume mount when running the File2Print Docker container (e.g., `C:/Users/YourName/uploads` or `/home/yourname/uploads`). The app will begin watching that folder immediately and display any existing or new client submissions.

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
| Backend (File2Print) | Node.js / Express (Dockerized) |
| Containerization | Docker / Docker Compose |

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
