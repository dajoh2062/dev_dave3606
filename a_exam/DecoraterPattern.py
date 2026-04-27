def logging_decorator(decorated_function):
    def inner():
        print("Calling function")
        decorated_function()
        print("Call is done")
    return inner

@logging_decorator
def do_something():
    print("Hello world!")

do_something()