<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Computer description</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/common/header.jspf"%>
<%@include file="/WEB-INF/jsp/common/menu.jsp"%>
<h2>Personal Computer: ${requestScope.computer.model}</h2>
<h3>Price: ${requestScope.computer.price}$</h3>
<p><strong>Case: ${requestScope.computer.cases.model}</strong></p>
<ul type="disc">
    <li>Maker: ${requestScope.computer.cases.maker}</li>
    <li>Material: ${requestScope.computer.cases.material}</li>
    <li>Type of case: ${requestScope.computer.cases.typeOfCase}</li>
    <li>Power Supply Unit: ${requestScope.computer.cases.powerSupplyUnit}</li>
</ul>
<p><strong>CPU: ${requestScope.computer.cpu.model}</strong></p>
<ul type="disc">
    <li>Maker: ${requestScope.computer.cpu.maker}</li>
    <li>Type of processor: ${requestScope.computer.cpu.processorType}</li>
    <li>Number of cores: ${requestScope.computer.cpu.numberOfCores}</li>
    <li>Speed: ${requestScope.computer.cpu.cpuSpeed}</li>
</ul>
<p><strong>Motherboard: ${requestScope.computer.motherBoard.model}</strong></p>
<ul type="disc">
    <li>Maker: ${requestScope.computer.motherBoard.maker}</li>
    <li>Form Factor: ${requestScope.computer.motherBoard.formFactor}</li>
    <li>Memory Technology: ${requestScope.computer.motherBoard.memoryTechnology}</li>
    <li>CPU Socket Type: ${requestScope.computer.motherBoard.cpuSocketType}</li>
</ul>
<p><strong>RAM: ${requestScope.computer.ram.model}</strong></p>
<ul type="disc">
    <li>Maker: ${requestScope.computer.ram.maker}</li>
    <li>Type: ${requestScope.computer.ram.type}</li>
    <li>Memory Capacity: ${requestScope.computer.ram.memoryCapacity}</li>
</ul>
<p><strong>Video card: ${requestScope.computer.videoCard.model}</strong></p>
<ul type="disc">
    <li>Maker: ${requestScope.computer.videoCard.maker}</li>
    <li>RAM Capacity: ${requestScope.computer.videoCard.videoCapacity}</li>
    <li>Graphics Processor: ${requestScope.computer.videoCard.typeGraphicsProcessor}</li>
    <li>Memory Type: ${requestScope.computer.videoCard.typeVideoMemory}</li>
</ul>

</body>
</html>
