# Assignment 3 - Client

Please, to compile the client project execute the following command.
```
ant compile
```

In order to start the standalone HTTP server, execute the following command.
```
ant execute-client
```

The client makes the following requests.
```
Request (method) #1: readPersonList()
Request (method) #2: readPerson(Long id)
Request (method) #3: updatePerson(Person p)
Request (method) #4: createPerson(Person p)
Request (method) #5: deletePerson(Long id)
Request (method) #6: readPersonHistory(Long id, String measureType)
Request (method) #7: readPersonMeasurement(Long id, String measureType, Long mid)
Request (method) #8: savePersonMeasurement(Long id, Measure m)
Request (method) #9: readMeasureTypes()
Request (method) #10: updatePersonMeasure(Long id, Measure m)
Request (method) #11: readPersonMeasureByDates(Long id, String measureType, Date before, Date after)
```