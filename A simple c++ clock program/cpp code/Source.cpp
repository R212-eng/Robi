#include<iostream>
#include<conio.h>
#include<dos.h>
#include<stdio.h>
#include<string.h>
#include<Windows.h>
#include<time.h>
#include<wchar.h>
using namespace std;
class clock1
{
private:
int h,m,s;
char ch,b,c;
public:
	void getdata ();
	void display ();
};
int wmain(void)
		{
clock1 obj;
char ch,b,c;
	cout<< " DEAR USER, WELCOME.\t Thanks for choosing us! \n\n\n\n\n\n";
	cout<<" ******************   This app displays digital clock in geez numerals:   ************* \n\n ";
	cout<<" Press any key to continue "<<endl;
	cin>>b;
	cout<< "\n\n\n Please press 'e' to extract time from the system or any other key to insert your own time value:\t "<<endl;
	cin>>ch;
		
	if ( ch!='e')
	{
		obj.getdata();
	obj.display();
		system ("cls");
}
	
		else
	{
		SYSTEMTIME time;
		while(true)
		{
		GetLocalTime(&time);
		wprintf( L"The local time is : %02d:%02d:%02d\n", time.wHour,time.wMinute,time.wSecond); 
		
	Sleep (1000);
	system("Cls");
	
		}

		}
		system ("pause");
	return 0;	
getch();
}

void clock1::display()
{
for(s=s;s<=60;s++)
	{		
		if (s>59)
		{
			s=0;
			m++;
		}
		if (m>59)
		{
			s=0;
			m=0;
			h++;
		}
		if(h>12)
		{
			s=0;
			m=0;
			h=1;
		}

		cout<<"The local time is: "<< h<<" : "<<m<<" : "<<s;
		Sleep(1000);
		
		system("Cls");
}
}
void clock1::getdata()
{
    cout<< "Enter hour value:\t";
		cin>>h;
		cout<<" Enter minute value:\t";
		cin>>m;
		cout<< " Enter second value:\t";
		cin>>s;
	
		if (h==0||h>12||m>59||s>59)
	{
	do
	{cout<< " \n\nPlease enter a valid time value for a 12 hour system "<<endl; 
	cout<< "\nEnter hour value:\t";
		cin>>h
			;
	cout<<" Enter minute value:\t";
		cin>>m;
		cout<< " Enter second value:\t";
		cin>>s;

	if(h==0||h>12||m>59||s>59)
	{
		cout<< " Please enter a valid time value for a 12 hour system "<<endl; 
	cout<< "Enter hour value:\t";
		cin>>h;
		cout<<" Enter minute value:\t";
		cin>>m;
		cout<< " Enter second value:\t";
		cin>>s;
	}
		}
	while (h==0||h>12||m>59||s>59);
		}


}