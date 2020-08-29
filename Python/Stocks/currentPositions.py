from yahoo_fin import stock_info as si

cPositions = { 
    "AAPL":(382.77, 3), 
    "PRPL":(27.15, 40), 
    "ABIO":(6.88, 60), 
    "GENE":(4.24, 20), 
    "BCRX":(4.26, 200), 
    "SINT":(2.13, 250), 
    "SFET":(1.75, 250) 
    }

# output = "Stock price {1}\nTodays High,Low:{2},{3}\nPercent Change{4}\nTodays Volume:{5}\n".format(i.get_price(), i.get_days_high(), i.get_days_low(), i.get_change(), i.get_volume())
for i in cPositions:
    stock = si.get_quote_table(i, dict_result = False)
    print("Stock: {}\nData:\n{}\n".format(i, stock))
