### Kandinsky-webclient: это простой клиент который подключается к API Kandinsky v.3.0 для генерации картинок

##### Endpoints Api
  1) `/generate/{chatId}` - отправляет запрос на генерацию картинки по шаблону, возвращает картинку закодированую в base64
  2) `/generate/{chatId}/?style=&query=` - отправляет запрос на генерацию картинки по пользовательскому запросу. Где `style` укзываются стиль картинки из 4-х(DEFAULT, ANIME, UHD, KANDINSKY), где `query` текст запроса в ввиде: горы, облака, птицы, если стиль DEFAULT, можно добавить в конец запроса *в стиле Ван гога*. Возвращает картинку закодированую в base64

##### Стэк технологий:
  - Java 17
  - lombok
  - Spring (boot, webflux(client))
