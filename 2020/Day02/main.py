from typing import TextIO


def get_file_data(file_name) -> list[str]:
    f: TextIO = open(file_name)
    data: list[str] = []
    for line in f:
        data.append(line.rstrip())
    return data


def part_one() -> None:
    valid: int = 0
    for i in file_data:
        count: int = 0
        min_amount: int = int(i.split(" ")[0].split("-")[0])
        max_amount: int = int(i.split(" ")[0].split("-")[1])
        target: str = i.split(" ")[1][0]
        word: str = i.split(" ")[-1]
        for s in word:
            if target == s:
                count += 1
        if min_amount <= count <= max_amount:
            valid += 1
    print(f"part one solution {valid}")


def part_two() -> None:
    valid: int = 0
    for i in file_data:
        count: int = 0
        term_one: int = int(i.split(" ")[0].split("-")[0])
        term_two: int = int(i.split(" ")[0].split("-")[1])
        target: str = i.split(" ")[1][0]
        word: str = i.split(" ")[-1]
        if word[term_one-1] == target:
            count += 1
        if word[term_two-1] == target:
            count += 1
        if 0 < count < 2:
            valid += 1
    print(f"part two solution {valid}")


file_data = get_file_data("input")
part_one()
part_two()
