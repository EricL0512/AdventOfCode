import os
from typing import TextIO

def get_file_data(file_name) -> list[str]:
    here = os.path.dirname(__file__)
    path = os.path.join(here, file_name)

    with open(path) as f:
        return [line.rstrip() for line in f]


def separate(file_data) -> tuple[list[list[int]], list[int]]:
    ranges = []
    ingredients = []

    for line in file_data:
        if "-" in line:
            ranges.append([int(i) for i in line.split("-")])
        elif line.strip():
            ingredients.append(int(line))
    
    
    return ranges, ingredients

def part_one():
    total = 0
    ranges, ingredients = separate(file_data)

    for ingredient in ingredients:
        for start, end in ranges:
            if start <= ingredient <= end:
                total += 1
                break
    
    print(f"part one: {total}")



def part_two():
    ranges, _ = separate(file_data)
    ranges.sort()

    merged = []

    for start, end in ranges:
        # first element or if current end less than next start
        if not merged or start > merged[-1][1]:
            merged.append([start, end])
        else:
            # since ranges are sorted, we only need to pick the larger end value
            merged[-1][1] = max(merged[-1][1], end)
    
    total = sum(end - start + 1 for start, end in merged)

    print(f"part two: {total}")




if __name__ == "__main__":
    file_data = get_file_data("input")
    part_one()
    part_two()
