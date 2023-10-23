# Santander Dev Week 2023
Java RESTfull Api criada para a Santander Dev Week

## Diagrama de Classes
```mermaid
classDiagram
  class User {
    - name: String
    - account: Account
    - features: Feature[]
    - card: Card
    - news: News
  }

  class Account {
    - number: String
    - agency: String
    - balance: Double
    - limit: Double
  }

  class Feature {
    - icon: String
    - description: String
  }

  class Card {
    - number: String
    - limit: Double
  }

  class News {
    - icon: String
    - description: String
  }

  User --> Account
  User --> Feature
  User --> Card
  User --> News
```
