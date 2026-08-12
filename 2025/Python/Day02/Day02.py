import os
from tracemalloc import start
from typing import TextIO

def get_file_data(file_name) -> list[str]:
    here = os.path.dirname(__file__)
    path = os.path.join(here, file_name)

    with open(path) as f:
        return [line.rstrip() for line in f]


def part_one():
    total = 0
    input_ranges = [line.split("-") for line in file_data[0].split(",")]
    
    for start, end in input_ranges:
        # start, end are strings
        while int(end) >= int(start):
            # first check if even number of digits, then check if first half is equal to second half
            if len(start) % 2 == 0 and start[:len(start)//2] == start[len(start)//2:]:
                total += int(start)
            start = str(int(start) + 1)

    print(f"part 1: {total}")
    


def part_two():
    total = 0
    input_ranges = [line.split("-") for line in file_data[0].split(",")]

    for start, end in input_ranges:
        while int(end) >= int(start):
            # brute force: check all possible substrings and see if they loop
            for substr_length in range(1, len(start)//2 + 1):

                # substr_length must divide start for it to be valid
                if len(start) % substr_length != 0:
                    continue

                candidate = set([start[i:i+substr_length] for i in range(0, len(start), substr_length)])
                if len(candidate) == 1:
                    total += int(start)
                    break

            start = str(int(start) + 1)

    print(f"part two: {total}")

        


if __name__ == "__main__":
    file_data = get_file_data("input")
    part_one()
    part_two()