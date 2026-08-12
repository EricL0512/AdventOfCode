import os
from typing import TextIO

def get_file_data(file_name) -> list[str]:
    here = os.path.dirname(__file__)
    path = os.path.join(here, file_name)

    with open(path) as f:
        return [line.rstrip() for line in f]


def part_one():
    pass


def part_two():
    pass

if __name__ == "__main__":
    file_data = get_file_data("input")
