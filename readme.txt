1. Для хрома не ставится дополнение (. Долго мучался с ним, все равно ошибки вылазят.
1.1.   Установил в опере постман, но он не дает ссылку на коллекцию, а только позволяет ее экспортить в файл ( ну либо я не нашел).
1.1.1 RESTED_export_Collection.txt - коллекция для импорта.
1.2. Пришлось переделать конфиг проекта потому что Jersey не очень другжит с Java Based Configuration, по-этому такой
 большой коммит.








P.S. Данные на всякий случай для запросов для /add
      {
          "firstName": "Ivan",
          "lastName": "Ivanov",
          "email": "ivanov123@mail.ru",
          "password": "qwerty",
          "phoneNumber": "+380501234967",
          "userRole": "Admin"
      }


     Данные для /update

      {
          "userID": 8,
          "firstName": "Ivan",
          "lastName": "Ivanov",
          "email": "ivanov123@mail.ru",
          "password": "qwerty",
          "confirmPassword": "qwerty",
          "phoneNumber": "+380501234967",
          "karma": 20,
          "userRole": "Admin",
          "addressID": 8,
          "houseNumber": "25B",
          "flatNumber": "34",
          "cityName": "Kharkiv",
          "streetName": "23 Augusta",
          "documentID": 8,
          "documentType": "Passport",
          "series": "BA",
          "number": 123456,
          "issuedBy": "GMVS",
          "dateOfIssue": "2006-12-30"
      }