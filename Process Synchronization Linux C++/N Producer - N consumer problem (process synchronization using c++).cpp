/*	This program is used to implement producer-consumer problem using semaphore. 
The code has two cases. 
Each case it involves 3 processes, 2 producers, 2 consumers and a common buffer with 3 slots. 
N.B: The first process is the first producer (producer 1). 
Its child, the second process is a consumer to producer 1 (consumer 1). The second process is also producer 2.
The third process is a consumer to producer 2 (consumer 2).

For case 1:

For simplicity in synchronization the program asks the user which producer to use. 
As the buffer slots are continously cleared after every insertion, thus the buffer can be reused for more than 3 productions. 

For case 2:

The synchronization order is such that producer 1/consumer 1 execute first followed by producer 2/consumer 2. 
Producer 1 uses buffer slot 1 which is consumed after every insertion, and Producer 2 uses buffer slot 2 which is also consumed after every insertion. For simplicity, this case executes only once.   
*/
/*
NAME
Natnael Dereje ATR/9015/11
Robenus Belete ATR/5356/10
*/

#include <unistd.h>
#include <iostream>
#include "SEMAPHOR.cpp" 
#include "SHARED_MF.cpp"
#include <sys/wait.h>

#define MaxItems 3 //define the number of buffer slot 

using namespace std;
int i=1;

int produce_item(){
int v;
cout<<"\nPlease enter a number to produce \t or enter 00 to exit program \n "<<endl;
cin>>v;
if(v==00)
exit(0);
return v;
}


int consume_item(int b){
return b; 
}


void insert_item(int c){
BUFFER[i]=c;
if(i<3)
i++;
else
i=i-2;
}


void insert_item2(int c){
BUFFER[2]=c;
}


int remove_item(){
int d;
d=BUFFER[i];
if(i<3)
i++;
else
i=i-2;
return d;
}
int remove_item2(){
int d;
d=BUFFER[2];
return d;
}


int main ()
{
int val;
initialise_sem (1,3,0);
initialise_buffer (3);

cout<<"        Multiple Producer and Consumer Problem Using Semaphore" <<endl;
cout<<"\nChoose a number from the following options"<<endl;
cout<<"1. To use producer 1"<<endl; //  case(1)
cout<<"2. To use producer 2"<<endl; //  case(1)
cout<<"3. To use producer 1 followed by producer 2"<<endl; // case(2)
cout<<"or any other key to exit\n"<<endl; 
cin>>val;

if(val==1 || val==2) //         *****             case(1)             *****
{
int myPid= fork();//used to create the second process of case(1).
if(myPid>0) //producer #1     for case(1).
{

while (val==1)
{
int itm;
for(int i=1; i <= MaxItems; i++) {
sleep(3);
cout<<"\nProducer 1"<<endl;
itm = produce_item();
down(SECOND);
down(FIRST);
insert_item(itm);
cout<<"\nThe item inserted to buffer slot "<<i<<" by producer 1 is :  "<<BUFFER[i]<<"\n"<<endl;
up(FIRST);
up(THIRD);
}
i=1;
}
wait(&myPid);
}

else if (myPid==0) //consumer #1    for case(1).
{
while (val==1)
{
for(int i = 1; i <= MaxItems; i++) {
sleep(2);
int itm;
down(THIRD);
down(FIRST);
itm= remove_item();
up(FIRST);
up(SECOND);
cout<<"\nConsumer 1 has consumed: "<<consume_item(itm)<<endl;
}
i=1;
}

int myPid2= fork(); //used to create the third process of case(1).

if(myPid2>0) //producer #2      for case(1).
{

while (val==2)
{
int itm;
for(int i = 1; i <= MaxItems; i++) {
sleep(2);
cout<<"\nProducer 2"<<endl;
itm = produce_item();
down(SECOND);
down(FIRST);
insert_item(itm);
cout<<"\nThe item inserted to buffer slot "<<i<<" by producer 2 is :  "<<BUFFER[i]<<"\n"<<endl;
up(FIRST);
up(THIRD);
}
i=1;
}
}
else if (myPid2==0) // consumer #2    for case(1).
{ 
while (val==2){
for(int i = 1; i <= MaxItems; i++) {
sleep(3);
int itm;
down(THIRD);
down(FIRST);
itm= remove_item();
up(FIRST);
up(SECOND);
cout<<"\n\nConsumer 2 has consumed: "<<consume_item(itm)<<endl;
}
i=1;
}
close_buffer();
close_sem();
}
}
else
{
cout<<"Fork failed"<<endl; 
return -1;
}
}

////////////****/////////


else if(val==3)   //            *****               case(2)              *****
{
int myPid3= fork();//used to create the second process of case (2).

if(myPid3>0) //producer #1  for case(2).
{
cout<<"Producer 1"<<endl;
int itm;
sleep(3);
cout<<"\n"<<endl;
itm = produce_item();
down(SECOND);
down(FIRST);
insert_item(itm);
cout<<"\nThe item inserted to buffer slot "<<1<<" by producer 1 is :  "<<BUFFER[1]<<"\n"<<endl;
up(FIRST);
up(THIRD);

wait(&myPid3);
}


else if (myPid3==0) //consumer #1   for case(2).
{

int itm;
down(THIRD);
down(FIRST);
itm= remove_item();
up(FIRST);
up(SECOND);
cout<<"\nConsumer 1 has consumed: "<<consume_item(itm)<<endl;

int myPid4= fork(); //used to create the third process of case(2).

if(myPid4>0) //producer #2     for case(2).
{
sleep(2);
cout<<"\nProducer 2"<<endl;
int itm;
itm = produce_item();
down(SECOND);
down(FIRST);
insert_item2(itm);
cout<<"\nThe item inserted to buffer slot "<<2<<" by producer 2 is :  "<<BUFFER[2]<<"\n"<<endl;
up(FIRST);
up(THIRD);
}

else if (myPid4==0) // consumer #2     for case(2).
{ 
sleep(3);
int itm;
down(THIRD);
down(FIRST);
itm= remove_item2();
up(FIRST);
up(SECOND);		
cout<<"\n\nConsumer 2 has consumed: "<<consume_item(itm)<<endl;
close_buffer();
close_sem();
}
}
else
{
cout<<"Fork failed"<<endl; 
return -1;
}
}

return 0;
}
