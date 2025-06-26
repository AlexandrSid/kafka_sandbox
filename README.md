Kafka version 4 without zookeeper

How to run: 1 - start docker-compose (docker compose up -d).
            2 - Stage3+ run kafka-config app once to create topics.
            3 - run reporter and listener - user reporter REST endpoints,
                observe operation in reporter's and listener's consoles.
            use kafka-ui at localhost:8880


Стадия 1 - создание минимального инстанса. 
Продюсер в одном сервисе шлёт сообщение в кафку. 
Кафка развёрнута в докере с одним топиком. Листенер читает это сообщение.

Стадия 2 - много разных топиков под разные типы сообщений.

Стадия 3 - В топиках появляются партиции. Конфигурация топиков вынесена в отдельный компонент

Стадия 4 - вместо одного брокера создаётся кластер. 
В отдельных контейнерах докера должны быть разные инстансы одной кафки. 
Партишены топиков должны оказаться разнесёнными по разным инстансам. 
