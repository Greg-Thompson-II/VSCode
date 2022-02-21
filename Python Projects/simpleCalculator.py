'''
Created on Jan 21, 2022

@author: gregt
'''
while True:

    print("1 Addition")
    print("2 Subtracton")
    print("3 Multiplication")
    print("4 Division")
    print("Enter q or Q to Quit")

    print()

    choice = input("Enter your choice: ")
    
    if choice == "q" or choice == "Q":
        print("Calculator Program Terminated")
        break;

    num1 = float(input("Enter Number 1 : "))
    num2 = float(input("Enter Number 2 : "))
    print()

    if choice == "1":
        print(num1, "+", num2, "=", (num1+num2))
    elif choice == "2":
        print(num1, "-", num2, "=", (num1-num2))
    elif choice == "3":
        print(num1, "*", num2, "=", (num1*num2))    
    elif choice == "4":
        if num2 == 0.0:
            print("You cannot divide by zero")
        else:
            print(num1, "/", num2, "=", (num1/num2))
    else:
        print("Invalid Choice")
        
    print()