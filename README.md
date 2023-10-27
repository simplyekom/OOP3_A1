# OOP3_A1
# Sorting Geometric Shapes Program

## Installation

1. Ensure you have Java Runtime Environment (JRE) installed on your system.

2. Download the `sort.jar` file, which contains the sorting program.

## Usage

To run the sorting program, open your command prompt (or terminal) and use the following command format:

java -jar sort.jar -f [file_name] -t [compare_type] -s [sorting_algorithm]


### Command Line Arguments

- `-f` or `-F`: Followed by the file name (and path) that contains random geometric shapes. For example, `-f polyfor1.txt` or `-F "C:\temp\polyfor5.txt"`.

- `-t` or `-T`: Followed by the compare type:
  - `v` for volume
  - `h` for height
  - `a` for base area

- `-s` or `-S`: Followed by the sorting algorithm:
  - `b` for Bubble Sort
  - `s` for Selection Sort
  - `i` for Insertion Sort
  - `m` for Merge Sort
  - `q` for Quick Sort
  - `z` for a custom sorting algorithm

You can use both uppercase and lowercase letters for the command line arguments. The program is not case-sensitive.

### Example Usage

- To sort a file named `polyfor1.txt` by volume using Quick Sort:

java -jar sort.jar -f polyfor1.txt -t v -s q


- To sort a file named `polyfor5.txt` by base area using Bubble Sort:

java -jar sort.jar -F "C:\temp\polyfor5.txt" -t a -s b


- To sort a file named `polyfor3.txt` by height using your custom sorting algorithm:

java -jar sort.jar -t h -s z -f polyfor3.txt


### Output

The program will display the sorted geometric shapes from the file, along with the time taken to perform the sorting operation. You'll see the first sorted value, last sorted value, and every thousandth value in between.

### Error Handling

If you enter incorrect command line arguments, the program will display a helpful error message to guide you in correcting the input.
