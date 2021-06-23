Installation guide

First we have to install java in our OS
For Windows
https://java.com/en/download/help/windows_manual_download.html
For Linux
https://java.com/en/download/help/linux_install.html
For Mac
https://java.com/en/download/help/mac_install.html

After Installing Java
Install git or Download this repo as Zip file and use any zip Extractor such as WinRar,7zip
to Extract files
git install link -: https://git-scm.com/book/en/v2/Getting-Started-Installing-Git


after the above process

open the terminal/Cmd, then by using CD command
go to the SIQ_PE1_ParkingLot directory

Same goes with repl.it
Run the below commands in their console

Now run the following commands to run the program

1.javac src/*.java

2.java src/Main.java src/input.txt

For Windows 
1.javac src\\*.java

2.java src\\Main.java src\\input.txt


First command will compile java files and create classes

Second will run the Main class with the path to the test file

Check your terminal screen for the output



Assumptions-:

1.Assumed vehcile number must be in proper format and unique i.e. No duplicates will be provided

2.all commands,vehicle numbers are case insensitive i.e. Leave or leave or leAVe are same KA-01-AB-1234 or ka-01-ab-1234 are same

3.No format check has been done for the vehicle number

3.For Any Invalid command System will output "Invalid Command"

4.age,and slot to leave must be an Integer else
the system will give warning "Invalid command name please provide correct input"

5.Assumed filepath must be provided and file must exist else the system will give warning as well as throw error and halt the execution of the program.

6.Since no output provided in case no vehicle present 
the system will output "No vehicle present for the given age"

7.Assumed all the commands specified must be in proper format else system will give warning

8.System will give warning in case of Inavlid slot number,Slot full, already vacant slot,reinitialisation of parking slot



Approach

whenever a car comes we will have to assign it the minimum distance from parking lot, since this will directly interact with the user it must be a fast paced operation
So intiallly we will push all the avaliable parking lot in our minheap and now we have two scenario

1.either get the minimum number from minheap and assign it to car on entry

2.on exit push it into minheap.

Now at each step may be we get age based query
for this we will maintain
hashmap for faster age query
and a slot array for assign and maintaing slot number to vehicle

1.ageMap which will store the List of vehciledetails basedon their age
->it will give us the vechile details in O(1)