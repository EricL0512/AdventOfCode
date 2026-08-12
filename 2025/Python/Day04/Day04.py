import os
from typing import TextIO

def get_file_data(file_name) -> list[str]:
    here = os.path.dirname(__file__)
    path = os.path.join(here, file_name)

    with open(path) as f:
        return [line.rstrip() for line in f]


def part_one():

    total = 0
    # every year has a similar question
    for r, row in enumerate(file_data):
        for c, column in enumerate(row):
            if column == ".":
                continue

            count = 0

            for dr in [-1, 0, 1]:
                for dc in [-1, 0, 1]:
                    if dr == 0 and dc == 0:
                        continue

                    new_row = r + dr
                    new_column = c + dc

                    if not (0 <= new_row < len(file_data) and 0 <= new_column < len(row)):
                        continue
                    if file_data[new_row][new_column] == "@":
                        count += 1
                    if count >= 4:
                        break

            if count < 4:
                total += 1

    print(f"part one: {total}")



def part_two():
    # same as part 1 but with an additional while loop
    total = 0
    finished = False
    curr_grid = file_data.copy()

    while not finished:
        prev_total = total
        new_grid = curr_grid.copy()

        for r, row in enumerate(curr_grid):
            for c, column in enumerate(row):
                if column == ".":
                    continue

                count = 0

                for dr in [-1, 0, 1]:
                    for dc in [-1, 0, 1]:
                        if dr == 0 and dc == 0:
                            continue

                        new_row = r + dr
                        new_column = c + dc

                        if not (0 <= new_row < len(curr_grid) and 0 <= new_column < len(row)):
                            continue
                        if curr_grid[new_row][new_column] == "@":
                            count += 1
                        if count >= 4:
                            break

                if count < 4:
                    total += 1
                    # I probably should've turned the string into a list but this works too
                    new_grid[r] = new_grid[r][:c] + "." + new_grid[r][c + 1:]

        curr_grid = new_grid
        
        if total == prev_total:
            finished = True
    
    print(f"part two: {total}")


if __name__ == "__main__":
    file_data = get_file_data("input")
    part_one()
    part_two()