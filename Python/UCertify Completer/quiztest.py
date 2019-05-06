from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import pyautogui as pag
import time, sys, random, os
# *****************************************************************************
#   Global Functions / Variables
# *****************************************************************************
def send(object, mesg, wpm=60, random_fuzzing=0.1):
    cpm = wpm * 5
    time_per_char = float(60)/float(cpm)
    for char in mesg:
        time.sleep(time_per_char)
        object.send_keys(char)
def parseAnswer(ans):
  ans = ans[:0] + ans[1:]
  ans = "".join(x for x in ans if not x.islower())
  return ans.translate({32: "", 44: "", 46: ""}) # removes SPACE, ",", and "."
# *****************************************************************************
# Main Functions
# *****************************************************************************
def completeQuestion(browser):
    el = browser.find_element_by_tag_name('body')
    el.send_keys(Keys.SPACE)
    time.sleep(1.5)
    answer = browser.find_element_by_class_name("explanation_content").get_attribute("innerHTML").split("<br>", 1)[0]
    print("Before parsing:",answer)
    answer = parseAnswer(answer)
    print("After parsing:",answer)
    el.send_keys(Keys.SPACE)
    time.sleep(0.5)
    send(el, answer)
    time.sleep(0.1)
    el.send_keys(Keys.SPACE)
    time.sleep(0.2)
# *****************************************************************************
# Main
# *****************************************************************************
def main():
    brow = webdriver.Chrome("{}/chromedriver".format(os.path.dirname(os.path.abspath(__file__))))
    currentQuestion = ""
    brow.get("file:///Users/eddieceausu/Desktop/Excess/QuizTesting/Item%201,%20Quiz_%2010.%20Command-Line%20Tools%20-uCertify.htm")
    currentQuestion = brow.find_elements_by_css_selector("._title").get_attribute('innerHTML')
    completeQuestion(brow)
    brow.get("file:///Users/eddieceausu/Desktop/Excess/QuizTesting/Item%202,%20Quiz_%2010.%20Command-Line%20Tools.htm")
    if(brow.find_elements_by_css_selector("._title") == )
    completeQuestion(brow)
    brow.get("file:///Users/eddieceausu/Desktop/Excess/QuizTesting/Item%203,%20Quiz%20%209.%20Network%20Optimization.html")
    completeQuestion(brow)
    time.sleep(20)
if __name__ == '__main__':
    main()
