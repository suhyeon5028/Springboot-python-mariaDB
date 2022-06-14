from pymysql import connect, cursors
import requests

# mariaDB 연결
conn = connect(host="localhost", user="green",
               password="green1234", db="greendb", charset="utf8")

cursor = conn.cursor(cursors.DictCursor)

# 공공데이터 다운로드
response = requests.get(
    "http://openapi.seoul.go.kr:8088/716371426c6a616532327a59565756/json/RealtimeCityAir/1/25")

responseParse = response.json()["RealtimeCityAir"]["row"]

# DB INSERT
insert_sql = "INSERT INTO air(CO, SO2, MSRRGN_NM, IDEX_MVL, O3, NO2, IDEX_NM, PM10, MSRDT, ARPLT_MAIN, PM25, MSRSTE_NM) VALUES(%(CO)s, %(SO2)s, %(MSRRGN_NM)s, %(IDEX_MVL)s, %(O3)s, %(NO2)s, %(IDEX_NM)s, %(PM10)s, %(MSRDT)s, %(ARPLT_MAIN)s, %(PM25)s, %(MSRSTE_NM)s);"
cursor.executemany(insert_sql, responseParse)
conn.commit()