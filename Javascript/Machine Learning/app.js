// Tutorial followed from https://hackernoon.com/machine-learning-with-javascript-part-1-9b97f3ed4fe5
const ml = require('ml-regression');
const csv = require('csvtojson');
const SLR = ml.SLR; // Simple Linear Regression
const csvFile = 'Advertising.csv';
const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin, 
    output: process.stdout
});

let csvData = [], x = [], y = []; // w/ x: input y:output
let regressionModel;

csv()
    .fromFile(csvFile)
    .on('json', (jsonObj) => {
        csvData.push(jsonObj)
    })
    .on('done', () => {
        dressData();
        performRegression();
    });

function dressData() {
    csvData.forEach((row) => {
        x.push(parseFloat(row.Radio));
        y.push(parseFloat(row.Sales));
    });
}

function performRegression() {
    regressionModel = new SLR(x, y);
    console.log(regressionModel.toString(3));
    predictOutput();
}

function predictOutput() {
    rl.question('Enter input x for prediction: ', (answer) => {
        console.log(`predicted output: ${regressionModel.predict(parseFloat(answer))}`)
        predictOutput();
    })
}