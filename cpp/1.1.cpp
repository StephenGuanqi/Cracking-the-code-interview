//
// Created by Guanqi Yu on 11/21/17.
//

/*
 * Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures?
 */
#include <cstring>
#include <iostream>
#include <vector>

//using std::string;
//using std::vector;
//using std::cin; using std::cout; using std::endl;
using namespace std;


bool isUnique(string s) {
    typedef decltype(s.size()) size_T;
    bool a[256];
    memset(a, 0, sizeof(a));
    size_t len = s.size();
    for(size_t i = 0; i != len; i++) {
        size_t v = (size_t)s[i];
        if (a[v]) return false;
        a[v] = true;
    }
    return true;
}




int main() {
    string s;
//    while(getline(cin, s)) {
//        cout << isUnique(s) << endl;
//    }

}