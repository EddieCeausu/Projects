from datetime import *
months = {
    'May': 5,
    'June': 6,
    'July': 7,
    'August': 8
}
def convertTime(time):
    '''
    if 'pm' in endTime:
    if endTime == '12:00pm':
        time = '12:00'
    else:
        time = str(int(endTime[0:2]) + 12) + ':00:00-'
    elif 'am' in endTime:
    time = endTime.replace('am','') + '-'

    if 'pm' in startTime:
    if startTime == '12:00pm':
        time = '12:00'
    else:
        time = time + str(int(startTime[0:2].replace(':','').replace(' ', '')) + 12) + ':00'
    elif 'am' in startTime:
    startTime = startTime.replace('am','')
    time = (time + startTime[0:1].replace(':', '').zfill(2) + ':' + startTime.split(':')[-1]).replace(' ', '')
    '''
    return str(datetime.strptime(time, '%I:%M%p')).split(' ')[-1]

def parseEvent(keyValue): #Needs to convert 'Thursday,\nMay 23': '5:00pm-\n9:00pm' to '2019-05-23T21:00:00-04:00 and 2019-05-23T21:00:00-04:00'
    year = str(datetime.now().year)
    time = keyValue[1].replace('\n', '')
    date = keyValue[0]
    # parse Time '5:00pm-\n9:00pm' -> 21:00:00-:00
    startTime = convertTime(time.split('-')[0])
    endTime = convertTime(time.split('-')[-1])

    date = date.split('\n', 1)[-1] # removes \n
    for month in months: # converts word month to numerical and replaces ' ' for '-'  
        if date.split(' ', 1)[0] == month:
            date = date.replace(month, str(months[month]), 1).replace(' ', '-', 1)
    dateTimeStart = year + '-0' + date + 'T' + startTime + '-4:00'
    dateTimeEnd = year + '-0' + date + 'T' + endTime + '-4:00'
    return {
        'summary': 'LifeGuarding', 
        'start': {
            'dateTime' : dateTimeStart,
            'timeZone' : 'America/New_York',
        },
        'end': {
            'dateTime' : dateTimeEnd,
            'timeZone' : 'America/New_York',
        }
    }
    
print parseEvent(('Thursday,\nMay 23','5:00pm-\n9:00pm'))


