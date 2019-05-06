from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time, sys, random, os


def main():
    browser = webdriver.Chrome("{}/chromedriver".format(os.path.dirname(os.path.abspath(__file__))))
    browser.get("file:///Users/eddieceausu/Desktop/Excess/QuizTesting/Lesson%2010%20%20%20Command-Line%20Tools%20-uCertify.html")
    print(browser.find_element_by_xpath("/html/body/div[6]/footer/div/div/div[2]/form/div[2]/div").get_attribute('data-original-title')=='100% Completed')

if __name__ == '__main__':
    main()
