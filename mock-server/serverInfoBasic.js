const mockserver = require('mockserver-node');
const client = require('mockserver-client').mockServerClient;
const port = 8080;

mockserver.start_mockserver({
                serverPort: port,
                verbose: true,
                trace: true
            }).then(
                function () {
                    client("localhost",port).mockAnyResponse(
                        {
                            'httpRequest':{
                                "method": "POST",
                                'path': '/infocustomer',
                                "body": {
                                    "id": 1090
                                }
                            },
                            'httpResponse':{
                                'statusCode': 404,
                                'body': JSON.stringify({error:'Not Found'}),
                                'delay':{
                                    'timeUnit': 'MILLISECONDS',
                                    'value': 250
                                }
                            },
                            'times':{
                                "remainingTimes": 2
                            }
                        }
                    ),
                    client("localhost",port).mockAnyResponse(
                        {
                            'httpRequest':{
                                "method": "POST",
                                'path': '/infocustomer',
                                "body": {
                                    "id": 1080
                                }
                            },
                            'httpResponse':{
                                'statusCode': 200,
                                'body': JSON.stringify({id:1080,age:30,name:'Oliver',mail:'oliver@mail.com'}),
                                'delay':{
                                    'timeUnit': 'MILLISECONDS',
                                    'value': 150
                                }
                            },
                            "timeToLive": {
                                "unlimited": true
                            }
                        }
                    ),
                    client("localhost",port).mockAnyResponse(
                        {
                            'httpRequest':{
                                "method": "POST",
                                'path': '/infocustomer',
                                "body": {
                                    "id": 3065
                                }
                            },
                            'httpResponse':{
                                'statusCode': 200,
                                'body': JSON.stringify({id:3065,age:30,name:'Smith',mail:'smith@mail.com'}),
                                'delay':{
                                    'timeUnit': 'MILLISECONDS',
                                    'value': 450
                                }
                            },
                            "timeToLive": {
                                "unlimited": true
                            }
                        }
                    ),
                    client("localhost",port).mockAnyResponse(
                        {
                            'httpRequest':{
                                "method": "POST",
                                'path': '/infocustomer',
                                "body": {
                                    "id": 4575
                                }
                            },
                            'httpResponse':{
                                'statusCode': 200,
                                'body': JSON.stringify({id:3065,age:30,name:'Smith',mail:'smith@mail.com'}),
                                'delay':{
                                    'timeUnit': 'MILLISECONDS',
                                    'value': 700
                                }
                            },
                            "timeToLive": {
                                "unlimited": true
                            }
                        }
                    ),
                    client("localhost",port).mockAnyResponse(
                        {
                            'httpRequest':{
                                "method": "POST",
                                'path': '/infocustomer',
                                "body": {
                                    "id": 2208
                                }
                            },
                            'httpResponse':{
                                'statusCode': 200,
                                'body': JSON.stringify({id:1080,age:30,name:'Oliver',mail:'oliver@mail.com'}),
                                'delay':{
                                    'timeUnit': 'MILLISECONDS',
                                    'value': 150
                                }
                            },
                            "timeToLive": {
                                "unlimited": true
                            }
                        }
                    ),
                    client("localhost",port).mockAnyResponse(
                        {
                            'httpRequest':{
                                "method": "POST",
                                'path': '/infocustomer',
                                "body": {
                                    "id": 4503
                                }
                            },
                            'httpResponse':{
                                'statusCode': 200,
                                'body': JSON.stringify({id:3065,age:30,name:'Smith',mail:'smith@mail.com'}),
                                'delay':{
                                    'timeUnit': 'MILLISECONDS',
                                    'value': 450
                                }
                            },
                            "timeToLive": {
                                "unlimited": true
                            }
                        }
                    ),
                    client("localhost",port).mockAnyResponse(
                        {
                            'httpRequest':{
                                "method": "POST",
                                'path': '/infocustomer',
                                "body": {
                                    "id": 3265
                                }
                            },
                            'httpResponse':{
                                'statusCode': 200,
                                'body': JSON.stringify({id:3065,age:30,name:'Smith',mail:'smith@mail.com'}),
                                'delay':{
                                    'timeUnit': 'MILLISECONDS',
                                    'value': 700
                                }
                            },
                            "timeToLive": {
                                "unlimited": true
                            }
                        }
                    )
                }
            );

// do something

mockserver.stop_mockserver({
                serverPort: port
            });