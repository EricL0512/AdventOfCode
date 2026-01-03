import os
from typing import TextIO

def get_file_data(file_name) -> list[str]:
    here = os.path.dirname(__file__)
    path = os.path.join(here, file_name)

    with open(path) as f:
        return [line.rstrip() for line in f]


def part_one():
    dial = 50
    total = 0
    for line in file_data:
        dial += int(line[1:]) if line[0] == "R" else -int(line[1:])
        if dial % 100 == 0:
            total += 1
    print(f"part one: {total}")


def part_two():
    dial = 50
    total = 0
    for line in file_data:
        total += int(line[1:]) // 100
        remainder = int(line[1:]) % 100 if line[0] == "R" else -(int(line[1:]) % 100)
        dial += remainder
        if dial >= 100 or (dial <= 0 and dial != remainder):
            total += 1
        dial %= 100
    print(f"part two: {total}")





if __name__ == "__main__":
    file_data = get_file_data("input")
    part_one()
    part_two()