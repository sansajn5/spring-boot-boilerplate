# Backend (Rest API) for Orianna

### This is boilerplate spring API

**Structure has many package providing easy transformation to microservice archicutre**

#### Contains

```bash
Security
Flyway mirgation
Logger
Localization
Sign in/up 
Swagger
Exception handler
Email Service
Mariadb/SQL connector
```

#### Upcoming 
```bash
AOP
OAuth2
Tests for each layer
```

### IMPORTANT - Don't push anything to master branch ever, it will be merged with dev when its needed!

#### How to use git flow?

**Following steps are assuming that you're using gitbash/terminal.**

```bash
# Start from develop branch
git checkout develop
# Create branch with
case **feature** - if is representing a new feature in app feature/name-of-task-from-scrum
case **improvement** - if is representing a improvement of existing feature improvement/name-of-task-from-scrum
case **fix** - if is representing a bug fix/name-of-task-from-scrum
# Steps in terminal/gitbash
git fetch origin
git pull origin develop
git checkout -b feature/crud-organization

# After you finish with task do final
git merge origin/develop (so you can resolve conflicts if they exist!)
git add .
git commit -m 'comment'
git push origin feature/crud-organization

create merge request on gitlab.com and set your task on 'waiting for review'

### Author sansajn5