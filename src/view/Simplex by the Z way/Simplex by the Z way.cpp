#include <bits/stdc++.h>
using namespace std ;

// Variables
int numOfBasicVar , numOfConstrains ;
double myConstrains [ 10 ][ 10 ] ;
double myObjectiveFunctions [ 10 ] ;
int nSlaks = 0 , nBasicVarAfterAddSlaks = 0 ;
double RHS_Con [ 10 ] [ 1 ] ;
double RHS_ObjFunc = 0 ;
double ratio [ 10 ][ 1 ] ;
double myTable [ 11 ] [ 11 ] ;
int basicVarInTable [ 10 ][ 1 ] ;
int in , out ;
int numOfRowsInTable , numOfColInTable ;

string printWithPlusOrMinus ( double n ){
    if ( n >= 0 )
        cout << " +" << n ;
    else
        cout << " " << n ;
    return "" ;
}
void reversAllSigns(){
    for ( int i = 0 ; i < numOfBasicVar ; ++i )
        myObjectiveFunctions [ i ] = -myObjectiveFunctions [ i ] ;
}

void addSlacksVariables (){
    nBasicVarAfterAddSlaks = numOfConstrains + numOfBasicVar ;
    nSlaks = numOfConstrains ;
    //add slacks Variable
    for ( int i = numOfBasicVar ; i < nBasicVarAfterAddSlaks ; ++i ){
        myObjectiveFunctions [ i ] = 0 ;
    }

    //add slacks for the constrains
    for ( int i = 0 , m = numOfBasicVar ; i < numOfConstrains ; ++i , ++m ){
        myConstrains [ i ][ m ] = 1 ;
    }

}

void inputMyData () {
    cout << "Enter number of Basic Variable : " ;
    cin >> numOfBasicVar ;
    while(cin.fail()|| numOfBasicVar < 1 ){
        cout << endl <<"*********************************** ERROR **************************************"<<endl<<endl;
        cin.clear();
        cin.ignore(1000,'\n');
        cout << "Renter number of Basic Variable : " ;
        cin >> numOfBasicVar ;
    }
    cout << "Enter The Objective Functions : " << endl ;
    for ( int i = 0 ; i < numOfBasicVar ; ++i ){
        cout << "X" << i + 1 << "= " ;
        cin >> myObjectiveFunctions [ i ] ;
        while(cin.fail()){
        cout << endl <<"*********************************** ERROR **************************************"<<endl<<endl;
        cin.clear();
        cin.ignore(1000,'\n');
        cout << "Renter X" << i + 1 << "= " ;
        cin >> myObjectiveFunctions [ i ] ;
    }
    }
    cout << "Enter number of constrains : " ;
    cin >> numOfConstrains ;
    for ( int i = 0 ; i < numOfConstrains ; ++i ){
        cout << "Enter Constrain " << i + 1 << endl ;
        for ( int j = 0 ; j < numOfBasicVar ; ++j ){
            cout << "X" << j + 1 << "= " ;
            cin >> myConstrains [ i ] [ j ] ;
            while(cin.fail()){
            cout << endl <<"*********************************** ERROR **************************************"<<endl<<endl;
            cin.clear();
            cin.ignore(1000,'\n');
            cout << "Renter X" << j + 1 << "= " ;
            cin >> myConstrains [ i ] [ j ] ;
    }
        }
        cout << "RHS for the Constrains is ? most be <= : " ;
        cin >> RHS_Con [ i ] [ 1 ] ;
        while(cin.fail()){
            cout << endl <<"*********************************** ERROR **************************************"<<endl<<endl;
            cin.clear();
            cin.ignore(1000,'\n');
            cout << "RHS for the Constrains is ? most be <= : " ;
            cin >> RHS_Con [ i ] [ 1 ] ;
    }
    }
}

void outputMyData(){
    cout << "-------------------------------------------------\n" ;
    //show the objective Function
    cout << "Z = " ;
    for ( int i = 0 ; i < numOfBasicVar ; ++i )
        if ( !i )
            cout << myObjectiveFunctions [ i ] << "X" << i + 1 ;
        else
            cout << printWithPlusOrMinus ( myObjectiveFunctions [ i ] ) << "X" << i + 1 ;
    for ( int i = numOfBasicVar , n = 1 ; i < nBasicVarAfterAddSlaks ; ++i , ++n )
        if ( !i )
            cout << myObjectiveFunctions [ i ] << "S" << n << " " ;
        else
            cout << printWithPlusOrMinus ( myObjectiveFunctions [ i ] ) << "S" << n ;
    cout << endl ;
    cout << "-------------------------------------------------\n" ;
    cout << "-------------------------------------------------\n" ;
    // the Constrains is
    cout << "S.T: " << endl;
    for ( int i = 0 ; i < numOfConstrains ; ++i ){
        for ( int j = 0 ; j < numOfBasicVar ; ++j )
            if ( !j )
                cout << myConstrains [ i ] [ j ] << "X" << j + 1 ;
            else
                cout << printWithPlusOrMinus ( myConstrains [ i ] [ j ] ) << "X" << j + 1 ;
        int n = 1 ;
        for ( int j = numOfBasicVar ; j < nBasicVarAfterAddSlaks ; ++j )
            cout << printWithPlusOrMinus ( myConstrains [ i ] [ j ] ) << "S" << n++  ;
        cout << " = " << RHS_Con [ i ] [ 1 ] << endl;
    }
    cout << endl ;
    cout << "-------------------------------------------------\n" ;
}

void makeMyTable(){
    numOfColInTable = numOfBasicVar + nSlaks + 2 ;
    numOfRowsInTable = numOfConstrains + 1 ;
    int i = 0 , j = 0 ;
    myTable [ i ] [ j++ ] = 1 ;
    // ADD THE OBJECTIVE FUNCTIONS TO THE TABLE ;
    for ( int k = 0 ; j < numOfColInTable ; ++j )
        myTable [ i ] [ j ] = myObjectiveFunctions [ k++ ] ;
    ++i ;
    // ADD THE CONSTRAINS TO THE TABLE
    int ii = 0 , jj = 0 ;
    for ( ; i < numOfRowsInTable ; ++i , ++ii )
        for ( j = 1 , jj = 0 ; j < numOfColInTable - 1 ; ++j , ++jj )
            myTable [ i ][ j ] = myConstrains [ ii ] [ jj ] ;
    for ( i = 1 ; i < numOfRowsInTable ; ++i )
        myTable [ i ] [ j ] = RHS_Con [ i - 1 ] [ 1 ] ;
    // BASIC VARS IN THE TABLE
    for ( i = 1 ; i <= numOfConstrains ; ++i )
        basicVarInTable [ i ] [ 1 ] = numOfBasicVar + i ;
}

void outputMyTable (){
    cout << "-------------------------------------------------\n" ;
    for ( int i = 0 ; i < numOfRowsInTable ; ++i ){
        if ( !i )
            cout << "Z    " ;
        else
            cout << "X" << basicVarInTable [ i ][ 1 ] << "   " ;
        for ( int j = 0 ; j < numOfColInTable ; ++j )
            cout << setw( 10 ) << myTable [ i ] [ j ] ;
        cout << endl ;
    }
    cout << "-------------------------------------------------\n" ;
}

bool checkForTheEnd(){
    for ( int j = 0 ; j < numOfColInTable ; ++j )
        if ( myTable [ 0 ] [ j ] < 0 )
            return false ;
    return true ;
}
double theResultForTheCell ( int pi , int pj , int ci , int cj ){
    return ( myTable [ pi ] [ pj ] * myTable [ ci ] [ cj ] ) - ( myTable [ ci ] [ pj ] * myTable [ pi ] [ cj ] ) ;
}

void solve (){
    outputMyTable() ;
    while ( true ){
        // THE END POINT
        if( checkForTheEnd() )
            break ;

        // KNOW THE PIVOT COLOMN
        double mini = INT_MAX ;
        int pj ;
        for ( int j = 1 ; j < numOfColInTable ; ++j ){
            if ( myTable[ 0 ] [ j ] < 0 && myTable [ 0 ] [ j ] < mini ){
                mini = myTable[ 0 ] [ j ] ;
                pj = j ;
            }
        }

        // KNOW HOW IS IN
        in = pj ;

        // CALCLUTE THE RATIO
        for ( int i = 1 ; i < numOfRowsInTable ; ++i ){
            if ( myTable [ i ] [ pj ] != 0 && myTable [ i ] [ numOfColInTable - 1 ] != 0 )
                ratio [ i ] [ 1 ] = myTable [ i ] [ numOfColInTable - 1 ] / myTable [ i ] [ pj ] ;
            else
                ratio [ i ] [ 1 ] = 0 ;
        }

        // CALCLUTE THE PIVOT ROW
        mini = INT_MAX ;
        int pi ;
        for ( int i = 1 ; i < numOfRowsInTable ; ++i ){
            if ( ratio [ i ] [ 1 ] > 0 && ratio [ i ] [ 1 ] < mini ){
                mini = ratio [ i ] [ 1 ] ;
                pi = i ;
            }
        }
        // KNOW HOW IS OUT
        out = pi ;
        // KNOW THE BASIC VAR IN THE TABLE
        basicVarInTable [ out ] [ 1 ] = in  ;

        // KOW THE PIVOT ELEMENT
        double pivotEle = myTable [ pi ][ pj ] ;

        for ( int ci = 0 ; ci < numOfRowsInTable ; ++ci ){
            if ( ci == pi )
                continue ;
            for ( int cj = 1 ; cj < numOfColInTable ; ++cj ){
                if ( cj == pj )
                    continue ;

                myTable [ ci ] [ cj ] =  ( ( myTable [ pi ] [ pj ]
                                            * myTable [ ci ] [ cj ] )
                                            - ( myTable [ ci ] [ pj ]
                                            * myTable [ pi ] [ cj ] ) ) ;
                myTable [ ci ] [ cj ] /= pivotEle ;
            }
        }
        // DIV ELEMENTS OF THE ROW ON THE PIVOT ELEMENT
        for ( int j = 1 ; j < numOfColInTable ; ++j )
            myTable [ pi ] [ j ] = myTable [ pi ] [ j ] / pivotEle ;

        // make it union
        for ( int i = 0 ; i < numOfRowsInTable ; ++i ){
            if ( i == pi )
                myTable [ i ] [ pj ] = 1 ;
            else
                myTable [ i ] [ pj ] = 0 ;
        }
        outputMyTable() ;
    }
}
int main (){
        system("color 8f");
    cout <<"--------------------------------------------------------------------------------";
    cout <<"********************************************************************************"<<endl;
    cout <<"\t\t\t  Simplex Problem Solver \t\t\t\t\n";
    cout <<"********************************************************************************";
    cout<<"--------------------------------------------------------------------------------"<<endl;
	bool flag ;
	cout << "Enter 1 for MAXMIZTION problem or 0 for MINMIZATION problem : " ;
	cin >> flag ;
	while(cin.fail()|| flag < 0 || flag > 1 ){
        cout << endl <<"*********************************** ERROR **************************************"<<endl<<endl;
        cin.clear();
        cin.ignore(1000,'\n');
        cout << "Renter 1 for MAXMIZTION problem or 0 for MINMIZATION problem : " ;
        cin >> flag ;
    }
	if ( flag ){
        inputMyData () ;
        addSlacksVariables () ;
        reversAllSigns() ;
        makeMyTable() ;
        reversAllSigns() ;
        outputMyData() ;
        solve() ;
        cout << "MAX Z = " << myTable [ 0 ] [ numOfColInTable - 1 ] ;
	}else{
        inputMyData () ;
        addSlacksVariables () ;
        makeMyTable() ;
        outputMyData() ;
        solve() ;
        cout << "MIN Z = " << myTable [ 0 ] [ numOfColInTable - 1 ] ;
	}
	cout << endl ;
	system( "pause" ) ;

	return 0;
}
