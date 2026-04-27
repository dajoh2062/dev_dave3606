

def main():
    file_path="text.txt"
    output_data=""

    with open(file_path, "r") as file:
        output_data=file.read()
    
    print(output_data)
    
    return


if __name__ == "__main__":
    main()

    