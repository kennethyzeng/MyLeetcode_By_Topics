###########
Time Complexity:
Space Complexity:


#############
def combine(self, n, k):
    ans = []
    stack = []
    x = 1
    while True:
        l = len(stack)
        if l == k:
            ans.append(stack[:])
        if l == k or x > n - k + l + 1:
            if not stack:
                return ans
            x = stack.pop() + 1
        else:
            stack.append(x)
            x += 1

# 26 / 26 test cases passed.
# Status: Accepted
# Runtime: 60 ms
# 98.51%