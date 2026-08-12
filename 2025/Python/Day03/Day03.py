import os
from typing import TextIO

def get_file_data(file_name) -> list[str]:
    here = os.path.dirname(__file__)
    path = os.path.join(here, file_name)

    with open(path) as f:
        return [line.rstrip() for line in f]


def part_one():
    total = 0

    # First, find the largest digit (exluding last digit)
    # Then, find the largest digit behind that first digit
    for line in file_data:
        first_digit = max(line[:-1])
        first_position = line.index(first_digit)
        second_digit = max(line[first_position + 1:])
        total += int(first_digit + second_digit)
    print(f"part one: {total}")




def part_two():
    total = 0

    # pretty much the same as part 1 but with multiple numbers
    for line in file_data:
        curr_num = ""
        position = 0
        curr_digit = ""
        while len(curr_num) < 12:
            curr_digit = max(line[position:len(line) - (11 - len(curr_num))])
            curr_num += curr_digit
            position += line[position:].index(curr_digit) + 1
        total += int(curr_num)

    print(f"part two: {total}")

if __name__ == "__main__":
    file_data = get_file_data("input")
    part_one()
    part_two()
