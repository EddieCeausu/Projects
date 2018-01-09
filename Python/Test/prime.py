import threading, doctest, cProfile, time, random
result = [2]
counter = 1

def get_int(num):
    for i in range(3, num):
        yield i

def is_prime(num):
    for j in range(2,int(num)):
        if (num % j) == 0:
            return False
    result.append(num)
    return True

def prime_calculator(nth):
    lock = threading.Lock()
    global result, counter, integer
    while counter < (nth):
        if is_prime(next(integer)):
            lock.acquire()
            try:
                counter += 1
            finally:
                lock.release()
        time.sleep(random.random()/1000)

def prime(nth):
    global integer, counter, result
    integer = get_int(99999999)
    threads = [threading.Thread(daemon=True, target=prime_calculator, args=(nth,)) for i in range(500)]
    [thread.start() for thread in threads]
    [thread.join() for thread in threads]
    counter = 1
    return result[-1]

if __name__ == "__main__":
    doctest.testmod()
    cProfile.run('print(prime(1234567))')
