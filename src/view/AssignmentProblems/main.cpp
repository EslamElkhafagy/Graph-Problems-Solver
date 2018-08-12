#include <bits/stdc++.h>
using namespace std;

int numOfJobs ;
double arr [ 9 ] [ 9 ] ;
int b [ 9 ] ;
double sum = 0 ;
bool f;
vector < string > a , myOptions ;


void input()
{

    cout << "Enter the number of jobs : " ;
    cin >> numOfJobs ;
    while(cin.fail()){
        cout << endl <<"*********************************** ERROR **************************************"<<endl<<endl;
        cin.clear();
        cin.ignore(1000,'\n');
        cout << "Renter the number of jobs : " ;
        cin >> numOfJobs ;
    }
    cout << "Available Options : "<<endl;
    cout << "\tPress >> 1 >> For Min"<<endl;
    cout << "\tPress >> 0 >> For MAx"<<endl;
    cout << "Your Choice : " ;
    cin>>f;
    while(cin.fail() || f < 0 || f > 1){
        cout << endl <<"*********************************** ERROR **************************************"<<endl<<endl;
        cin.clear();
        cin.ignore(1000,'\n');
        cout << "Renter Your Choice : " ;
        cin >> f ;
    }
    cout << endl ;
    cout << "\t\t\t\t\t\t     ";
    for(int i = 1 ; i <= numOfJobs ; ++i)
    {
        cout << "X" << i<<" " ;
    }
    cout <<endl ;
    for ( int i = 0 ; i < numOfJobs ; ++i )
    {
        b [ i ] = i ;
        cout << "Enter Row" << i+1 << " (Continuously With Spreading Spaces) : b"<<i+1<<" " ;
        for ( int j = 0 ; j < numOfJobs ; ++j ){
            cin >> arr [ i ] [ j ] ;
            while(cin.fail() || !(arr [ i ] [ j ] >= 0)){
            cin.clear();
            cin.ignore(1000,'\n');
            cout << "Renter Row" << i+1 << " (************* ERROR *************) : b"<<i+1<<" " ;
            cin >> arr [ i ] [ j ] ;
            }
        }

        }

}

void genMyOptions ()
{
    int idx = 0 ;
    string curr = "" ;
    a.push_back( curr ) ;
    while( a[ idx ].size() < numOfJobs + 1 )
    {
        curr = a [ idx ++ ] ;
        if ( curr.size() == numOfJobs )
        {
            bool flag = 1 ;
            for ( int i = 0 ; i < numOfJobs ; ++i )
                for ( int j = i + 1 ; j < numOfJobs ; ++j )
                    if ( curr [ i ] == curr [ j ] )
                        flag = 0 ;
            if ( flag )
                myOptions.push_back( curr ) ;
        }
        for ( int i = 0 ; i < numOfJobs ; ++i )
        {
            char temp = i + '0' ;
            a.push_back( curr + temp ) ;
        }
    }
}

int main()
{
    system("color 8f");
    cout <<"--------------------------------------------------------------------------------";
    cout <<"********************************************************************************"<<endl;
    cout <<"\t\t\t  Assignment Problem Solver \t\t\t\t\n";
    cout <<"********************************************************************************";
    cout<<"--------------------------------------------------------------------------------"<<endl;
    string  min_x [ 9 ] ;
    input() ;
    genMyOptions () ;

    for ( int i = 0 ; i < myOptions.size() ; ++i )
    {
        for ( int j = 0 ; j < numOfJobs ; ++j )
            b[j] = myOptions[i][j] - '0' ;
        double sum2=0;
        for( int i = 0 ; i < numOfJobs ; ++i )
            sum2 += arr [ i ] [ b [ i ] ] ;

        if(f&&( sum == 0 || sum > sum2 ))
        {
            for( int i = 0 ; i < numOfJobs ; ++i )
            {
                min_x [ i ] = "X" ;
                min_x [ i ] += i + '0' + 1 ;
                min_x [ i ] += b [ i ] + '0' + 1 ;
            }
            sum = sum2 ;
        }
        else if(!f&&(sum==0||sum < sum2 ))
        {
            for( int i = 0 ; i < numOfJobs ; ++i )
            {
                min_x [ i ] = "X" ;
                min_x [ i ] += i + '0' + 1 ;
                min_x [ i ] += b [ i ] + '0' + 1 ;
            }
            sum = sum2 ;
        }
    }



    cout << "\nthe machine allocation \n" ;
    for( int i = 0 ; i < numOfJobs ; ++i )
        cout << min_x [ i ] << " " ;
    if(f)
        cout << "\n the assignment minimum cost " << sum << endl ;

    else  cout<<"\n the assignment max cost " << sum << endl ;
    system("pause");
    return 0;
}
