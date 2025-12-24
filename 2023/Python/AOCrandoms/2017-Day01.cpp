#include <bits/stdc++.h>
using namespace std;

int main() {
	string numbers; cin >> numbers;
	int total;
	for (int i = 0; i < numbers.length() - 1; i++) {
		if (stoi(numbers.substr(i, 1)) == stoi(numbers.substr(i+1, 1))) {
			total += stoi(numbers.substr(i, 1));
		}
	}
	if (numbers.substr(numbers.length() - 1, numbers.length()) == numbers.substr(0, 1)) total += stoi(numbers.substr(0, 1));
	cout << total << endl;

	int halfway = numbers.length() / 2;
	total = 0;
	for (int i = 0; i < numbers.length()/2 - 1; i++) {
		if (stoi(numbers.substr(i, 1)) == stoi(numbers.substr(halfway + i, 1))) {
			total += stoi(numbers.substr(i, 1));
		}
	}
	total *= 2;
	cout << total << endl;
}
