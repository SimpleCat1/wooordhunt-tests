<p align="right">
<a href="https://visitor-badge-reloaded.herokuapp.com/badge?page_id=daramirra.qaGuruDiploma&color=55acb7&style=flat&logo=Github&text=Hello_Visitors!">
  <img title="|Customized by daramirra|" src="https://visitor-badge-reloaded.herokuapp.com/badge?page_id=daramirra.qaGuruDiploma&color=55acb7&style=flat&logo=Github&text=Hello_Visitors!"/>
  <img title="|Customized by daramirra|" alt="GitHub watchers" src="https://img.shields.io/github/watchers/daramirra/qaGuruDiploma?color=55acb7&logo=github">
</a>
</p>

# Здесь обычный проект по автоматизации тестирования UI(кнопочек :) )


## :rocket: Технологии и инструменты (наведите на картинку курсовром, чтобы прочитать название)

<p  align="center"><code><img width="5%" title="IntelliJ IDEA" src="images/daramirra_IDEA-logo.svg"></code>
<code><img width="5%" title="Java" src="images/daramirra_java-logo.svg"></code>
<code><img width="5%" title="Selenide" src="images/daramirra_selenide-logo.svg"></code>
<code><img width="5%" title="Selenoid" src="images/daramirra_selenoid-logo.svg"></code>
<code><img width="5%" title="Gradle" src="images/daramirra_gradle-logo.svg "></code>
<code><img width="5%" title="JUnit5" src="images/daramirra_junit5-logo.svg"></code>
<code><img width="5%" title="Allure Report" src="images/daramirra_allure-Report-logo.svg"></code>
<code><img width="5%" title="Allure TestOps" src="images/daramirra_allure-ee-logo.svg"></code>
<code><img width="5%" title="Github" src="images/daramirra_git-logo.svg"></code>
<code><img width="5%" title="Jenkins" src="images/daramirra_jenkins-logo.svg"></code>
<code><img width="5%" title="Jira" src="images/daramirra_jira-logo.svg"></code>
<code><img width="5%" title="Telegram" src="images/daramirra_Telegram.svg"></code></p>
Кратко опишу ,что в проекте реализовано: 

Код написан на `Java` в нем использовался,
`JavaFaker` ,чтобы рандомные слова использовались в тестах, а не одни и те же
`Owner` , для сокрытия данных
`Allure`, для генерации отчетов
`Jenkins`, инструмент, чтобы запускать всю сборку с определенными параметрами на удаленном компьютере с хранением отчетов запуска и предыдущих сборок
отправка отчета в `Telegram`, а также `Allure TestOps`, где привязывали наши автоматические тесты с тест-кейсами и отправляли результат прохождения из Jenkins -> Allure TestOps -> `Jira` , где удобно было видеть тот же результат пройденных тест-кейсов по автотестам
используется фреймворк `JUnit 5`, тесты могут запускаться удаленно, через `Selenoid`,где используется для запуска браузеров контейнеры `Docker`, так и локально можно запустить

## :spiral_notepad: Реализованы проверки

### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; UI

> - [x] *Проверка авторизации, по тексту на главноей странице, после авторизации на сайте*
>- [x] *Справка на сайте работает, у авторизованного пользователя(проверяем по заголовку)*
>- [x] *Релевантность поиска слов в Input у авторизованного пользователя*
>- [x] *Запоминание слова в столбце, которые искали в Input на сайте в столбце "Истории слов", у авторизованного пользователя*
>- [x] *Запоминание слов в столбце последовательно, которые искали в Input на сайте в столбце "Истории слов", у авторизованного пользователя*
>- [x] *Вкладка "Упражнение" работает, проверяем по загловку, для неавторизованного пользователя*
>- [x] *Вкладка "Разное" работает, проверяем по загловку, для неавторизованного пользователя*


## :computer: Запуск тестов из терминала

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:green_circle:&nbsp;&nbsp;*Запуск тестов с локально, с вашего компьютера, при условии, что у вас установлены окружения*
Скачиваем этот репозиторий и в папке `src/test/resources/config` создаем файл `local.properties`
С данными
```bash
login= Ваш_login_на_сайте_https://wooordhunt.ru/
password= Ваш_password_на_сайте_https://wooordhunt.ru/
remote= not
```
```bash
gradle clean test_ui
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:green_circle:&nbsp;&nbsp;*Запуск тестов на вашем удаленном сервере(желательно использовать Selenoid):*

Скачиваем этот репозиторий и в папке `src/test/resources/config` создаем файл `remoteMy.properties`
С данными 
```bash
login= Ваш_login_на_сайте_https://wooordhunt.ru/
password= Ваш_password_на_сайте_https://wooordhunt.ru/
remote=yes
remoteUrl= Ваш_url_Selenoid
```
```bash
gradle clean -DtestType=remoteMy test_ui
```
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:green_circle:&nbsp;&nbsp;*Запуск тестов в несколько потоков:*
В два потока
```bash
gradle clean -Dthreads=2 -DtestType=remoteMy test_ui
```
В один поток
```bash
gradle clean -Dthreads=1 -DtestType=remoteMy test_ui
```
Больше двух потоков делать нет смысла, тут у меня несколько параллельных тестов, остальные не параллельные

Если нужно запустить в другом браузере, то указываем так
```bash
gradle clean -Dthreads=1 -DtestType=remoteMy -Dbrowser=chrome test_ui
```
```bash
gradle clean -Dthreads=1 -DtestType=remoteMy -Dbrowser=firefox test_ui
```

где:
>- [x] *Dbrowser - браузер, в котором будут выполняться тесты (по умолчанию chrome), по умолчанию будет запускать на максимальном разрешении вашего монитора, а также использоваться последняя версия браузера на вашем же компьютере*
>- [x] *DtestType - указывает на имя файла с настройками окружений, для запуска автотестов, также содержит в себе пароли и логины*
>- [x] *Dthreads - количество потоков выполняющихся тестов (по умолчанию 1)*

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:green_circle:&nbsp;&nbsp;*Запуск тестов в несколько потоков:*

```bash
gradle clean test -Dthreads=[threadsValue]
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:green_circle:&nbsp;&nbsp;*Сформировать allure отчет:*

```bash
allure serve build/allure-results
```

## <img width="4%" title="Jenkins" src="images/daramirra_jenkins-logo.svg"> Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/C07-daramirra-diploma/)

### :pushpin: Параметры сборки

    BROWSER (по умолчанию chrome)(Последняя версия)(максимальный размер вашего монитора)
    BROWSER_VERSION
    TREADS (по умолчанию 1)
    env (окружение, но оно у меня одно, продовское, но оставил, как для выбора, что и это можно настроить)
    testType (файл окружения и паролей)

*Для запуска сборки необходимо указать значения параметров(там где выпадающий список есть, там и меняем) и нажать кнопку <code><strong>*Собрать*</strong></code>.*

<p align="center">
  <img src="images/firefox_wf1rQuMjJb.jpg" alt="job" width="800">
</p>

*После выполнения сборки, в блоке <code><strong>*История сборок*</strong></code> напротив номера сборки появится
значок <img width="2%" title="Allure Report" src="images/daramirra_allure-Report-logo.svg"><code><strong>*Allure
Report*</strong></code>, кликнув по которому, откроется страница с сформированным html-отчетом.*


## <img width="4%" title="Allure Report" src="images/daramirra_allure-Report-logo.svg"> Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/C07-daramirra-diploma/8/allure/)

### :pushpin: Общая информация

*Главная страница Allure-отчета содержит следующие информационные блоки:*

> - [x] <code><strong>*ALLURE REPORT*</strong></code> - отображает дату и время прохождения теста, общее количество прогнанных кейсов, а также диаграмму с указанием процента и количества успешных, упавших и сломавшихся в процессе выполнения тестов
>- [x] <code><strong>*TREND*</strong></code> - отображает тренд прохождения тестов от сборки к сборке
>- [x] <code><strong>*SUITES*</strong></code> - отображает распределение результатов тестов по тестовым наборам
>- [x] <code><strong>*ENVIRONMENT*</strong></code> - отображает тестовое окружение, на котором запускались тесты (в данном случае информация не задана)
>- [x] <code><strong>*CATEGORIES*</strong></code> - отображает распределение неуспешно прошедших тестов по видам дефектов
>- [x] <code><strong>*FEATURES BY STORIES*</strong></code> - отображает распределение тестов по функционалу, который они проверяют
>- [x] <code><strong>*EXECUTORS*</strong></code> - отображает исполнителя текущей сборки (ссылка на сборку в Jenkins)

<p align="center">
  <img src="images/firefox_RtUJnFzfsL.jpg" alt="Allure Report" width="900">
</p>

### :pushpin: Список тестов c описанием шагов и визуализацией результатов

*На данной странице представляется стандартное распределение выполнявшихся тестов по тестовым наборам или классам, в
которых находятся тестовые методы.*

<p align="center">
  <img src="images/firefox_Wz33ODDtPH.jpg" alt="Allure Report" width="900">
</p>

## <img width="4%" title="Allure TestOPS" src="images/daramirra_allure-ee-logo.svg"> Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/651/dashboards)

### :pushpin: Основной дашборд

<p align="center">
  <img src="images/firefox_nC6ZJID7OC.jpg" alt="dashboards" width="900">
</p>

### :pushpin: Запуски

<p align="center">
  <img src="images/firefox_AxyUwjEoIE.jpg" alt="launches" width="900">
</p>

### :pushpin: Тест-кейсы

<p align="center">
  <img src="images/firefox_ErB32sYEfR.jpg" alt="test cases" width="900">
</p>

## <img width="4%" title="Jira" src="images/daramirra_jira-logo.svg"> Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-269)

<p align="center">
  <img src="images/firefox_dzL4efc9xE.jpg" alt="jira" width="1000">
</p>

## <img width="4%" title="Selenoid" src="images/daramirra_selenoid-logo.svg"> Пример запуска теста в Selenoid

<p align="center">
  <img src="images/583391e0a8a517d2419bcf43088a2c95.gif" alt="video" width="1000">
</p>

## <img width="4%" title="Telegram" src="images/daramirra_Telegram.svg"> Уведомления в Telegram

<p align="center">
  <img src="images/Telegram_ICW6JWi03W.jpg" alt="Telegram" width="390">
</p>
