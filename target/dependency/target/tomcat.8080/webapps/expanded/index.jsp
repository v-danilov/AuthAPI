<%--
  Created by IntelliJ IDEA.
  User: Bounc
  Date: 21.09.2017
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AuthAPI</title>
    <style>
        .container {
            margin: 20px 0 20px 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Добропожаловать в идентификационное API</h1>
    <hr>
    <p>API содержит два метода:</p>
    <ul>
        <li>reg</li>
        <li>auth</li>
    </ul>
    <hr>
    <h3>reg <span style="color: #8a8c8e">метод</span></h3>
    <p>Метод reg содержит два входных параметра:</p>
    <ul>
        <li>login - логин (или меня пользователя) в формате электронной почты. Например, user@user.com</li>
        <li>pass - пароль для дальнейшей авторизации на сервере </li>
    </ul>
    <p>Метод возвращает объекты типа JSON двух видов:</p>
    <ul>
        <li>С типом: <b>ошибка</b> - данный ответ означает, что были поданы неверные данные для регистрации. Данный тип также содержит поле <b><i>message</i></b> с описанием ошибки.
           <br><span style="color: #77787a">Пример: {"type":"error","message":"Wrong login format."}</span>
        </li>
        <li>С типом: <b>успех</b> - успешное выполнение операции. В данном типе также содержится дополнительное поле <b><i>username</i></b> с логином созданного пользователя.
           <br><span style="color: #77787a">Пример: {"type":"success","username":"user@dot.com"}</span>
        </li>
    </ul>
    <h3>auth <span style="color: #8a8c8e">метод</span></h3>
    <p>Метод auth также содержит два входных параметра:</p>
    <ul>
        <li>login - логин (или меня пользователя)</li>
        <li>pass - пароль</li>
    </ul>
    <p>Метод возвращает объекты типа JSON двух видов:</p>
    <ul>
        <li>С типом: <b>ошибка</b> - данный ответ означает, авторизация завершилась неудачей. Данный тип также содержит поле <b><i>message</i></b> с описанием ошибки.
            <br><span style="color: #77787a">Пример: {"type":"error","message":"Wrong password."}</span>
        </li>
        <li>С типом: <b>успех</b> - успешное выполнение операции. В данном типе также содержится дополнительное поле <b><i>username</i></b> с логином созданного пользователя и поле <b><i>key</i>/<b>, содержащее уникальный идентификатор пользвателя.
            <br><span style="color: #77787a">Пример: {"type":"success","key":3,"username":"user@user.com"}</span>
        </li>
    </ul>
</div>
</body>
</html>
