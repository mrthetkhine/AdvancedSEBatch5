def log(func):
    def wrapper():
        print("Something is happening before the function is called.")
        func()
        print("Something is happening after the function is called.")
    return wrapper

@log
def say_whee():
    print("Whee!")

@log
def hello():
    print("Hi")

say_whee()
hello()