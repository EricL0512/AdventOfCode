#include <vector>
#include <iostream>
#include <fstream>
#include <sstream>
#include <algorithm>
#include <filesystem>

using namespace std;

// prototype
void part_one(ifstream& file);
void part_two(ifstream& file);

int main() {
    std::filesystem::path here = std::filesystem::path(__FILE__).parent_path();
    std::ifstream file(here / "input");

    if (!file.is_open()) {
        std::cerr << "Unable to open file\n";
        return 1;
    }

    part_one(file);

    // reset file stream to beginning
    file.clear();
    file.seekg(0, ios::beg);

    part_two(file);
}

void part_one(ifstream& file) {
    // Implementation for part one
    string line;
    int total = 0, dial = 50;
    
    while (file >> line) {
        // process each line
        if (line[0] == 'R') {
            dial += stoi(line.substr(1));
        } else {
            dial -= stoi(line.substr(1));
        }
        if (dial % 100 == 0) {
            total++;
        }
    }
    cout << "part one: " << total << endl;
}

void part_two(ifstream& file) {
    // Implementation for part two
    // this solution works, but has a runtime of O(lt) where l is number of lines and t is the average number of turns made per line
    // for a more optimal solution, look at the python solution which has O(l) runtime
    // this solution is just for fun and practice with C++
    string line;
    int total = 0, dial = 50;
    while (file >> line) {
        int a = (line[0] == 'R') ? 1 : -1;
        for (int i = 0; i < stoi(line.substr(1)); ++i) {
            dial += a;
            if (dial % 100 == 0) {
                total++;
            }
        }
    }
    cout << "part two: " << total << endl;
}