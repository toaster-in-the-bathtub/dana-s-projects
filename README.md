# dana-s-projects
Эта программа должна реализовывать следющий функционал: 
- выбрать действие с книгой
  - добавить  в библиотеку
  - взять  
  - вернуть обратно 
  - показать доступные в библиотеке
- выход из программы

все эти опции должны быть заданы пользователем. 

По задумке пользователь: 
1) спрашивает, какие есть книги в библиотеке -> displayAvailable
   1) в библиотеке первоначально нет книг -> "available 0 books"
   2) если в библиотеке присутствуют книги -> выводим колличество доступных и (название, автор) по очереди
2) после этой информации ему предлагается на выбор опции 
   1) если библиотека пуста ->
      - добавить книгу 
      - вернуть книгу 
   2) если есть доступные книги 
      - взять книгу 
      - добавить книгу 
      - вернуть книгу

# доступные команды 
 ## [DisplayAvailableBooks](https://github.com/toaster-in-the-bathtub/dana-s-projects/blob/40c95b6ecc67f6d120b72e8c332f44caa1de95eb/src/Library.java#L100)
1) что делает? 
   1) перебирает список доступных в БД книг и выводит доступные к выбору 
   2) в случае, когда подключение к БД не установлено, сообщает об этом

