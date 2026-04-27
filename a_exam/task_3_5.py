def main():
    list_a = [9, 4, 7, 1, 7, 3, 4]
    list_b = [2, 3, 1, 7, 3, 9, 8, 7, 6]

    hashset_result = intersection_using_hashset(list_a, list_b)
    mergesort_result = intersection_using_mergesort(list_a, list_b)

    print("Intersection using hashset:", hashset_result)
    print("Intersection using mergesort:", mergesort_result)

    return


# O(n + m) average
def intersection_using_hashset(list_a, list_b):
    a = set(list_a)
    result = set()

    for v in list_b:
        if v in a:
            result.add(v)

    return result


# O(n log n + m log m)
def intersection_using_mergesort(list_a, list_b):
    sorted_a = merge_sort(list_a)
    sorted_b = merge_sort(list_b)

    i = 0
    j = 0
    result = set()

    while i < len(sorted_a) and j < len(sorted_b):
        if sorted_a[i] == sorted_b[j]:
            result.add(sorted_a[i])
            i += 1
            j += 1
        elif sorted_a[i] < sorted_b[j]:
            i += 1
        else:
            j += 1

    return result


def merge_sort(lst):
    if len(lst) <= 1:
        return lst

    mid = len(lst) // 2

    left = lst[:mid]
    right = lst[mid:]

    left = merge_sort(left)
    right = merge_sort(right)

    return merge(left, right)


def merge(left, right):
    result = []
    i = 0
    j = 0

    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1

    while i < len(left):
        result.append(left[i])
        i += 1

    while j < len(right):
        result.append(right[j])
        j += 1

    return result


if __name__ == "__main__":
    main()