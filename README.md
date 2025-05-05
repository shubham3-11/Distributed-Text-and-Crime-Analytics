# Distributed-Text-and-Crime-Analytics

📦 Overview
This project demonstrates distributed data processing using Hadoop MapReduce and Apache Spark. The tasks span textual analysis, weather data parsing, crime analytics, and geospatial proximity filtering, culminating in a visual KML output.

📁 **Part 1: Hadoop MapReduce Jobs**
✅ Task 0 – Word Count
File: WordCount.java
Counts the frequency of each word in words.txt.
Mapper: Tokenizes lines into words and emits (word, 1)
Reducer: Aggregates counts for each word
📄 Output sample:
python-repl
Copy code
Aaron    1  
Abbasside    1  
...  

✅ Task 1 – Letter Frequency Counter
File: LetterCounter.java
Counts the frequency of each letter (a–z), case-insensitive.
Mapper: Emits every letter (a-z) in lowercase
Reducer: Sums total occurrences per letter
📄 Output sample (sorted):
css
Copy code
e   235374  
i   201069  
a   199578  
...  

✅ Task 2 – Find Words Containing “fun”
File: FindPattern.java
Extracts all words from words.txt that contain the substring “fun”, case-insensitive.
Mapper: Filters and emits matching words
Reducer: Identity reducer
📄 Output sample:
python-repl
Copy code
afunction  
defunct  
Fungia  
...  

✅ Task 3 – Max Temperature by Year
Files: MaxTemperatureMapper.java, MaxTemperatureReducer.java
Extracts and finds the maximum temperature from combinedYears.txt.
Mapper: Parses fixed-width year and temp
Reducer: Outputs the max temperature per year
📄 Output sample:
yaml
Copy code
1901    317  
1902    244  

✅ Task 4 – Min Temperature by Year
Files: MinTemperatureMapper.java, MinTemperatureReducer.java
Similar to Task 3 but computes the minimum temperature.
📄 Output sample:
yaml
Copy code
1901    -333  
1902    -328  

✅ Task 5 – Count Violent Crimes
File: CrimeCount.java
Counts total incidents of Aggravated Assault and Robbery from P1V.txt.
📄 Output sample:
nginx
Copy code
Crime    24879  

✅ Task 6 – Assaults Near 3803 Forbes
File: CrimeNearForbes.java
Counts Aggravated Assaults within 100 meters of 3803 Forbes Ave (using Euclidean distance).
📄 Output sample:
nginx
Copy code
Assaults near Forbes    31  

✅ Task 7 – Crime KML Visualizer
File: CrimeKML.java
Generates a .kml file for visualizing Aggravated Assaults near Forbes in Google Earth.
Mapper only: Outputs placemarks with longitude & latitude
📄 Output format (KML placemarks):
xml
Copy code
<Placemark><name>Aggravated Assault</name>
<Point><coordinates>-79.945,40.442,0</coordinates></Point></Placemark>
...

⚡ **Part 2: Apache Spark – Shakespeare Analytics**
File: ShakespeareAnalytics.java
Analyzes All’s Well That Ends Well using Apache Spark.
✔ Features:
Task
Description
Task 0
Count number of lines
Task 1
Count total number of words
Task 2
Count number of distinct words
Task 3
Count total number of symbols
Task 4
Count number of distinct symbols
Task 5
Count distinct letters (case-sensitive)
Task 6
Search and return lines containing a specific word

📄 Sample output:
yaml
Copy code
Number of lines: 5647  
Number of words: 29909  
Number of distinct words: 4598  
Number of symbols: 157323  
Number of distinct symbols: 90  
Number of distinct letters: 52  
✏️ Search example:
sql
Copy code
Enter a word to search (case-sensitive): love
--> Lines containing 'love' from the play

🗂️ **Directory Structure**
Each task is organized into its respective directory under:
javascript
Copy code
~/Project5/Part_1/TaskX/
~/Project5/Part_2/
Outputs are merged from HDFS after each job.

⚙️ **Technologies Used**
Java, Apache Hadoop MapReduce API, Apache Spark
Google Earth KML, Shell scripting
Cluster execution using CMU Jumbo Hadoop environment

