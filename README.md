Dictionary Attack - Password Cracking Tool
This Java project demonstrates a dictionary-based attack to crack MD5-hashed passwords. The program compares hashed passwords against a wordlist (e.g., the popular rockyou.txt) to find matches.

Features
Load Hashed Passwords: Reads MD5-hashed passwords from a file.
Dictionary-Based Attack: Uses a provided wordlist to attempt to find plaintext matches.
MD5 Hashing: Simulates how passwords might be hashed for comparison.
Prerequisites
Java: Ensure you have Java installed. The code is compatible with Java 8 and later.
Password Hashes File:
Create or use an existing file containing MD5-hashed passwords (default: passwords.txt).
Wordlist File:
Obtain a wordlist such as rockyou.txt (not included for licensing reasons).
Setup and Usage
Clone or Download the Repository:

bash
Copy code
git clone https://github.com/your-username/dictionary-attack.git
cd dictionary-attack
Prepare Input Files:

Place your hashed passwords file in the same directory as the program. The default file name is passwords.txt. If your file has a different name, update the code to reflect it:
java
Copy code
List<String> hashedPasswords = loadHashedPasswords("<your-file-name>");
Download a wordlist such as rockyou.txt and place it in the directory. Adjust the dictionary path in the code if needed:
java
Copy code
List<String> dictionary = loadDictionary("<your-dictionary-file>");
Compile the Code: Compile the Java file using:

bash
Copy code
javac DictionaryAttack.java
Run the Program: Execute the compiled program:

bash
Copy code
java DictionaryAttack
Input Files
1. passwords.txt
A file containing MD5-hashed passwords, one per line.
Example:
Copy code
5f4dcc3b5aa765d61d8327deb882cf99
e10adc3949ba59abbe56e057f20f883e
2. rockyou.txt (or similar dictionary file)
A wordlist containing plaintext passwords.
Example:
Copy code
password
123456
qwerty
Limitations
Algorithm: Only supports MD5 hashing. To support other algorithms, modify the hashPassword method.
Performance: The attack is single-threaded, making it slow for large datasets. Optimizations like parallel processing can improve performance.
Disclaimer
This tool is for educational purposes only. Use responsibly and only on systems you own or have explicit permission to test. Unauthorized use is illegal and unethical.

License
This project is open-source and available under the MIT License.
