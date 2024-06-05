
# use recursion to implement a countdown counter


def countdown(x):
    if x == 0:
        print("Done!")
        return
    else:
        print(x, "...")
    print("hlloe")
    countdown(x-1)
    print("foo")

countdown(5)


"""
5 ...
hlloe
4 ...
hlloe
3 ...
hlloe
2 ...
hlloe
1 ...
hlloe
Done!
foo
foo
foo
foo
foo
"""