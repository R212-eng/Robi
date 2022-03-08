#!/bin/bash

#comment section

<<BY
Robenus Belete     ATR/5356/10
Samuel Negalign    ATR/2574/10
BY

<<ABOUT_THE_PROGRAM 
This program displays the daily schedule when a valid number is selected. If user selects an invalid number it displays an error message and informs the user to try again. Incase the exit choice is selected the program exits successfully. Otherwise, invalid formats result in exit with an error message. 
ABOUT_THE_PROGRAM


#code section

echo -e " 
\e[1;42m------- Welcome to the 5th year CS weekly schedule board program -------\e[0m"

# Initialize variables
cns="Computer and Network Security" 
aad="Algorithm Analysis and Design"
itc="Introduciton to compilers"
rmp="Research Methods and Presentation "
es="Embedded Systems"
os="Operating Systems"
day=1                   

until (($day==0))
do
echo " 
To see a class schedule, please enter a day of the week:

1 for Monday 
2 for Tuesday  
3 for Wednesday
4 for Thursday 
5 for Friday 
6 for Saturday  
7 for Sunday or 
0 to exit"

echo
read day 

case $day in

"1")
echo -e " 
\e[1;44m <Monday>
2:30-4:00 "$cns" 
4:30-6:00 "$aad" 
7:30-9:00 "$itc" \e[0m" ;;

"2")
echo -e "
\e[1;44m <Tuesday>
2:30-4:00 "$rmp"
4:30-6:00 "$es" 
7:30-11:00 "$aad" \e[0m" ;;


"3")
echo -e "
\e[1;44m <Wednesday>
2:30-4:00 "$os" 
7:30-11:00 "$itc" \e[0m";;

"4")
echo -e "
\e[1;44m <Thursday> 
2:30-4:00 "$es" 
4:30-6:00 "$cns"  
7:30-11:00 "$os" \e[0m";;

"5"|"6"|"7")
echo -e "
\e[1;44m No class on this day \e[0m" ;;

"0")
echo -e "
\e[1;37m Program exited successfully. Thank you! \e[0m" 
echo;;

*)
{
if ((day!=0))
then 
echo -e "
\e[1;41m Invaild number, Please enter a valid number in the range 0-7 \e[0m"
else
echo -e " \e[1;41m
Error, program exited due to wrong input format. \e[0m"
break;
fi
};;

esac
done





