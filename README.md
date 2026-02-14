# MBII Server Info Telegram Bot
A Java-based Telegram bot that provides information about [__MB2 servers__](https://servers.moviebattles.org/) using the official [__API__](https://servers.moviebattles.org/api).  

# Getting started
## Prerequisites
- __Java Development Kit (JDK):__ version 21 or higher.
- __Telegram Bot Token:__ You need to create a bot via [__@BotFather__](https://t.me/botfather) on Telegram and obtain its token.

## Installation & Setup
1. __Clone the repository:__

```bash
git clone https://github.com/Kekbaber/mb2-telegram-servers-bot.git
cd mb2-telegram-servers-bot
```

2. __Configure the bot token:__
    - Open the configuration file (e.g., `src/main/resources/application.yaml`).
    - Replace `bot name` and `bot token` with the token you received from BotFather.
    - (Optional) Adjust any other settings like update interval.

4. __Build the project:__

```bash
mvn clean package
```
4. __Run the bot:__

```bash
java -jar mb2-telegram-servers-bot-1.0.0.jar
```

# License
[__GPL-3.0 license__](LICENSE)

---
__Disclaimer:__ This bot is a community project and is not officially affiliated with the Movie Battles II team. Please use the API responsibly and respect its [__terms of use__](https://servers.moviebattles.org/api).