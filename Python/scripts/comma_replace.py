def main():
    print("Convert your csv to a list.\n")
    ostr = str(input("Enter your String: "))

    print(ostr.replace(", ", "\n").replace("and ", ""))

if __name__ == '__main__':
    main()
