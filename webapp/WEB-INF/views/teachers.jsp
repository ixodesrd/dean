<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="utf-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/js/bootstrap.min.js" rel="script">
    <%--<script href="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>--%>
    <script href="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script href="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/font-awesome/css/font-awesome.min.css" />

    <script type="text/javascript" src="${contextPath}/resources/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>

    <!-- you need to include the shieldui css and js assets in order for the grids to work -->
    <link rel="stylesheet" type="text/css" href="http://prepbootstrap.com/Content/shieldui-lite/dist/css/light/all.min.css" />
    <script type="text/javascript" src="${contextPath}/resources/js/shieldui-lite-all.min.js"></script>

    <script type="text/javascript" href="http://prepbootstrap.com/Content/data/shortGridData.js"></script>
</head>
<body>
<!-- header Section -->
<header>
    <jsp:include page="menu.jsp"></jsp:include>
</header><!-- end header -->

<div class="container">
    <div id="grid"></div>
    <script type="text/javascript">
        $(function () {
            $("#grid").shieldGrid({
                dataSource: {
                    events: {
                        error: function (event) {
                            if (event.errorType == "transport") {
                                // transport error is an ajax error; event holds the xhr object
                                alert("transport error: " + event.error.statusText);
                                // reload the data source if the operation that failed was save
                                if (event.operation == "save") {
                                    this.read();
                                }
                            }
                            else {
                                // other data source error - validation, etc
                                alert(event.errorType + " error: " + event.error);
                            }
                        }
                    },
                    remote: {
                        read: {
                            type: "GET",
                            url: "/teacher",
                            dataType: "json"
                        },
                        modify: {
                            create: function (items, success, error) {
                                var newItem = items[0];
                                $.ajax({
                                    type: "POST",
                                    url: "/teacher",
                                    dataType: "json",
                                    contentType: "application/json",
                                    data: JSON.stringify(newItem.data),
                                    complete: function (xhr) {
                                        if (xhr.readyState == 4) {
                                            if (xhr.status == 200) {
                                                // update the id of the newly-created item with the
                                                // one returned from the server in the Location hader url
                                                var location = xhr.getResponseHeader("Location");
                                                newItem.data.Id = +location.replace(/^.*?\/([\d]+)$/, "$1");
                                                success();
                                                return;
                                            }
                                        }
                                        error(xhr);
                                    }
                                });
                            },
                            update: function (items, success, error) {
                                $.ajax({
                                    type: "PUT",
                                    url: "/teacher",
                                    dataType: "json",
                                    contentType: "application/json",
                                    data: JSON.stringify(items[0].data)
                                }).then(success, error);
                            },
                            remove: function (items, success, error) {
                                $.ajax({
                                    type: "DELETE",
                                    url: "/teacher/" + items[0].data.id
                                }).then(success, error);
                            }
                        }
                    },
                    schema: {
                        fields: {
                            id: { path: "id", type: Number },
                            age: { path: "age", type: Number },
                            name: { path: "name", type: String },
                            isMale: { path: "isMale", type: Boolean },
                            title: { path: "title", type: String },
                            subject: { path: "subject", type: String },
                        }
                    }
                },
                sorting: true,
                rowHover: false,
                columns: [
                    { field: "name", title: "ФИО", width: 120 },
                    { field: "title", title: "Научность", width: 200 },
                    { field: "age", title: "Возраст", width: 120 },
                    { field: "isMale", title: "Пол", width: 100 },
                    { field: "subject", title: "Дициплина", format: "{0:c}", width: 80 },
                    {
                        width: 140,
                        title: " ",
                        buttons: [
                            { commandName: "edit", caption: "Edit" },
                            { commandName: "delete", caption: "Delete" }
                        ]
                    }
                ],
                toolbar: [
                    {
                        buttons: [
                            { commandName: "insert", caption: "Add teacher" }
                        ],
                        position: "top"
                    },
                    {
                        buttons: [
                            {
                                caption: "Reset teacher List",
                                click: function (e) {
                                    var grid = this;
                                    $.ajax({
                                        type: "GET",
                                        url: "/teacher"
                                    }).done(function () {
                                        grid.dataSource.read();
                                    });
                                }
                            }
                        ],
                        position: "bottom"
                    }
                ],
                paging: {
                    pageSize: 5
                },
                editing: {
                    enabled: true,
                    type: "row"
                }
            });
        });
    </script>
</div>

</body>
</html>