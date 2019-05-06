# @Author: Edmond Ceausu <eddieceausu>
# @Date:   2019-01-10T18:23:32-05:00
# @Email:  eddieswim101@gmail.com
# @Filename: main.py
# @Last modified by:   eddieceausu
# @Last modified time: 2019-04-16T11:28:29-04:00
# @Copyright: © Edmond Ceausu 2018
from selenium import webdriver
import pyautogui as pag
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.firefox.firefox_binary import FirefoxBinary
from selenium.webdriver.common.action_chains import ActionChains
import time
import random
import os

# Pulled from AntiBotMisc in SBOT project
def send(object, mesg, wpm=14000, random_fuzzing=0.1):
    cpm = wpm * 5
    time_per_char = float(60)/float(cpm)
    for char in mesg:
        time.sleep(time_per_char)
        object.send_keys(char)

def login(browser, site):
    browser.get(site)
    #This will find the login box
    element = browser.find_element_by_id("inputEmail3")
    element.click()
    uName = input("Enter UserName: ")
    send(element, uName)
    password = input('Enter your password: ')
    element = browser.find_element_by_id("password")
    element.click()
    send(element, password)
    # login
    browser.find_element_by_xpath('//*[@id="login"]/div[6]/img').click()

def openBook(browser):
    browser.find_element_by_xpath('/html/body/div[1]/div/div/div/div[1]/div/div/div/div/div/div[1]/div/div/div[4]/a/div/div').click()

def getPages(browser, i):
    browser.switch_to_frame(browser.find_element_by_xpath("//*[starts-with(@id,'easyXDM_default')]")) # switches browser to inner iframe -> to epub frame
    browser.switch_to_frame(browser.find_element_by_id("epub-content"))
    src = browser.find_element_by_id("pbk-page").get_attribute("src")
    savePage(browser, src, i)

def savePage(browser, image, i):
    browser.execute_script('window.open("{}","_blank");'.format(image))
    time.sleep(0.5)
    pag.hotkey('command', 's')
    time.sleep(0.2)
    pag.typewrite('{}'.format(i))
    time.sleep(0.5)
    pag.hotkey('Enter')
    pag.hotkey('command', 'w')
    pag.moveTo(1255, 428, 1)
    pag.moveTo(1253, 446, 0.5)
    pag.click()
    browser.switch_to_default_content()
    #browser.get('{}'.format(image))
def main():
    browser = webdriver.Firefox()
    login(browser, "https://sso.bncollege.com/bes-idp/ssologin?pub=WVVaVQ==")
    time.sleep(5)
    openBook(browser)
    time.sleep(10)
    for i in range(567, 592):
        getPages(browser, i)
        time.sleep(2)
    #time.sleep(10)
    browser.close()

if __name__ == '__main__':
    main()
