#include <iostream>
#include <cmath>

using namespace std;

bool getInput( string type, double length, double width) {
    if ( length <= 0 ) {
        return false;
    }
    if ( width <= 0 ) {
        return false;
    }

    if ( type == "circle" || type == "square" ) {
        if ( length == width ) {
            return true;
        }
    }
    if ( type == "rectangle" ) {
        if ( length != width ) {
            return true;
        }
    }

    return false;
}

bool calcAreaPerimeter( string type, double length, double width) {
    double area = 0;
    double perimeter = 0;

    if ( !getInput( type, length, width) ) {
        return false;
    }

    if ( type == "circle" ) {
        area = length * M_PI * length;
        perimeter = 2.0 * M_PI * length;
    }
    if ( type == "square" || type == "rectangle") {
        area = length * width;
        perimeter = (length + width) * 2.0;
    }

    cout << "The area of the " << type << ":" << area << endl;
    cout << "The perimeter of the " << type << ":" << perimeter << endl;

    if ( type == "circle" || type == "square" || type == "rectangle" ) {
        return true;
    }

    return false;
}

int main()
{
    string type = "";
    int length = 0;
    int width = 0;

    cout << "Welcome to my shape area and perimeter calculation program." << endl;
    cout << "Enter the shape (circle, square or rectangle):";
    cin >> type;

    if ( type == "rectangle" ) {
        cout << "Enter the length of the " << type << ":";
        cin >> length;

        cout << "Enter the width of the " << type << ":";
        cin >> width;

        if ( !calcAreaPerimeter( type, length, width) ) {
            cout << "Invalid input!" << endl;
        }
    }
    if ( type == "square") {
        cout << "Enter the length of the " << type << ":";
        cin >> length;

        if ( !calcAreaPerimeter( type, length, length) ) {
            cout << "Invalid input!" << endl;
        }
    }
    if ( type == "circle" ) {
        cout << "Enter the radius of the " << type << ":";
        cin >> length;

        if ( !calcAreaPerimeter( type, length, length) ) {
            cout << "Invalid input!" << endl;
        }
    }

    return 0;
}
