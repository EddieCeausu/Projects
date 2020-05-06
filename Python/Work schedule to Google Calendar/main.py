import csv
from datetime import *
import pickle
import os.path
from googleapiclient.discovery import build
from google_auth_oauthlib.flow import InstalledAppFlow
from google.auth.transport.requests import Request
SCOPES = ['https://www.googleapis.com/auth/calendar']
schedule = []

months = {
    'May': 5,
    'June': 6,
    'July': 7,
    'August': 8
}
employees = {
    "Nicole Ceausu": 0,
    "Eddie Ceausu": 1,
    "Sarah Hester": 2, 
    "Anna Haynes": 3,
    "Will Brown": 4,
    "Grant Von Hagen": 5,
    "Makayla Gilder": 6,
    "Stacy Story": 7,
    "Saige Carbaugh": 8,
    "Paul Hester": 9,
    "Kristy Davis": 10,
    "Nicholas Underwood": 11
}
def convertTime(time):
    return str(datetime.strptime(time, '%I:%M%p')).split(' ')[-1]

def grabSchedule(name=1): 
    namedRow = schedule[name]
    namedRow.pop('Total hours\nfor week')
    for key in namedRow.keys():
        if (namedRow[key] == '') or (namedRow[key] == 'NA'):
            namedRow.pop(key)
    return namedRow

def parseEvent(keyValue): #Needs to convert 'Thursday,\nMay 23': '5:00pm-\n9:00pm' to '2019-05-23T21:00:00-04:00 and 2019-05-23T21:00:00-04:00'

    year = str(datetime.now().year)
    time = keyValue[1].replace('\n', '')
    date = keyValue[0]
    startTime, endTime = '', ''
    # parse Time '5:00pm-\n9:00pm' -> 21:00:00-:00
    try:
        startTime = convertTime(time.split('-')[0])
        endTime = convertTime(time.split('-')[-1])
    except Exception as e:
        print "failed to convert time in string: ", startTime, "\nThrew Exception: ", e
        return None
    
    date = date.split('\n', 1)[-1] # removes \n
    for month in months: # converts word month to numerical and replaces ' ' for '-'  
        if date.split(' ', 1)[0] == month:
            date = date.replace(month, str(months[month]), 1).replace(' ', '-', 1)

    dateTimeStart = year + '-0' + date + 'T' + startTime + '-04:00'
    dateTimeEnd = year + '-0' + date + 'T' + endTime + '-04:00'
    return {
        'summary': 'LifeGuarding', 
        'start': {
            'dateTime' : dateTimeStart,
            'timeZone' : 'America/New_York',
        },
        'end': {
            'dateTime' : dateTimeEnd,
            'timeZone' : 'America/New_York',
        },
        'reminders': {
            'useDefault': False,
            'overrides': [
                {'method': 'popup', 'minutes': 30}
            ],
        },

    }
def createEvent(event):
    creds = None
    # The file token.pickle stores the user's access and refresh tokens, and is
    # created automatically when the authorization flow completes for the first
    # time.
    if os.path.exists('token.pickle'):
        with open('token.pickle', 'rb') as token:
            creds = pickle.load(token)
    # If there are no (valid) credentials available, let the user log in.
    if not creds or not creds.valid:
        if creds and creds.expired and creds.refresh_token:
            creds.refresh(Request())
        else:
            flow = InstalledAppFlow.from_client_secrets_file(
                'credentials.json', SCOPES)
            creds = flow.run_local_server()
        # Save the credentials for the next run
        with open('token.pickle', 'wb') as token:
            pickle.dump(creds, token)

    service = build('calendar', 'v3', credentials=creds)
    event = service.events().insert(calendarId='primary', body=event).execute()
    print 'Event created: %s\n' % (event.get('htmlLink'))

def main():
    with open("Schedule.csv") as csvfile:
        reader = csv.DictReader(csvfile, delimiter=',')
        reader.next() #skip header
        for row in reader:
            schedule.append(row)
    #name = input("Which schedule would you like to grab? ")
    currSchedule = grabSchedule()
    print currSchedule, '\n'
    for i in currSchedule:
        print i + ": " + currSchedule[i] + "\n" + str(parseEvent((i, currSchedule[i])))
        event = parseEvent((i, currSchedule[i]))
        if event != None:
            createEvent(event)
        else:
            print "Parsing Error on event: ", event

if __name__ == "__main__":
    main()
        
