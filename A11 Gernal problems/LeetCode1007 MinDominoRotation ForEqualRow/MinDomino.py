def min_domino_rotations(A: List[int], B: List[int]) -> int:
    """
    Minimum Domino Rotations For Equal Row

    time: O(n)
    space: O(1)

    :param List[int] A:
    :param List[int] B:
    :return int:
    """
    a = A[0]
    b = B[0]

    N = len(A)
    min_rot = -1

    for n in {a, b}:
        rot_a = rot_b = 0

        for i in range(N):
            if A[i] != n and B[i] != n:
                break
            if A[i] != n:
                rot_a += 1
            if B[i] != n:
                rot_b += 1

        else:  # no break
            min_rot = min(rot_a, rot_b)

    return min_rot