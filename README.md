# **PatInformed Automation**

This project automates searching for patents on the [WIPO Pat-Informed](https://patinformed.wipo.int/) website using **Selenium WebDriver** and **TestNG**.

## **📌 Features**
✅ Open the **Pat-Informed** website  
✅ Accept **terms and conditions**  
✅ Search for a patent dynamically **based on user input**  
✅ Click on the first result  
✅ Extract and display the **Filing Date** and **Publication Date**  

---

## **🛠️ Technologies Used**
- **Java** (Programming Language)  
- **Selenium WebDriver** (Automation Framework)  
- **TestNG** (Testing Framework)  
- **Maven** (Dependency Management)  

---

## **📥 Installation & Setup**

### **1️⃣ Prerequisites**
Ensure you have the following installed on your system:
- **Java (JDK 11 or later)** → Check with:  
  ```sh
  java -version
  ```
- **Apache Maven** → Check with:  
  ```sh
  mvn -v
  ```
- **Google Chrome** (latest version)  
- **ChromeDriver** (Ensure it matches your Chrome version)  
- **Git (optional, for version control)** → Check with:  
  ```sh
  git --version
  ```

---

### **2️⃣ Clone the Repository**
Run the following command in your terminal or command prompt:
```sh
git clone https://github.com/Mahadeva1437/TestAssignment.git
cd TestAssignment
```

---

## **🚀 How to Build & Run the Maven Project**

### **1️⃣ Navigate to the Project Directory**
```sh
cd C:\Users\Dell\eclipse-workspace2\TestAssignment
```

### **2️⃣ Clean the Project**
```sh
mvn clean
```

### **3️⃣ Compile the Source Code**
```sh
mvn compile
```

### **4️⃣ Run Unit Tests** (if applicable)
```sh
mvn test
```

### **5️⃣ Package the Project**
```sh
mvn package
```
This will generate a **JAR** or **WAR** file inside the `target/` folder.

### **6️⃣ Run the Application**

#### **A) If It’s a Java Application (`.jar` File)**
```sh
java -jar target/TestAssignment-0.0.1-SNAPSHOT.jar
```

#### **B) If It’s a Web Application (`.war` File)**
Deploy the `.war` file to Tomcat or run:
```sh
mvn tomcat7:run
```

#### **C) If the Project Has a `main` Method**
```sh
mvn exec:java -Dexec.mainClass="com.example.MainClass"
```
Replace `com.example.MainClass` with your actual **fully qualified class name**.

---

## **📤 How to Push Latest Code to GitHub**

### **1️⃣ Check the Status**
```sh
git status
```

### **2️⃣ Add Changes**
```sh
git add .
```

### **3️⃣ Commit the Changes**
```sh
git commit -m "Latest code update with fixes"
```

### **4️⃣ Pull the Latest Code to Avoid Conflicts**
```sh
git pull origin main --rebase
```

### **5️⃣ Push the Code to GitHub**
```sh
git push origin main
```

---

## **❓ Troubleshooting**

### **Check Java & Maven Versions**
```sh
java -version
mvn -v
```

### **Enable Debugging for Maven Build Issues**
```sh
mvn clean install -X
```

### **If Git Push is Rejected (Remote Changes Exist)**
```sh
git pull origin main --rebase
git push origin main
```

---

## **📜 License**
This project is **open-source** and available under the [MIT License](LICENSE).

---

🚀 **Now your Maven project is ready to run and automate patent searches!** Let me know if you need any modifications. 😊
