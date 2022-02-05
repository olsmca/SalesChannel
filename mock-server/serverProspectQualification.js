const mockserver = require('mockserver-node');
const client = require('mockserver-client').mockServerClient;
const port = 8082;

function randomIntFromInterval(min, max) { // min and max included 
    return Math.floor(Math.random() * (max - min + 1) + min)
  }

  mockserver.start_mockserver({
                serverPort: port,
                verbose: true,
                trace: true
            }).then(
                function () {
                    client("localhost",port).mockAnyResponse(
                        {
                            'httpRequest':{
                                "method": "GET",
                                'path': '/prospectqualification',
                            },
                            'httpResponse':{
                                'statusCode': 200,
                                'body': JSON.stringify({qualification:randomIntFromInterval(0, 100)}),
                                'delay':{
                                    'timeUnit': 'MILLISECONDS',
                                    'value': 250
                                }
                            }
                        }
                    )
                }
            );

// do something

mockserver.stop_mockserver({
                serverPort: port
            });