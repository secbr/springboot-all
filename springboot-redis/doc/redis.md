## Redis简介

Redis：目前使用最广泛的缓存中间件，非关系数据库。

## 存储类型

数据以Key-Value的形式存储，支持以下数据类型：
- String（字符串）
- Hash（哈希）
- List（列表）
- Set（集合）
- Zset（Sorted Set：有序集合）

## 优势

- 性能极高：读的速度可达到110000次/s,写的速度是81000次/s 。
- 丰富的数据类型：Redis支持二进制案例的 Strings, Lists, Hashes, Sets 及 Ordered Sets 数据类型操作。
- 原子性：支持高并发。
- 丰富的特性：Redis还支持 publish/subscribe, 通知, key 过期等等特性。

同时，还支持数据的定时持久化等。
