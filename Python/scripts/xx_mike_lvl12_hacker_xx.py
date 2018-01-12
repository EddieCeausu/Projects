import string, random, time, os, threading


def id_generator(size = random.randint(random.randint(1,500),random.randint(1,500)),chars=string.ascii_uppercase + string.digits):
    return ''.join(random.choice(chars) for _ in range(size))

def main():
    while(True):
        lol = id_generator( (len(id_generator())) - random.randint(1, len(id_generator()) + 15), id_generator())
        print(lol)
        time.sleep(random.uniform(0, 0.1))


if __name__ == '__main__':
    main()
