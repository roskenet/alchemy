interface Bundesland {
  name: string;
  population: number;
}

var laender: Bundesland[] = [];

laender.push({
  name: 'Hessen',
  population: 16
});

laender.push({
  name: 'Berlin',
  population: 3.8
});

laender.forEach(function(value) {
  console.log(value);
});

function my_function(land: Bundesland): String {
  return ""
}