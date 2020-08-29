import pandas_datareader as web
import datetime

start = datetime.datetime(2020, 1, 1)
end = datetime.datetime(2020, 4, 1)
stock = "amd"
df = web.DataReader(stock, "yahoo", start, end)

df.to_csv('trainingData-{}'.format(stock))

