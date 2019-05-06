# @Author: Edmond Ceausu <eddieceausu>
# @Date:   2019-04-13T12:25:37-04:00
# @Email:  eddieswim101@gmail.com
# @Filename: quiz.py
# @Last modified by:   eddieceausu
# @Last modified time: 2019-04-23T00:54:55-04:00
# @Copyright: © Edmond Ceausu 2018
# *****************************************************************************
#   Imports
# *****************************************************************************

from selenium import webdriver
import pyautogui as pag
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
import selenium.common.exceptions as Exceptions
from selenium.webdriver.common.keys import Keys
import time, sys, random, os

# *****************************************************************************
#   Imported Functions / Variables
# *****************************************************************************

browser = webdriver.Chrome("{}/chromedriver".format(os.path.dirname(os.path.abspath(__file__))))
def send(object, mesg, wpm=500, random_fuzzing=0.1):
    cpm = wpm * 5
    time_per_char = float(60)/float(cpm)
    for char in mesg:
        time.sleep(time_per_char)
        object.send_keys(char)
def findID(iD, wait=20, brow=browser):
    try:
        l = WebDriverWait(brow, wait).until(EC.visibility_of_element_located((By.ID, iD)))
        return l
    except Exceptions.TimeoutException as e:
        print("Timed Out after 20 seconds\n", e)
        sys.exit()
def findXpath(xpath, wait=20, brow=browser):
    try:
        l = WebDriverWait(brow, wait).until(EC.visibility_of_element_located((By.XPATH, xpath)))
        return l
    except Exceptions.TimeoutException as e:
        print("Timed out after 20 seconds\n", e)
        sys.exit()
def terminateCurrentSession(browser):
    end = findXpath("//*[@id='terminate_test_pre']")
    end.click()
    yes = findXpath("//*[@id='confirm_test_session']/div/div/div[3]/button[1]")
    yes.click()
def parseAnswer(ans):
  ans = ans[:0] + ans[1:] #removes first char since we don't need it
  ans = "".join(x for x in ans if not x.islower()) # removes all lowercase chars
  return ans.translate({32: "", 44: "", 46: ""}) # removes SPACE, ",", and "."

# *****************************************************************************
#   Main Functions
# *****************************************************************************

def login(site, browser=browser):
    browser.get(site)
    el = findXpath("/html/body/div[4]/div/header/div[2]/nav/div/div[2]/ul[2]/li[2]/a")
    el.click()
    el = findID("email")
    el.click();
    uName = input("Enter UserName: ")
    send(el, uName, 1400)
    el = browser.find_element_by_id("password")
    el.click()
    password = input('Enter your password: ')
    send(el, password, 1400)
    #submit query
    browser.find_element_by_id("submit").click()
def openLibraryandChapter(chapter, browser=browser):
    book = findXpath("/html/body/div[5]/div/div/div/div[2]/div[2]/a")
    book.click()
    time.sleep(3)
    #goto networking
    print("Going to Networking Book")
    browser.get("https://www.ucertify.com/?func=load_course&course=pearson-N10-007-complete&class_code=04M1A")
    #go to chapter+1
    time.sleep(1)
    print("going to chapter {}".format(chapter))
    goToChapter(chapter+1)
    time.sleep(3)
def quiz(browser=browser):
    if(findXpath("//*[@id='frmchapter']/div[3]/div").get_attribute('data-original-title') == '100% Completed'):
        print("Quiz is 100% completed skipping to cards")
        return
    browser.find_element_by_xpath("//*[@id='frmchapter']/div[3]/div/span").click()
    time.sleep(3)
    # grab total questions
    browser.switch_to_frame(browser.find_element_by_id("test_frame"))
    questionsTotal = int(browser.find_element_by_xpath("//*[@id='total_items_button']").get_attribute('innerHTML')[0:2])
    print("TotalQuestions: {}".format(questionsTotal))
    # Once in quiz do learn mode
    try:
        browser.find_element_by_id("learn_mode").click()
    except Exceptions.ElementNotVisibleException:
        print("Terminating Current Quiz Session")
        el = findXpath("//*[@id='terminate_test_pre']")
        el.click()
        time.sleep(2)
        el = findXpath("/html/body/div[5]/div/div/section/div[2]/div/div/div[3]/button[1]")
        el.click()
        time.sleep(5)
        findID('learn_mode').click()
        WebDriverWait(browser, 10).until(EC.frame_to_be_available_and_switch_to_it((By.ID, "test_frame")))
    for currentQuestion in range(questionsTotal):
        time.sleep(1)
        browser.switch_to_default_content()
        completeQuestion()
        #go to next question
        findXpath("//*[@id='next']").click()
    # Once quiz is complete
    time.sleep(2)
    browser.switch_to_default_content()
    browser.switch_to_frame(findID("test_frame"))
    findXpath("//*[@id='btn-confirmed']").click()
    time.sleep(5)
    # Click back to book
    browser.switch_to_default_content()
    WebDriverWait(browser, 10).until(EC.frame_to_be_available_and_switch_to_it((By.ID, 'test_frame')))
    findXpath("//*[@id='bottombar']/div/div[2]/div/div/button/small").click()
def completeQuestion(browser=browser):
    WebDriverWait(browser, 10).until(EC.frame_to_be_available_and_switch_to_it((By.ID, "test_frame")))
    el = browser.find_element_by_tag_name("body")
    el.send_keys(Keys.SPACE) # see answer
    time.sleep(1.5)
    answer = browser.find_element_by_class_name("explanation_content").get_attribute("innerHTML").split("<br>", 1)[0]
    print("Before parsing:",answer)
    answer = parseAnswer(answer).strip().lower()
    print("After parsing:",answer)
    el.send_keys(Keys.SPACE) # hide answer
    time.sleep(0.5)
    send(el, answer, 100) # send answer
    time.sleep(0.1)
    el.send_keys(Keys.SPACE) # see answer
    time.sleep(0.2)
def completeCards(chapter, browser=browser): # incomplete
    # find cards button
    if(findXpath("//*[@id='frmchapter']/div[2]/div").get_attribute('data-original-title') == '100% Completed'):
        print("Cards are 100% completed\nSkipping chapter: ", chapter)
        return
    else:
        browser.switch_to_default_content()
        browser.find_element_by_xpath("//*[@id='frmchapter']/div[2]/div//span").click()
        time.sleep(2)
        browser.switch_to_frame(findID("test_frame"))
        questionsTotal = 0
        findButton = False
        while findButton == False:
            try:
                questionsTotal = int(browser.find_element_by_xpath("//*[@id='card_start']/small").get_attribute('innerHTML')[:2])
                browser.find_element_by_xpath("//*[@id='card_start']").click()
                print("starting cards")
                findButton = True
            except Exceptions.ElementNotVisibleException:
                print("Terminating current Cards section")
                buttonTermination = findXpath("//*[@id='terminate_test_pre']")
                buttonTermination.click()
                findXpath("//*[@id='terminate_flashcard_session']/div/div/div[3]/button[1]").click()

        browser.switch_to_default_content()
        WebDriverWait(browser, 20).until(EC.frame_to_be_available_and_switch_to_it((By.ID, "test_frame")))
        print("total questions: {}".format(questionsTotal))
        for x in range(questionsTotal):
            WebDriverWait(browser, 20).until(EC.visibility_of_element_located((By.XPATH, "//*[@id='flash_card']/div[2]/div/div")))
            browser.find_element_by_tag_name("body").send_keys('c')
            print("Card {} completed".format(x+1))
        findXpath("/html/body/footer/div/form/div/div[2]/button[4]/small").click()
def goToChapter(chapter, browser=browser):
    browser.get("https://www.ucertify.com/?func=ebook&chapter_no={}".format(chapter))
    #WebDriverWait.until(EC.visibility_of_all_elements_located((By.TAG_NAME, "body")))
# *****************************************************************************
#   Main
# *****************************************************************************
def main():
    print('logging in')
    login("https://www.ucertify.com/")
    chapter = int(input("Which chapter would you like to begin at: "))
    openLibraryandChapter(chapter)
    for x in range(chapter, 14):
        quiz()
        #completeCards(chapter)
        print("going to chapter".format(x))
        goToChapter(x+1)

if __name__ == '__main__':
    main()
