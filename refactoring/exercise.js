let invoices = {
    "customer": "BigCo",
    "performances": [
      {
        "playID": "hamlet",
        "audience": 55
      },
      {
        "playID": "as-like",
        "audience": 35
      },
      {
        "playID": "othello",
        "audience": 40
      }
    ]
  };
  let plays = {
    "hamlet": {"name": "Hamlet", "type": "tragedy"},
    "as-like": {"name": "As You Like It", "type": "comedy"},
    "othello": {"name": "Othello", "type": "tragedy"}
  };
function statement (invoice, plays) {
    let totalAmount = 0;
    let volumeCredits = 0;
    let result = `Statement for ${invoice.customer}\n`;
    const format = getFormat();

    for (let perf of invoice.performances) {
        const play = plays[perf.playID];
       
        let playAmount = amountFor(play.type, perf);
        // add volume credits
        let volumeCreditOfPlay = getVolumeCredit(play.type, perf);
        // print line for this order
        result += ` ${play.name}: ${format(playAmount/100)} (${perf.audience} seats)\n`;
        totalAmount += playAmount;
        volumeCredits += volumeCreditOfPlay;
    }
    result += `Amount owed is ${format(totalAmount/100)}\n`;
    result += `You earned ${volumeCredits} credits\n`;
    return result;

  
}
function getFormat() {
  return new Intl.NumberFormat("en-US",
    {
      style: "currency", currency: "USD",
      minimumFractionDigits: 2
    }).format;
}

function getVolumeCredit(playType, perf) {
  let volumeCredits = 0;
  volumeCredits += Math.max(perf.audience - 30, 0);
  // add extra credit for every ten comedy attendees
  if ("comedy" === playType) volumeCredits += Math.floor(perf.audience / 5);
  return volumeCredits;
}

function amountFor(playType, perf) {
  let amount = 0;
  //compute Amount
  switch (playType) {
    case "tragedy":
      amount = 40000;
      if (perf.audience > 30) {
        amount += 1000 * (perf.audience - 30);
      }
      break;
    case "comedy":
      amount = 30000;
      if (perf.audience > 20) {
        amount += 10000 + 500 * (perf.audience - 20);
      }
      amount += 300 * perf.audience;
      break;
    default:
      throw new Error(`unknown type: ${playType}`);
  }
  return amount;
}
console.log(statement(invoices,plays));