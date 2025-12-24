from typing import TextIO


def get_file_data(file_name) -> list[str]:
    f: TextIO = open(file_name)
    data: list[str] = []
    for line in f:
        data.append(line.rstrip())
    return data


def part_one():
    first = ""
    second = ""
    result = 0
    for line in file_data:
        for letter in line:
            if letter.isdigit():
                first = letter
                break

        for letter in reversed(line):
            if letter.isdigit():
                second = letter
                break
        result += int(first + second)
    print(f"part one: {result}")


def part_two():
    word_to_number = {
        "one": "1",
        "two": "2",
        "three": "3",
        "four": "4",
        "five": "5",
        "six": "6",
        "seven": "7",
        "eight": "8",
        "nine": "9"
    }
    result = 0
    first = ""
    second = ""
    finished = False
    #  Code is in two parts. First part finds the first number, second part finds the second number
    for line in file_data:
        curr_line = line
        for start in range(len(curr_line)):
            if finished:
                finished = False
                break
            for end in range(len(curr_line)):  # This is not safe at all
                if curr_line[start:end] in word_to_number:
                    curr_line = curr_line.replace(curr_line[start:end], word_to_number[curr_line[start:end]], 1)
                    finished = True
                    break

        for letter in curr_line:
            if letter.isdigit():
                first = letter
                break

        #  Found first letter, now reset and find second letter
        curr_line = line

        for end in range(len(curr_line), 0, -1):
            if finished:
                finished = False
                break
            for start in range(len(curr_line), 0, -1):
                if curr_line[start:end] in word_to_number:
                    curr_line = curr_line.replace(curr_line[start:end], word_to_number[curr_line[start:end]])
                    finished = True
                    break
        for letter in reversed(curr_line):
            if letter.isdigit():
                second = letter
                break
        result += int(first + second)
    print(f"part two: {result}")


file_data = get_file_data("input")
part_one()
part_two()
