# :wine_glass: Автотесты для мобильного приложения Vivino

<img src="images/Vivino.png">

## :stethoscope: Стек:
| GitHub | IDEA | Java | Junit5 | Gradle | Selenide | Selenoid | Browserstack | Allure Report | Allure TO | Jenkins | Jira |
|:--------:|:-------------:|:---------:|:-------:|:----:|:------:|:----:|:----:|:----:|:------:|:------:|:--------:|
| <img src="images/GitHub.svg" width="40" height="40"> | <img src="images/IDEA.svg" width="40" height="40"> | <img src="images/JAVA.svg" width="40" height="40"> | <img src="images/Junit5.svg" width="40" height="40"> | <img src="images/Gradle.svg" width="40" height="40"> | <img src="images/Selenide.svg" width="40" height="40"> | <img src="images/Selenoid.svg" width="40" height="40"> | <img src="images/Browserstack.svg" width="40" height="40"> | <img src="images/Allure Report.svg" width="40" height="40"> | <img src="images/Allure TestOps.svg" width="40" height="40"> | <img src="images/Jenkins.svg" width="40" height="40"> | <img src="images/Jira.svg" width="40" height="40"> |

## Для запуска тестов используются команды:
```bash
gradle clean test -DdeviceFarm="${DEVICE_FARM}"
```
В качестве параметра `${DEVICE_FARM}` может быть передано:
- browserstack - для запуска в **[Browserstack](https://www.browserstack.com/)**
- selenoid - для запуска в **[Selenoid](https://selenoid.autotests.cloud/wd/hub/)**
- local - для запуска локально через **[Appium](https://appium.io/)**

## Запуск тестов происходит в CI [Jenkins](https://jenkins.autotests.cloud/job/08-krissirin-diplomMobile/)
<img src="images/Jenkins.png">

## Генерация отчетов происходит в [Allure](https://jenkins.autotests.cloud/job/08-krissirin-diplomMobile/allure/)
<img src="images/Allure.png">

## Пример видео из отчета
<img src="images/OnboardingTest.gif">