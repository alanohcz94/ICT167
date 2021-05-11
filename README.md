# ICT167 Coin denomination

This programs, returns denomination of coins provided by the customers.

Requirements
------------
1) Input via Text file "coins.txt" -> this text file has name and coins in this format (Jane 130)
2) A menu will be prompt to user to input either '1' or '2' as follows
    --------------------------------
    1) Enter name
    2) Exit
    --------------------------------
3) Search name if input is '1'. User will have to input a name to be searched
    --------------------------------
    Enter a name:
    --------------------------------
   -3.1) If name provided could not be found prompt "Not Found"
   -3.2) If name provided is found
   example output: if Jane gives 130
    ------------------------------------
          Customer:
          Jane 130

          50 cents: 2
          20 cents: 1
          10 cents: 1
    ------------------------------------
4) If input is '2' write to a CSV file and end the program.
