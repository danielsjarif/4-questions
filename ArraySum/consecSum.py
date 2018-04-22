def consecSum(lst, n):
    sum = 0
    sum_list = []
    for i in range(len(lst)-1):
        sum = lst[i] + lst[i + 1]
        sum_list.append(sum)

    print ('The possible values are:', sum_list,
    'and the maximum value is:', max(sum_list))

#Array input
arr = [10, -2, 5, 6, -5]
size = len(arr)
consecSum(arr, size)
