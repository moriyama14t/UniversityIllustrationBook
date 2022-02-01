# 愛知県の大学図鑑


1. アプリ仕様
    - 愛知県の大学の評判を確認できる
    - 内容：大学の評価（勉強・楽しさ・入試難易度）、特徴、強み、世間からの評価、偏差値関連は別のサイトへ飛ばす
    - 管理画面から、大学情報を作成、閲覧はスマホアプリ

1. 機能一覧
    - （管理画面）ログイン・ログアウト機能
    - （管理画面）大学情報作成・編集・削除・取得機能
    - （スマホ）ユーザーから情報取得機能



## 使用技術

1. インフラ
    - 第一弾はHerokuを使用
    - 第二弾でAWSを使用（したい）
    - ローカル（Dockerを使用）

1. バックエンド
    - 言語:Java(v17以上)
    - FW:SpringBoot(v2.6以上)
    - DB:MySql(v6以上)

1. フロントエンド
    - 言語:JavaScript
    - SPA:Nuxt.js

1. スマホ
    - React Native


## 構成図
<img width="823" alt="スクリーンショット 2022-01-15 21 00 50" src="https://user-images.githubusercontent.com/56777467/149621039-354c8f57-75d3-43a7-947b-6f698fbcb652.png">

    
## 参考サイト
[Docker上でSpring Bootを動かしてみる](https://qiita.com/tkani/items/ed56229330f00a333d5e)<br/>
[docker-composeでspring-boot+mysqlのアプリケーションを起動](https://qiita.com/yamii/items/b2b5e6b6a7aff6d590d8)<br/>
[Spring BootプロジェクトをDocker上で動かす](https://zenn.dev/nishiharu/articles/7f27b8c580f896)<br/>
[リモートデバッグ可能なNginx, Spring Boot, MySQLの開発環境をDockerで作った](https://qiita.com/devnokiyo/items/214aa24d60764f0f55f6)<br/>
[docker と docker-compose の初歩](https://qiita.com/hiyuzawa/items/81490020568417d85e86)<br/>
