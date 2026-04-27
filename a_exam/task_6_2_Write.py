from sys import argv

def main():
    file_path="text.txt"
    data=argv[1]
    
    with open (file_path, "a") as file:
        file.write(data)
        print("Wrote " + data + " to file " + file_path + ".")

    return


if __name__ == "__main__":
    main()



    