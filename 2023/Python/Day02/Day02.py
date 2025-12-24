from typing import TextIO


def get_file_data(file_name) -> list[str]:
    f: TextIO = open(file_name)
    data: list[str] = []
    for line in f:
        data.append(line.rstrip())
    return data


def part_one():
    for line in file_data:
        line = line.split(":")[1][1:]
        terms = line



def part_two():
    pass


file_data = get_file_data("input")
part_one()
