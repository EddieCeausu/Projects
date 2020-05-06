from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.firefox_binary import FirefoxBinary
from selenium.webdriver.support.ui import WebDriverWait
import selenium.common.exceptions as Exceptions
from selenium.webdriver.support import expected_conditions as EC
import time, random, os
browser = webdriver.Firefox()
subjects = {"biochemistry":180, "biology":180, "oc":180, "gc":298, "physics":135, "math":45, "behavioral-sciences":224}
subjectsGen = {"biochemistry":"Biochemistry", "biology":"Biology", "oc":"OrganicChem", "gc":"GeneralChem", "physics":"Physics", "math":"Math", "behavioral-sciences":"PsychSoc"}
#behavioral-sciences is 225-269
passageSub = {"critical-analysis-and-reasoning-skills":7, "behavioral-sciences":45}
# path: site -> getQuestion -> add to text file

# Pulled from UCertify Completer
def findID(iD, wait=5, brow=browser):
    try:
        l = WebDriverWait(brow, wait).until(EC.visibility_of_element_located((By.ID, iD)))
        return l
    except Exceptions.TimeoutException as e:
        print("Timed Out after 20 seconds\n", e)
        sys.exit()
def findXpath(xpath, wait=5, brow=browser):
    try:
        l = WebDriverWait(brow, wait).until(EC.visibility_of_element_located((By.XPATH, xpath)))
        return l
    except Exceptions.TimeoutException as e:
        print("Timed out after 20 seconds\n", e)
        sys.exit()

def goToQuestion(browser, sub, totalQ):
    print(sub, totalQ)
    question = ""
    for i in range(1, totalQ):
        site = "http://www.maintests.com/mcat/{0}/question-{1}-answer-and-explanation.html".format(sub, i)
        browser.get(site)
        time.sleep(1)
        question += grabQuestion(browser)
        # print(question)
    return question

def grabQuestion(browser):
    # quest = findXpath("/html/body/div/div[2]/div[3]/p[2]").get_attribute("innerHTML").split("</b>",-1)[-1]
    # # print(quest)
    # questNum = findXpath("/html/body/div/div[2]/div[3]/p[1]/strong").get_attribute("innerHTML")
    # # print(questNum)
    # questNL ="\n"
    # questOp = findXpath("/html/body/div/div[2]/div[3]/ul").get_attribute("innerHTML")
    # # print(questOp)
    # questANS = findXpath("/html/body/div/div[2]/div[3]/p[3]").get_attribute("innerHTML").split("</strong>", -1)[-1]
    # # print(questANS)
    # questExp = "\nExplanation:\n" + findXpath("/html/body/div/div[2]/div[3]/p[5]").get_attribute("innerHTML")
    # # print(questExp)
    # return questNum + questNL + quest + questNL + questOp + questNL + "Correct Answer: " + questANS + questExp + questNL

    return "\n".join((
    findXpath("/html/body/div/div[2]/div[3]/p[1]/strong").get_attribute("innerHTML"),
    findXpath("/html/body/div/div[2]/div[3]/p[2]").get_attribute("innerHTML").split("</b>",-1)[-1],
    findXpath("/html/body/div/div[2]/div[3]/ul").get_attribute("innerHTML"), "Correct Answer: ",
    findXpath("/html/body/div/div[2]/div[3]/p[3]").get_attribute("innerHTML").split("</strong>", -1)[-1], "Explanation:", findXpath("/html/body/div/div[2]/div[3]/p[5]").get_attribute("innerHTML")
    ))


def writeToFile(q, sub):
    file = open("Questions/" + str(subjectsGen[sub] + ".txt"), "a")
    file.write(subjectsGen[sub] + ":\n" + q)
    file.close()

def main():
    print(subjects, browser)
    for i in subjects:
        questions = goToQuestion(browser, i, subjects[i])
        time.sleep(2)
        writeToFile(questions, i)

if __name__ == "__main__":
    main()
